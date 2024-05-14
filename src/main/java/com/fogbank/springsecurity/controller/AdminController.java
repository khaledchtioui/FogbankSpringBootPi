package com.fogbank.springsecurity.controller;


import com.fogbank.springsecurity.Repository.UserRepository;
import com.fogbank.springsecurity.entities.*;
import com.fogbank.springsecurity.services.*;
import com.fogbank.springsecurity.services.impl.JWTServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    IAdhésionService adhésionService;
    @Autowired
    IClubSpaceService clubSpaceService;
    @Autowired
    IClubEventService clubEventService;
    @Autowired
    IClubEventComService clubEventComService;


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

    //omar

    @GetMapping("/retrieveAllClubs")
    public List<Club> retrieveAllClubs() {return clubService.retrieveAllClubs();}

    @PostMapping("/addClub")
    public Club addClub(@RequestBody Club club) { return clubService.addClub(club);}
    @PutMapping("/updateClub")
    public Club updateClub(@RequestBody Club club) { return clubService.updateClub(club);}
    @DeleteMapping("/deleteClub/{IDClub}")
    public void deleteClub(@PathVariable("IDClub") Integer IDClub){clubService.removeClub(IDClub);}
    @GetMapping("/retrieveClub/{IDClubb}")
    public Club retrieveClub(@PathVariable("IDClubb") Integer IDClub){ return clubService.retrieveClub(IDClub); }
    @GetMapping("/retrieveAllAdhésion")
    public List<Adhésion> retrieveAllAdhésion(){return adhésionService.retrieveAllAdhésion();}
    @PostMapping("/addAdhésion")
    public Adhésion addAdhésion(@RequestBody Adhésion adhésion){return adhésionService.addAdhésion(adhésion);}
    @GetMapping("/adhesions/user/{userId}")
    public List<Adhésion> retrieveUserAdhesions(@PathVariable Integer userId) {
        return adhésionService.retrieveUserAdhesions(userId);
    }
    @PutMapping("/updateAdhesion")
    public Adhésion updateAdhésion(@RequestBody Adhésion adhésion) { return adhésionService.updateAdhésion(adhésion);}

    @PostMapping("/addspace")
    public ClubSpace addClubSpace(@RequestBody ClubSpace clubSpace) {
        return clubSpaceService.saveClubSpace(clubSpace);
    }

    @DeleteMapping("/deletespace/{id}")
    public void deleteClubSpace(@PathVariable("id") Long clubSpaceId) {
        clubSpaceService.deleteClubSpace(clubSpaceId);
    }

    @GetMapping("/space/{id}")
    public ClubSpace getClubSpaceById(@PathVariable("id") Long clubSpaceId) {
        return clubSpaceService.getClubSpaceById(clubSpaceId);
    }
    @PostMapping("/addclubevent")
    public ClubEvent addEvent(@RequestBody ClubEvent event) {
        return clubEventService.saveEvent(event);
    }

    @DeleteMapping("/deleteclubevent/{id}")
    public void deleteEvent(@PathVariable("id") Long eventId) {
        clubEventService.deleteEvent(eventId);
    }

    @GetMapping("/allclubevent")
    public List<ClubEvent> getAllEvents() {
        return clubEventService.getAllEvents();
    }

    @PostMapping("/addclubeventcom")
    public ClubEventCom addComment(@RequestBody ClubEventCom comment) {
        return clubEventComService.saveComment(comment);
    }

    @DeleteMapping("/deleteclubeventcom/{id}")
    public void deleteComment(@PathVariable("id") Long commentId) {
        clubEventComService.deleteComment(commentId);
    }

    @GetMapping("/allclubeventcom")
    public List<ClubEventCom> getAllComments() {
        return clubEventComService.getAllComments();
    }


    @GetMapping("/adhesions/userr/{clubId}")
    public List<Adhésion> retrieveAdhesionsByClubId(@PathVariable Integer clubId) {
        return adhésionService.retrieveAdhesionsByClubId(clubId);
    }






}
