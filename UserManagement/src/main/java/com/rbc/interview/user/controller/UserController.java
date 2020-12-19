package com.rbc.interview.user.controller;

import com.rbc.interview.user.exceptions.UserNotFoundException;
import com.rbc.interview.user.models.User;

import com.rbc.interview.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // Get a Single User
    @GetMapping("/users/{user-id}")
    public User getUserById(@PathVariable(value = "user-id") String userId) throws UserNotFoundException {
        return userRepo.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }
}

