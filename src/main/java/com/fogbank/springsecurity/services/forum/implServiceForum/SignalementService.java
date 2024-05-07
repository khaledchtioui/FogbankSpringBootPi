package com.fogbank.springsecurity.services.forum.implServiceForum;

import com.fogbank.springsecurity.Repository.forum.SignalementRepository;
import com.fogbank.springsecurity.entities.forum.PublicationInitiale;
import com.fogbank.springsecurity.entities.forum.SignalementPost;
import com.fogbank.springsecurity.services.forum.ISignalementService;
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
public class SignalementService implements ISignalementService {

    private SignalementRepository signalementRepository;

    @Override
    public List<SignalementPost> chargerTous() {
        return signalementRepository.findAll();
    }

    @Override
    public SignalementPost ajouter(SignalementPost signalementPost) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(ZoneId.systemDefault()).toInstant();
        signalementPost.setDateSignalement(Date.from(instant));
        signalementPost.setEtat("non traité");

        return signalementRepository.save(signalementPost);
    }

    @Override
    public void supprimer(SignalementPost signalementPost) {
        signalementRepository.delete(signalementPost);

    }

    @Override
    public SignalementPost modifier(SignalementPost signalementPost) {
        return signalementRepository.save(signalementPost);
    }

    public Optional<SignalementPost> afficherDetails(int id){
        return signalementRepository.findById((long) id);

    }
}
