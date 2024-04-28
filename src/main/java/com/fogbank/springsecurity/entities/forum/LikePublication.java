package com.fogbank.springsecurity.entities.forum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fogbank.springsecurity.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
public class LikePublication {
    @Id
    private Long idLike;

    private Date dateLike;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private PublicationGenerale publication;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;



}
