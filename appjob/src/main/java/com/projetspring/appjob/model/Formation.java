package com.projetspring.appjob.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.projetspring.appjob.viewJson.MyJsonView;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    
    private String intitule;
    
    private String nomEtablissement;
    
    private Date dateObtention;

    @ManyToOne
    @JoinColumn(name = "id_candidat")
    private Candidat candidat;

    
    @ManyToOne
    @JoinColumn(name = "id_diplome")
    private Diplome diplome;

}
