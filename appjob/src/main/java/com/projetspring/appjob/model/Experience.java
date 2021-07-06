package com.projetspring.appjob.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.projetspring.appjob.viewJson.MyJsonView;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    
    private String nomPoste;
    
    private String nomEntreprise;
    
    private Date debut;
    @JsonView({MyJsonView.VueCandidat.class,})
    private Date fin;
    
    private String descriptifDuPoste;
    @JsonView({MyJsonView.VueCandidat.class,})
    private String ville;
    
    private String pays;


    @ManyToOne
    @JoinColumn(name = "id_candidat")
    private Candidat candidat;
}
