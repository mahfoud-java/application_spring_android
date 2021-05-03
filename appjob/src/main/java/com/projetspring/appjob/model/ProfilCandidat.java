package com.projetspring.appjob.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class ProfilCandidat{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String intitule;
    private boolean visible;

    @ManyToOne
    @JoinColumn(name = "id_candidat")
    private Candidat candidat;

    @ManyToMany
    @JoinTable(name = "experience_profil_candidat",
            joinColumns = @JoinColumn(name = "id_profil_candidat" ),
            inverseJoinColumns = @JoinColumn(name = "id_experience"))
    private List<Experience> listeexperiences;

    @ManyToOne
    @JoinColumn(name = "id_fonction")
    private Fonction fonction;

    @ManyToOne
    @JoinColumn(name = "id_domaine")
    private DomaineActivite domaineActivite;
}
