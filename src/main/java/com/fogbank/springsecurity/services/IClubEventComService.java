package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.ClubEventCom;

import java.util.List;

public interface IClubEventComService {

    ClubEventCom saveComment(ClubEventCom comment);
    void deleteComment(Long commentId);
    List<ClubEventCom> getAllComments();
}
