package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.ClubSpace;

public interface IClubSpaceService {
    ClubSpace saveClubSpace(ClubSpace clubSpace);
    void deleteClubSpace(Long clubSpaceId);
    ClubSpace getClubSpaceById(Long clubSpaceId);
}
