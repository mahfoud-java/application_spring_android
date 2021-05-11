package com.projetspring.appjob.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Diplome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String denomination;

    @JsonIgnore
    @OneToMany(mappedBy = "diplome")
    private List<Annonce> listeAnnonces;


}
