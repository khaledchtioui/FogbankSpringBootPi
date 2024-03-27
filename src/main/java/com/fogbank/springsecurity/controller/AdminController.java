package com.fogbank.springsecurity.controller;


import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor

public class AdminController {

@Autowired
    UserService userService ;


    @GetMapping
    public ResponseEntity<String> sayHello()
    {
        return ResponseEntity.ok("Hi Admin") ;
    }


    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.removeUser(userId);
    }




}
