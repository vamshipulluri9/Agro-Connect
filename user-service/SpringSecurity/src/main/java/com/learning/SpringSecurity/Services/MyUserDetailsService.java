package com.learning.SpringSecurity.Services;

import com.learning.SpringSecurity.Model.UserInfo;
import com.learning.SpringSecurity.Model.Users;
import com.learning.SpringSecurity.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user= repo.findByUsername(username);
        if(user==null){
            System.out.println("User not found "+username);
            throw new UsernameNotFoundException("user not found");
        }

        return new UserInfo(user);

    }
}
