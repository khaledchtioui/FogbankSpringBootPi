package com.fogbank.springsecurity.entities.forum;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fogbank.springsecurity.entities.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
public class SignalementPost {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int signalementId;

    @ManyToOne(fetch = FetchType.EAGER)
    private PublicationGenerale publication;

        private String commentaire;

    private String etat;


    private Date dateSignalement;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private User user;
}
