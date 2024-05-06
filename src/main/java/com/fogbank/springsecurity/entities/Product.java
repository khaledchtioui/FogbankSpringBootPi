package com.fogbank.springsecurity.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  Integer id;

    private String type;
    private String picture; // Vous pouvez stocker l'image sous forme d'une URL ou d'un chemin de fichier
    private String description;
    private String name;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime datepub;

public Product(){
    this.datepub =LocalDateTime.now();

};

    @OneToOne(mappedBy = "product")
    @JsonIgnore

    private Map map;



    @ManyToOne
    @JsonIgnore
    User userp;
    @OneToOne(mappedBy="productDetail")
    private LostProduct lostProduct;


}
