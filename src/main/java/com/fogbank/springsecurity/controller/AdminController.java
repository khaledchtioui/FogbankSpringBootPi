package com.fogbank.springsecurity.controller;


import com.fogbank.springsecurity.entities.Profile;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.AuthenticationService;
import com.fogbank.springsecurity.services.ProfileService;
import com.fogbank.springsecurity.services.UserService;
import com.fogbank.springsecurity.services.impl.JWTServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge=3600)
    
public class AdminController {
    @Autowired
    private AuthenticationService authenticationService ;

    @Autowired
   private UserService userService ;


    @Autowired
    private ProfileService profileService ;



    @GetMapping
    public ResponseEntity<String> sayHello()
    {
        User user= authenticationService.getuserfromauthentication();

        return ResponseEntity.ok(user.toString()) ;

    }


    



    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.removeUser(userId);
    }






}
