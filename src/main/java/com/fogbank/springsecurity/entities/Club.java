package com.fogbank.springsecurity.entities;


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

    @OneToMany(mappedBy="club")
    private List<Adhésion> Adhésions;


    @ManyToMany()
    private List<User> users;





}
