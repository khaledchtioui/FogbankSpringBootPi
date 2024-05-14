package com.fogbank.springsecurity.services.impl;


import com.fogbank.springsecurity.Repository.ClubRepository;
import com.fogbank.springsecurity.entities.Club;
import com.fogbank.springsecurity.services.IClubService;
import com.fogbank.springsecurity.utils.ImageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ClubServiceImpl implements IClubService {
    ClubRepository clubRepository;
    @Override
    public List<Club> retrieveAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public Club addClub(Club club) {return clubRepository.save(club);}

    @Override
    public Club updateClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public void removeClub(Integer IDClub) {
        if(clubRepository.existsById(IDClub)){clubRepository.deleteById(IDClub);
            System.out.println("Club with ID " + IDClub + " has been deleted successfully.");}
        else {System.out.println("Club with ID " + IDClub + " does not exist.");}

    }

    @Override
    public Club retrieveClub(Integer IDClub) {
        return clubRepository.findById(IDClub).orElse(null);
    }





}
