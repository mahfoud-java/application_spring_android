package com.projetspring.appjob.Controller;


import com.projetspring.appjob.dao.DaoAnnonce;
import com.projetspring.appjob.dao.DaoFormation;
import com.projetspring.appjob.model.Annonce;
import com.projetspring.appjob.model.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AnnonceController {

    DaoAnnonce daoAnnonce;

    @Autowired
    public AnnonceController(DaoAnnonce daoAnnonce) {

        this.daoAnnonce = daoAnnonce;
    }

    @GetMapping("/annonces")
    public List<Annonce> listerAnnonces() {
        return daoAnnonce.findAll();
    }
}
