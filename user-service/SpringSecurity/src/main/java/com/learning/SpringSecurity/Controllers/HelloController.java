package com.learning.SpringSecurity.Controllers;

import com.learning.SpringSecurity.Model.Users;
import com.learning.SpringSecurity.Repositories.UserRepo;
import com.learning.SpringSecurity.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    UserRepo repo;

    @Autowired
    UserService service;

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "hello spring security!"+ request.getSession().getId();
    }

    @PostMapping("/users")
    public Users addUser(@RequestBody Users user){
        return service.register(user);
    }

    @GetMapping("/users")
    public List<Users> getUsers(){
        return service.getUsers();
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return service.verify(user);
    }
}
