package com.fogbank.springsecurity.services.forum.implServiceForum;

import com.fogbank.springsecurity.Repository.forum.PublicationInitialeRepository;
import com.fogbank.springsecurity.entities.forum.PublicationInitiale;
import com.fogbank.springsecurity.services.forum.IPublicationInitialeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
