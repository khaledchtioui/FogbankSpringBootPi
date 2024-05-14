package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.ClubEventRepository;
import com.fogbank.springsecurity.entities.ClubEvent;
import com.fogbank.springsecurity.services.IClubEventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ClubEventServiceImpl implements IClubEventService {
    ClubEventRepository clubEventRepository;

    @Override
    public ClubEvent saveEvent(ClubEvent event) {

        event.setDate(LocalDate.now());
        return clubEventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        clubEventRepository.deleteById(eventId);
    }

    @Override
    public List<ClubEvent> getAllEvents() {
        return clubEventRepository.findAll();
    }
}
