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
    String titre;
    String image;
    @Column( columnDefinition = "TEXT")
    String contenu;
    Date date;
    @JsonIgnoreProperties("article")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "auteur")
    private User auteur;

    @JsonIgnoreProperties("article")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Likes> likes;
}
