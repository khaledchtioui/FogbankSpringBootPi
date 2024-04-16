package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.EvenementRepository;
import com.fogbank.springsecurity.entities.Evenement;
import com.fogbank.springsecurity.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EvenementServiceImpl implements EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    @Override
    public Evenement createEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @Override
    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement updateEvenement(Long id, Evenement evenement) {
        Optional<Evenement> existingEvenementOptional = evenementRepository.findById(id);
        if (existingEvenementOptional.isPresent()) {
            Evenement existingEvenement = existingEvenementOptional.get();

            existingEvenement.setTitre(evenement.getTitre());
            existingEvenement.setDescription(evenement.getDescription());
            existingEvenement.setDateDebut(evenement.getDateDebut());
            existingEvenement.setDateFin(evenement.getDateFin());
            existingEvenement.setLieu(evenement.getLieu());
            return evenementRepository.save(existingEvenement);
        } else {
            throw new RuntimeException("Evenement not found with id: " + id);
        }
    }

    @Override
    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);
    }


}
