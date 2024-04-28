package com.fogbank.springsecurity.services;
import com.fogbank.springsecurity.entities.Evenement;
import java.util.List;


public interface EvenementService {
    Evenement createEvenement(Evenement evenement);
    List<Evenement> getAllEvenements();
    Evenement updateEvenement(Long id, Evenement evenement);
    void deleteEvenement(Long id);
}