package com.fogbank.springsecurity.entities.forum;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
public class ReponsePublication extends PublicationGenerale {

    @JsonBackReference(value = "publicationReponse")
    @ManyToOne
    private PublicationInitiale publicationInitiale;

}
