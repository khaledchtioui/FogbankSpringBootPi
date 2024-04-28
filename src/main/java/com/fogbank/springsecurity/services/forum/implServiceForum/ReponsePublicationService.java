package com.fogbank.springsecurity.services.forum.implServiceForum;

import com.fogbank.springsecurity.Repository.forum.ReponsePublicationRepository;
import com.fogbank.springsecurity.entities.forum.ReponsePublication;
import com.fogbank.springsecurity.services.forum.IReponsePublicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReponsePublicationService implements IReponsePublicationService {
    private ReponsePublicationRepository reponsePublicationRepository;

    @Override
    public List<ReponsePublication> chargerTous() {
        return reponsePublicationRepository.findAll();
    }

    @Override
    public ReponsePublication ajouter(ReponsePublication reponsePublication) {
        return reponsePublicationRepository.save(reponsePublication);
    }

    @Override
    public void supprimer(ReponsePublication reponsePublication) {
        reponsePublicationRepository.delete(reponsePublication);

    }

    @Override
    public ReponsePublication modifier(ReponsePublication reponsePublication) {
        return reponsePublicationRepository.save(reponsePublication);
    }
}
