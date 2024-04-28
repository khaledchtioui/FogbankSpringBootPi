package com.fogbank.springsecurity.services.forum.implServiceForum;

import com.fogbank.springsecurity.Repository.forum.LikePublicationRepository;
import com.fogbank.springsecurity.entities.forum.LikePublication;
import com.fogbank.springsecurity.services.forum.ILikePublicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LikePublicationService implements ILikePublicationService {

    private LikePublicationRepository likePublicationRepository;

    @Override
    public List<LikePublication> chargerTous() {
        return likePublicationRepository.findAll();
    }

    @Override
    public LikePublication ajouter(LikePublication likePublication) {
        return likePublicationRepository.save(likePublication);
    }

    @Override
    public void supprimer(LikePublication likePublication) {
        likePublicationRepository.delete(likePublication);
    }

    @Override
    public LikePublication modifier(LikePublication likePublication) {
        return likePublicationRepository.save(likePublication);
    }
}
