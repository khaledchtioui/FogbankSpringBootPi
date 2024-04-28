package com.fogbank.springsecurity.entities;


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
    private Integer IDAdhésion;
    private User Adhérent;
    private LocalDate DateAdhésion;
    @Enumerated(EnumType.STRING)
    private AdhésionStatus Status;
    private String infos_sup;
    @ManyToOne
    Club club;


}
