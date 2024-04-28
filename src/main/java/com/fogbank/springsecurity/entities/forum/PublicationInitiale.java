package com.fogbank.springsecurity.entities.forum;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
public class PublicationInitiale extends PublicationGenerale{

    private String titre;
    @OneToMany()
    private List<ReponsePublication> reponsePublicationList =new ArrayList<>();

}
