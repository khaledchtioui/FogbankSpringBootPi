package com.fogbank.springsecurity.services.forum;

import com.fogbank.springsecurity.entities.forum.PublicationInitiale;

import java.util.Optional;

public interface IPublicationInitialeService extends ICrudService<PublicationInitiale> {
    public Optional<PublicationInitiale> afficherDetails(int id);
}
