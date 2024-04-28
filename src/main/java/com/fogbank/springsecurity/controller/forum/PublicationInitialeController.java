package com.fogbank.springsecurity.controller.forum;

import com.fogbank.springsecurity.entities.forum.PublicationInitiale;
import com.fogbank.springsecurity.services.forum.implServiceForum.PublicationInitialeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/PublicationInitiale")
@AllArgsConstructor
public class PublicationInitialeController {

public PublicationInitialeService publicationInitialeService;
    @GetMapping("")
    public List<PublicationInitiale> ChargerTous() {
        return this.publicationInitialeService.chargerTous();
    }

    @DeleteMapping("/{id}")
    public void supprimerPublicationInitiale(@PathVariable Integer id) {
        PublicationInitiale publicationInitiale=new  PublicationInitiale();
        publicationInitiale.setIdPublication(id);
        this.publicationInitialeService.supprimer(publicationInitiale);
    }

    @PostMapping("")
    public PublicationInitiale ajouterPublicationInitiale(@RequestBody PublicationInitiale publicationInitiale){

        return   this.publicationInitialeService.ajouter(publicationInitiale) ;
    }


    @PutMapping("")
    public PublicationInitiale modifierPublicationInitiale(@RequestBody PublicationInitiale publicationInitiale){
        return   this.publicationInitialeService.modifier(publicationInitiale) ;

    }
}
