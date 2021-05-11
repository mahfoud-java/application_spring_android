package com.projetspring.appjob.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private String password;

    private String ville;
    private String pays;
    private int codePostal;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;
}
