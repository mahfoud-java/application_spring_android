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
    private String descriptif;
    private Date datePublication;

    @ManyToOne
    @JoinColumn(name = "id_secteur")
    private Secteur secteur;

    @ManyToOne
    @JoinColumn(name = "id_domaineActivite")
    private DomaineActivite domaineActivite;

    @ManyToOne
    @JoinColumn(name = "id_typeEmploi")
    private TypeEmploi typeEmploi;

    @ManyToOne
    @JoinColumn(name = "id_fonction")
    private Fonction fonction;

    @ManyToOne
    @JoinColumn(name = "id_niveau")
    private Niveau niveau;

    @ManyToOne
    @JoinColumn(name = "id_recruteur")
    private Recruteur recruteur;

}
