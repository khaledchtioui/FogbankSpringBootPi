package com.fogbank.springsecurity.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Adhésion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IDAdhesion;
    private LocalDate DateAdhesion;
    @Enumerated(EnumType.STRING)
    private AdhésionStatus Status;
    private String QuestionOne;
    private String QuestionTwo;
    private String QuestionThree;
    private String QuestionFour;
    private String QuestionFive;
    private String QuestionSix;
    private String QuestionSeven;
    private String QuestionEight;
    private String QuestionNine;

    @ManyToOne
    //@JsonBackReference(value="firstback")
    Club club;

    @ManyToOne
    @JsonBackReference(value="secondback")
    User user;


}
