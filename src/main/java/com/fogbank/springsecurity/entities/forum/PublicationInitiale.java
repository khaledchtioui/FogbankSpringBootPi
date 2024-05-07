package com.fogbank.springsecurity.entities.forum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Integer vue;
    private String titre;
    @JsonManagedReference(value = "publicationReponse")
    @OneToMany(mappedBy = "publicationInitiale")
    private List<ReponsePublication> reponsePublicationList =new ArrayList<>();

}
