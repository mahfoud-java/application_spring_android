package com.projetspring.appjob.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    private String identite;
    private String nomEntreprise;
    private String lieu;

    @ManyToMany
    @JoinTable(name = "role_utilisateur",
            joinColumns = @JoinColumn(name = "id_utilisateur" ),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<Role> listeRoles = new ArrayList<>();
}
