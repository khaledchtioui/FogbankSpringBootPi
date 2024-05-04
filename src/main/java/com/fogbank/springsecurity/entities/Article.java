package com.fogbank.springsecurity.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String auteur;
    String titre;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] photo;
    @Column(columnDefinition = "TEXT")
    String contenu;
    Date date;
    @ManyToOne
    private User userarticle;


    @JsonIgnoreProperties("article")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
