package com.fogbank.springsecurity.services;
import com.fogbank.springsecurity.entities.Evenement;
import java.util.List;


public interface EvenementService {
    Evenement addEvent(Evenement evenement);
    List<Evenement> getAllEvent();
    Evenement updateEvent(Long id, Evenement evenement);
    void deleteEvent(Long id);
    Evenement getEvent(Long id);
    void participateEvent(Long eventId, Long userId) ;



    }