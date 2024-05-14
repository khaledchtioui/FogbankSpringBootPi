package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.Club;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IClubService {
List<Club> retrieveAllClubs();
Club addClub (Club club);
Club updateClub (Club club);
public void removeClub(Integer IDClub);
Club retrieveClub(Integer IDClub);

}
