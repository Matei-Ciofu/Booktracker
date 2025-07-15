package com.example.booktracker.service;

import com.example.booktracker.model.User;
import com.example.booktracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> registerUser(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            return Optional.empty();
        }
        User newUser = new User(username, password);
        return Optional.of(userRepository.save(newUser));
    }

    public Optional<User> login(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password));
    }
}
