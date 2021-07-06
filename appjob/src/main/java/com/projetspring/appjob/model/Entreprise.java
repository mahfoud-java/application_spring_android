package com.projetspring.appjob.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomEntreprise;

    private String descriptifEntreprise;

    private String type;

    private int taille;

    @ManyToOne
    @JoinColumn(name = "id_secteur")
    private Secteur secteur;

    @OneToMany(mappedBy = "entreprise")
    private List<Annonce> listeAnnonces;
}
