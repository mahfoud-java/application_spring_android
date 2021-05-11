package com.projetspring.appjob.Controller;


import com.projetspring.appjob.dao.DaoFormation;
import com.projetspring.appjob.dao.DaoUtilisateur;
import com.projetspring.appjob.model.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class FormationController {

    DaoFormation daoFormation;

    @Autowired
    public FormationController(DaoFormation daoFormation) {

        this.daoFormation = daoFormation;
    }

    @GetMapping("/formations")
    public List<Formation> listerFormationCandidat() {
        return daoFormation.findAll();
    }
}
