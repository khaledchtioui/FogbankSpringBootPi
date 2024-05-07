package com.fogbank.springsecurity.services.forum.implServiceForum;

import com.fogbank.springsecurity.Repository.forum.PublicationInitialeRepository;
import com.fogbank.springsecurity.entities.forum.PublicationInitiale;
import com.fogbank.springsecurity.services.forum.IPublicationInitialeService;
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
public class PublicationInitialeService implements IPublicationInitialeService {

    private PublicationInitialeRepository publicationInitialeRepository;

    @Override
    public List<PublicationInitiale> chargerTous() {
        return publicationInitialeRepository.findAll();
    }

    @Override
    public PublicationInitiale ajouter(PublicationInitiale publicationInitiale) {
        publicationInitiale.setVue(0);
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(ZoneId.systemDefault()).toInstant();
        publicationInitiale.setDatePublication(Date.from(instant));
        return publicationInitialeRepository.save(publicationInitiale);
    }

    @Override
    public void supprimer(PublicationInitiale publicationInitiale) {
         publicationInitialeRepository.delete(publicationInitiale);
    }

    @Override
    public PublicationInitiale modifier(PublicationInitiale publicationInitiale) {
        return publicationInitialeRepository.save(publicationInitiale);

    }


    public Optional<PublicationInitiale> afficherDetails(int id){
        Optional<PublicationInitiale> publicationInitiale=publicationInitialeRepository.findById(id);
        if (publicationInitiale.isPresent()) {
            PublicationInitiale publicationInitialee = publicationInitiale.get();
            publicationInitialee.setVue(publicationInitialee.getVue()+1);
            publicationInitialeRepository.save(publicationInitialee);
        }

        return publicationInitiale;

    }
}
