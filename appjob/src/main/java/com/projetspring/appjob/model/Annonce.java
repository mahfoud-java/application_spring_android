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
    private int id;
    private String intitule;

    @Column(columnDefinition = "TEXT")
    private String descriptifDuPoste;

    private Date datePublication;
    private int salaire;
    private int nbPostes;


    @ManyToOne
    @JoinColumn(name = "id_typeEmploi")
    private TypeEmploi typeEmploi;


    @ManyToOne
    @JoinColumn(name = "id_diplome")
    private Diplome diplome;

    @ManyToOne
    @JoinColumn(name = "id_entreprise")
    private Entreprise entreprise;

    @ManyToOne
    @JoinColumn(name = "id_candidat")
    private Candidat candidat;

}
