package com.projetspring.appjob.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Candidat extends Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean permisB;
    private boolean disponible;
    private String intitule;
    private boolean visible;

    @ManyToMany
    @JoinTable(name = "langue_candidat",
            joinColumns = @JoinColumn(name = "id_candidat" ),
            inverseJoinColumns = @JoinColumn(name = "id_langue"))
    private List<Langue> listeLangues;

    @ManyToMany
    @JoinTable(name = "type_emploi_candidat",
            joinColumns = @JoinColumn(name = "id_candidat" ),
            inverseJoinColumns = @JoinColumn(name = "id_type_emploi"))
    private List<TypeEmploi> listeTypeEmplois;

    @ManyToMany
    @JoinTable(name = "diplome_candidat",
            joinColumns = @JoinColumn(name = "id_candidat" ),
            inverseJoinColumns = @JoinColumn(name = "id_diplome"))
    private List<Diplome> listeDiplomes;

    @ManyToMany
    @JoinTable(name = "experience_candidat",
            joinColumns = @JoinColumn(name = "id_candidat" ),
            inverseJoinColumns = @JoinColumn(name = "id_experience"))
    private List<Experience> listeExperiences;

    @ManyToMany
    @JoinTable(name = "annonce_candidat",
            joinColumns = @JoinColumn(name = "id_candidat" ),
            inverseJoinColumns = @JoinColumn(name = "id_annonce"))
    private List<Annonce> listeAnnonces;

    @ManyToOne
    @JoinColumn(name = "id_fonction")
    private Fonction fonction;

    @ManyToOne
    @JoinColumn(name = "id_domaine")
    private DomaineActivite domaineActivite;
}
