package com.fogbank.springsecurity.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Club implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer IDClub;
    private String Nom;
    @Enumerated(EnumType.STRING)
    private Catégorie Cat;
    private String Description;
    private String Email;
    private String RS;
    private String image;


    @ManyToMany(mappedBy = "clubs")
    private List<User>users;

    @JsonIgnoreProperties(value = {"club"}, allowSetters = true)
    @OneToMany(mappedBy = "club")
    //@JsonManagedReference(value="firstback")
    private List<Adhésion>adhésions;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "club", fetch = FetchType.LAZY)
    @JsonIgnore // Optionally, if you want to prevent infinite recursion in JSON serialization
    private ClubSpace clubSpace;





}
