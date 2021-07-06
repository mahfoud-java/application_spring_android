package com.projetspring.appjob.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.projetspring.appjob.viewJson.MyJsonView;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Candidat extends Utilisateur {

    @Id
    private int id;
    
    private String nom;
    
    private String prenom;
    
    private String nomProfil;
    
    private boolean permisB;
    
    private boolean disponible;


    
    @OneToMany(mappedBy = "candidat")
    private List<Competence> listeCompetences;

    
    @OneToMany(mappedBy = "candidat")
    private List<Experience> listeExperiences;

    @JsonView(MyJsonView.VueCandidat.class)
    @OneToMany(mappedBy = "candidat")
    private List<Formation> listeFormations;

}
