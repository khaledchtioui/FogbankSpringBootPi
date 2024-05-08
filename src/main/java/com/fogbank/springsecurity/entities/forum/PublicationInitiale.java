package com.fogbank.springsecurity.entities.forum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    @Column(length = 50)
    private String titre;
    private Integer score;
    @JsonManagedReference(value = "publicationReponse")
    @OneToMany(mappedBy = "publicationInitiale",fetch = FetchType.EAGER)
    private List<ReponsePublication> reponsePublicationList =new ArrayList<>();

}
