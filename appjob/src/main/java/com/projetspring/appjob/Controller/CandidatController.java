package com.projetspring.appjob.Controller;


import com.projetspring.appjob.dao.DaoCandidat;
import com.projetspring.appjob.model.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class CandidatController {

    DaoCandidat daoCandidat;

    @Autowired
    public CandidatController(DaoCandidat daoCandidat) {
        this.daoCandidat = daoCandidat;
    }

    @GetMapping("/candidat")
    public List<Candidat> getCands(){
        return daoCandidat.findAll();
    }


}
