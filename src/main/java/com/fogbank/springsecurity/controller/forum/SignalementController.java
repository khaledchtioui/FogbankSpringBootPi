package com.fogbank.springsecurity.controller.forum;

import com.fogbank.springsecurity.entities.forum.SignalementPost;
import com.fogbank.springsecurity.services.forum.implServiceForum.SignalementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Signalement")
@AllArgsConstructor
public class SignalementController {
    public SignalementService signalementService;

    @GetMapping("")
    public List<SignalementPost> ChargerTous() {
        return this.signalementService.chargerTous();
    }

    @GetMapping("/{id}")
    public Optional<SignalementPost> afficherDetails(@PathVariable Integer id) {
        return this.signalementService.afficherDetails(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerSignalement(@PathVariable Integer id) {
        SignalementPost signalementPost=new SignalementPost();
        signalementPost.setSignalementId(id);
        this.signalementService.supprimer(signalementPost);
    }

    @PostMapping("")
    public SignalementPost ajouterSignalement(@RequestBody SignalementPost signalementPost){

        return   this.signalementService.ajouter(signalementPost) ;
    }


    @PutMapping("")
    public SignalementPost modifierSignalement(@RequestBody SignalementPost signalementPost){
        return   this.signalementService.modifier(signalementPost) ;

    }
}
