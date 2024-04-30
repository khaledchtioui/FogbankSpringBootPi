package com.fogbank.springsecurity.services.forum.implServiceForum;

import com.fogbank.springsecurity.Repository.forum.ReponsePublicationRepository;
import com.fogbank.springsecurity.entities.forum.ReponsePublication;
import com.fogbank.springsecurity.services.forum.IReponsePublicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
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
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(ZoneId.systemDefault()).toInstant();
        reponsePublication.setDatePublication(Date.from(instant));
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
