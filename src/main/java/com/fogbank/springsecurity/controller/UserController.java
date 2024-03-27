package com.fogbank.springsecurity.controller;


import com.fogbank.springsecurity.entities.Profile;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.AuthenticationService;
import com.fogbank.springsecurity.services.ProfileService;
import com.fogbank.springsecurity.services.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor

public class UserController {




    @Autowired
    private ProfileService profileService ;


    @Autowired
    private   AuthenticationService authenticationService ;

    @GetMapping
    public ResponseEntity<String> sayHello()
    {
      User user= authenticationService.getuserfromauthentication();
        return ResponseEntity.ok(user.toString()) ;

    }


    @PutMapping("/updateProfile")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        profile.setUser(authenticationService.getuserfromauthentication());
        profile.setId(authenticationService.getuserfromauthentication().getProfile().getId());
        Profile updatedProfile = profileService.updateProfile(profile);

        if (updatedProfile != null)
        {
            return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
        } else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }



    }




}
