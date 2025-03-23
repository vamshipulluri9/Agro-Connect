package com.learning.SpringSecurity.Services;

import com.learning.SpringSecurity.Model.Users;
import com.learning.SpringSecurity.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtService jwtService;

    BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(10);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public List<Users> getUsers() {
        return repo.findAll();
    }

    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authentication.isAuthenticated())return jwtService.generateToken(user.getUsername());
        else return "failure";
    }
}
