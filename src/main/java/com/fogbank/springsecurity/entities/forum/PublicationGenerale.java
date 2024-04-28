package com.fogbank.springsecurity.entities.forum;

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
    @Id
    private long idPublication;

    private String description;

    private Date datePublication;

    @OneToMany()
    private List<LikePublication> likePublicationList =new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;



}
