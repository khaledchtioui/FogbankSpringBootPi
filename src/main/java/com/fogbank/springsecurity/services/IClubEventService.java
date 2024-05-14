package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.ClubEvent;

import java.util.List;

public interface IClubEventService {
    ClubEvent saveEvent(ClubEvent event);
    void deleteEvent(Long eventId);
    List<ClubEvent> getAllEvents();
}
