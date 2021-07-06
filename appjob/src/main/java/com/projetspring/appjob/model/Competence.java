package com.projetspring.appjob.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.projetspring.appjob.viewJson.MyJsonView;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;

    
    private String nomCompetence;

    @ManyToOne
    @JoinColumn(name = "id_candidat")
    private Candidat candidat;

    
    @ManyToOne
    @JoinColumn(name = "id_niveau")
    private Niveau niveau;
}
