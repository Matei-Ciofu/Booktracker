package com.example.booktracker.controller;

import com.example.booktracker.model.User;
import com.example.booktracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> userMap) {
        String username = userMap.get("username");
        String password = userMap.get("password");
        Optional<User> registered = userService.registerUser(username, password);
        return registered.isPresent() ? "User registered!" : "Username already exists.";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> userMap) {
        String username = userMap.get("username");
        String password = userMap.get("password");
        Optional<User> user = userService.login(username, password);
        return user.isPresent() ? "Login successful!" : "Invalid credentials.";
    }
}
