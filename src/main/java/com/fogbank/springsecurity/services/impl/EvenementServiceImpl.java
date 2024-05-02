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
    public Evenement addEvent(Evenement evenement) {

        return evenementRepository.save(evenement);
    }

    @Override
    public List<Evenement> getAllEvent() {

        return evenementRepository.findAll();
    }

    @Override
    public Evenement updateEvent(Long id, Evenement evenement) {
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
    public void deleteEvent(Long id) {

        evenementRepository.deleteById(id);
    }

    @Override
    public Evenement getEvent(Long id) {
        return evenementRepository.findById(id).orElse(null);
    }

    @Override
    public void participateEvent(Long eventId, Long userId) {
        Evenement event = evenementRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + eventId));
        evenementRepository.save(event);
    }




}
