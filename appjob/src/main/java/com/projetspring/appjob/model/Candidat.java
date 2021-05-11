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
    private String nom;
    private String prenom;
    private String nomProfil;
    private boolean permisB;
    private boolean disponible;

    @ManyToMany
    @JoinTable(name = "type_emploi_candidat",
            joinColumns = @JoinColumn(name = "id_candidat" ),
            inverseJoinColumns = @JoinColumn(name = "id_type_emploi"))
    private List<TypeEmploi> listeTypeEmplois;

    @OneToMany(mappedBy = "candidat")
    private List<Annonce> listeAnnonces;


    @OneToMany(mappedBy = "candidat")
    private List<Competence> listeCompetences;


    @OneToMany(mappedBy = "candidat")
    private List<Experience> listeExperiences;


    @OneToMany(mappedBy = "candidat")
    private List<Formation> listeFormations;

}
