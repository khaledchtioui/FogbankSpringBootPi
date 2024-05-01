package com.fogbank.springsecurity.controller;


import com.fogbank.springsecurity.entities.Club;
import com.fogbank.springsecurity.entities.Profile;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.AuthenticationService;
import com.fogbank.springsecurity.services.IClubService;
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
    IClubService clubService;

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
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        userService.removeUser(userId);
    }

    //omar

    @GetMapping("/retrieveAllClubs")
    public List<Club> retrieveAllClubs() {return clubService.retrieveAllClubs();}
    @PostMapping("/addClub")
    public Club addClub(@RequestBody Club club) {
        return clubService.addClub(club);
    }
    @PutMapping("/updateClub")
    public Club updateClub(@RequestBody Club club) { return clubService.updateClub(club);}
    @DeleteMapping("/deleteClub/{IDClub}")
    public void deleteClub(@PathVariable("IDClub") Integer IDClub){clubService.removeClub(IDClub);}
    @GetMapping("/retrieveClub/{IDClubb}")
    public Club retrieveClub(@PathVariable("IDClubb") Integer IDClub){ return clubService.retrieveClub(IDClub); }






}
