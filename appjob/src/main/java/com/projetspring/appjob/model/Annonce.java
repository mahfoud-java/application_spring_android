package com.projetspring.appjob.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String intitule;

    @Column(columnDefinition = "TEXT")
    private String descriptifDuPoste;

    private int salaire;

    @ManyToOne
    @JoinColumn(name = "id_diplome")
    private Diplome diplome;



}
