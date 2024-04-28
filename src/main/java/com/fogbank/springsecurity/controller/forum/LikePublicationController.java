package com.fogbank.springsecurity.controller.forum;

import com.fogbank.springsecurity.entities.forum.LikePublication;
import com.fogbank.springsecurity.services.forum.implServiceForum.LikePublicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/LikePublication")
@AllArgsConstructor
public class LikePublicationController {
    public LikePublicationService likePublicationService;

    @GetMapping("")
    public List<LikePublication> ChargerTous() {
        return this.likePublicationService.chargerTous();
    }

    @DeleteMapping("/{id}")
    public void supprimerLikePublication(@PathVariable Long id) {
        LikePublication likePublication=new LikePublication();
        likePublication.setIdLike(id);
        this.likePublicationService.supprimer(likePublication);
    }

    @PostMapping("")
    public LikePublication ajouterLikePublication(@RequestBody LikePublication likePublication){

        return   this.likePublicationService.ajouter(likePublication) ;
    }


}
