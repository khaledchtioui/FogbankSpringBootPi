package com.fogbank.springsecurity.entities.forum;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fogbank.springsecurity.entities.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public  class  PublicationGenerale {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long idPublication;
    @Column(length = 5000)
    private String description;

     boolean visibility;

    private Date datePublication;

    @OneToMany(mappedBy = "publication",fetch = FetchType.EAGER)
    @JsonManagedReference(value = "publicationReference")
    private List<LikePublication> likePublicationList =new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;



}
