package com.fogbank.springsecurity.services.forum.implServiceForum;

import com.fogbank.springsecurity.Repository.forum.ReponsePublicationRepository;
import com.fogbank.springsecurity.entities.forum.ReponsePublication;
import com.fogbank.springsecurity.services.forum.IReponsePublicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReponsePublicationService implements IReponsePublicationService {
    private ReponsePublicationRepository reponsePublicationRepository;
    private SmsTool smsTool;

    @Override
    public List<ReponsePublication> chargerTous() {
        return reponsePublicationRepository.findByVisibilityTrue();
    }

    @Override
    public ReponsePublication ajouter(ReponsePublication reponsePublication) {
        reponsePublication.setVisibility(true);
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(ZoneId.systemDefault()).toInstant();
        reponsePublication.setDatePublication(Date.from(instant));
      //  smsTool.envoyer("nouvelle reponse recu de la part de "+reponsePublication.getUser().getFirstname(),"+21628168997");
        return reponsePublicationRepository.save(reponsePublication);
    }

    @Override
    public void supprimer(ReponsePublication reponsePublication) {

    }


    public void supprimer(Optional<ReponsePublication> reponsePublicationOptional) {
        if (reponsePublicationOptional.isPresent()) { // Vérifie si l'optionnel contient une valeur
            ReponsePublication reponsePublication = reponsePublicationOptional.get(); // Extrait l'objet de réponse de l'optionnel
            reponsePublication.setVisibility(false); // Modifie la visibilité de la réponse à false
            reponsePublicationRepository.save(reponsePublication); // Enregistre la modification
        } else {
            // Gérer le cas où l'optionnel est vide (pas de réponse de publication à supprimer)
            // Vous pouvez lancer une exception ou gérer ce cas selon vos besoins
            throw new IllegalArgumentException("ReponsePublication optionnel vide");
        }
    }

    @Override
    public ReponsePublication modifier(ReponsePublication reponsePublication) {
        return reponsePublicationRepository.save(reponsePublication);
    }
    public Optional<ReponsePublication> chargerParId(Long id) {
        return reponsePublicationRepository.findById(Math.toIntExact(id));
    }
}
