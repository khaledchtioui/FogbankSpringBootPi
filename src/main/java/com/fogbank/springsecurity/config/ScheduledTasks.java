package com.fogbank.springsecurity.config;

import com.fogbank.springsecurity.Repository.forum.PublicationInitialeRepository;
import com.fogbank.springsecurity.entities.forum.PublicationInitiale;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledTasks {
    private final PublicationInitialeRepository publicationInitialeRepository;

    public ScheduledTasks(PublicationInitialeRepository publicationInitialeRepository) {
        this.publicationInitialeRepository = publicationInitialeRepository;
    }

    @Scheduled(fixedRate = 18000) // execute every 3 minutes
    public void doTask() {
        Iterable<PublicationInitiale> publications = publicationInitialeRepository.findAll();
        Date now = new Date();

        for (PublicationInitiale publication : publications) {
            int vue = publication.getVue();
            int likes = publication.getLikePublicationList().size();
            int reponses = publication.getReponsePublicationList().size();
            long publicationTimestamp = publication.getDatePublication().getTime();
            long currentTimestamp = now.getTime();
            int decalageHeure = (int) ((currentTimestamp - publicationTimestamp) / (1000 * 60 * 60));


            int score = (vue / (likes + 1)) * 1000 + (decalageHeure * -1) + (likes * 10) + (reponses * 10);

            publication.setScore(score);
            publicationInitialeRepository.save(publication);
        }
    }
}
