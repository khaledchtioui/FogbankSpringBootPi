package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.AdhésionRepository;
import com.fogbank.springsecurity.entities.Adhésion;
import com.fogbank.springsecurity.entities.Club;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.IAdhésionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdhésionServiceImpl implements IAdhésionService {
    AdhésionRepository adhésionRepository;
    @Override
    public List<Adhésion> retrieveAllAdhésion() {
        return adhésionRepository.findAll();
    }

    @Override
    public Adhésion addAdhésion(Adhésion adhésion) {
        adhésion.setDateAdhesion(LocalDate.now());
        return adhésionRepository.save(adhésion);
    }
    public List<Adhésion> retrieveUserAdhesions(Integer userId) {

        return adhésionRepository.findByUserId(userId);
    }

    @Override
    public List<Adhésion> retrieveAdhesionsByClubId(Integer clubId) {
        return adhésionRepository.findByClubIDClub(clubId);
    }



    @Override
    public Adhésion updateAdhésion(Adhésion adhésion)
    {
        Optional<Adhésion> existingAdhésionOptional = adhésionRepository.findById(adhésion.getIDAdhesion());
        if (existingAdhésionOptional.isPresent()) {
            Adhésion existingAdhésion = existingAdhésionOptional.get();

            // Update the fields that are allowed to be modified
            existingAdhésion.setStatus(adhésion.getStatus());
            // Update other fields as needed

            // Save the updated adhésion
            return adhésionRepository.save(existingAdhésion);
        } else {
            // Handle the case where the adhésion with the given ID is not found
            throw new EntityNotFoundException("Adhésion not found with ID: " + adhésion.getIDAdhesion());
        }
    }


}
