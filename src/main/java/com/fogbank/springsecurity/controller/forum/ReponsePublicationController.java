package com.fogbank.springsecurity.controller.forum;

import com.fogbank.springsecurity.entities.forum.ReponsePublication;
import com.fogbank.springsecurity.services.forum.implServiceForum.ReponsePublicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ReponsePublication")
@AllArgsConstructor
public class ReponsePublicationController {


        public ReponsePublicationService reponsePublicationService;
        @GetMapping("")
        public List<ReponsePublication> ChargerTous() {
            return this.reponsePublicationService.chargerTous();
        }

        @DeleteMapping("/{id}")
        public void supprimerReponsePublication(@PathVariable Integer id) {
            ReponsePublication reponsePublication=new ReponsePublication();
            reponsePublication.setIdPublication(id);
            this.reponsePublicationService.supprimer(reponsePublication);
        }

        @PostMapping("")
        public ReponsePublication ajouterReponsePublication(@RequestBody ReponsePublication reponsePublication){

            return   this.reponsePublicationService.ajouter(reponsePublication) ;

        }


        @PutMapping("")
        public ReponsePublication modifierReponsePublication(@RequestBody ReponsePublication reponsePublication){

            return   this.reponsePublicationService.modifier(reponsePublication) ;

        }
    }

