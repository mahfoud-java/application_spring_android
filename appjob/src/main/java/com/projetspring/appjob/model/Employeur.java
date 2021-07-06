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
public class Employeur extends Utilisateur {

    @Id
    private int id;

    private String nomEmployeur;

    private String prenomEmployeur;

    private String fonction;

}
