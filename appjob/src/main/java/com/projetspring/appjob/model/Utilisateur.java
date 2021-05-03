package com.projetspring.appjob.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private String adresse;
    private String ville;
    private String pays;
    private Long codePostal;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;


}
