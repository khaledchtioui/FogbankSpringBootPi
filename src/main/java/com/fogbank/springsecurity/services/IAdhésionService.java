package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.Adhésion;
import com.fogbank.springsecurity.entities.Club;
import com.fogbank.springsecurity.entities.User;

import java.util.List;

public interface IAdhésionService {
    List<Adhésion> retrieveAllAdhésion();
    Adhésion addAdhésion (Adhésion adhésion);
    List<Adhésion> retrieveUserAdhesions(Integer userId);
    List<Adhésion> retrieveAdhesionsByClubId(Integer clubId);
    Adhésion updateAdhésion (Adhésion adhésion);
}
