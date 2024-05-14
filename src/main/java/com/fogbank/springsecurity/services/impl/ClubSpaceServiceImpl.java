package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.ClubSpaceRepository;
import com.fogbank.springsecurity.entities.ClubSpace;
import com.fogbank.springsecurity.services.IClubSpaceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClubSpaceServiceImpl implements IClubSpaceService {
    ClubSpaceRepository clubSpaceRepository;

    @Override
    public ClubSpace saveClubSpace(ClubSpace clubSpace) {
        return clubSpaceRepository.save(clubSpace);
    }

    @Override
    public void deleteClubSpace(Long clubSpaceId) {
        clubSpaceRepository.deleteById(clubSpaceId);
    }

    @Override
    public ClubSpace getClubSpaceById(Long clubSpaceId) {
        return clubSpaceRepository.findById(clubSpaceId).orElse(null);
    }
}
