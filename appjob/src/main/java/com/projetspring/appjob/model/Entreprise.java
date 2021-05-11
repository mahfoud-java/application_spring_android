package com.projetspring.appjob.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Entreprise extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomEntreprise;

    private String descriptifEntreprise;

    @ManyToOne
    @JoinColumn(name = "id_secteur")
    private Secteur secteur;

    @JsonIgnore
    @OneToMany(mappedBy = "entreprise")
    private List<Annonce> listeAnnonces;
}
