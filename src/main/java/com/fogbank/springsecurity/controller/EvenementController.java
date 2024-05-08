package com.fogbank.springsecurity.controller;
import com.fogbank.springsecurity.entities.Evenement;
import com.fogbank.springsecurity.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin/events")
@CrossOrigin(origins = "http://localhost:4200")
public class EvenementController {

    @Autowired
    private EvenementService evenementService;

    @PostMapping("/createEvents")
    public Evenement addEvent (@RequestBody Evenement evenement) {

        return evenementService.addEvent(evenement);
    }


    @GetMapping
    public ResponseEntity<List<Evenement>> getAllEvent() {
        List<Evenement> evenements = evenementService.getAllEvent();
        return new ResponseEntity<>(evenements, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Evenement> updateEvent(@PathVariable Long id, @RequestBody Evenement evenement) {
        Evenement updatedEvenement = evenementService.updateEvent(id, evenement);
        return new ResponseEntity<>(updatedEvenement, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        evenementService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Evenement> getEvent(@PathVariable Long id) {
        Evenement event = evenementService.getEvent(id);
        if (event != null) {
            return ResponseEntity.ok().body(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/participate/{eventId}/{userId}")
    public ResponseEntity<String> participateEvent(@PathVariable Long eventId, @PathVariable Long userId) {
        try {
            evenementService.participateEvent(eventId, userId);
            return ResponseEntity.ok("User with ID " + userId + " has participated in event with ID " + eventId + " successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to participate in event: " + e.getMessage());
        }
    }





}