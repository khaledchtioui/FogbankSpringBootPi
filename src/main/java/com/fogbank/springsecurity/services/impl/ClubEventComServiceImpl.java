package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.ClubEventComRepository;
import com.fogbank.springsecurity.entities.ClubEventCom;
import com.fogbank.springsecurity.services.IClubEventComService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClubEventComServiceImpl implements IClubEventComService {
    ClubEventComRepository clubEventComRepository;

    @Override
    public ClubEventCom saveComment(ClubEventCom comment) {
        return clubEventComRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        clubEventComRepository.deleteById(commentId);
    }

    @Override
    public List<ClubEventCom> getAllComments() {
        return clubEventComRepository.findAll();
    }
}
