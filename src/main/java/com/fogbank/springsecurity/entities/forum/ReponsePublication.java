package com.fogbank.springsecurity.entities.forum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class ReponsePublication extends PublicationGenerale {

    @JsonIgnore
    @ManyToOne
    private PublicationInitiale publicationInitiale;

}
