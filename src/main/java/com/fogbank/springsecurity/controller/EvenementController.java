package com.fogbank.springsecurity.controller;
import com.fogbank.springsecurity.entities.Evenement;
import com.fogbank.springsecurity.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/evenements")
public class EvenementController {

    @Autowired
    private EvenementService evenementService;

    @PostMapping
    public ResponseEntity<Evenement> createEvenement(@RequestBody Evenement evenement) {
        Evenement createdEvenement = evenementService.createEvenement(evenement);
        return new ResponseEntity<>(createdEvenement, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Evenement>> getAllEvenements() {
        List<Evenement> evenements = evenementService.getAllEvenements();
        return new ResponseEntity<>(evenements, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evenement> updateEvenement(@PathVariable Long id, @RequestBody Evenement evenement) {
        Evenement updatedEvenement = evenementService.updateEvenement(id, evenement);
        return new ResponseEntity<>(updatedEvenement, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvenement(@PathVariable Long id) {
        evenementService.deleteEvenement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}