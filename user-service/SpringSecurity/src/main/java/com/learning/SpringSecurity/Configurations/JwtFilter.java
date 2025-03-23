package com.learning.SpringSecurity.Configurations;

import com.learning.SpringSecurity.Model.UserInfo;
import com.learning.SpringSecurity.Services.JwtService;
import com.learning.SpringSecurity.Services.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    JwtService jwtService;

    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authentication");
        String username=null;
        String token=null;

        if(authHeader!=null && authHeader.startsWith("Bearer ")){
            token= authHeader.substring(7);
            username= jwtService.exractUsername(token);
        }

        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userInfo = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);

            if(jwtService.validateToken(userInfo,token)){//creating a authToken for usernamePasswordFilter
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userInfo, null, userInfo.getAuthorities());

                    //making the authToken know the request details
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    //set the built authToken in securityContext holder
                    SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

    }
}
