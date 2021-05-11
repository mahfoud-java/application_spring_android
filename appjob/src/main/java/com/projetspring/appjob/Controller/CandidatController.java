package com.projetspring.appjob.Controller;


import com.projetspring.appjob.dao.DaoCandidat;
import com.projetspring.appjob.model.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CandidatController {

    DaoCandidat daoCandidat;

    @Autowired
    public CandidatController(DaoCandidat daoCandidat) {
        this.daoCandidat = daoCandidat;
    }

    @GetMapping("/candidats")
    public List<Candidat> chercher() {

        return daoCandidat.findAll();
    }

    @GetMapping("/candidat/{id}")
    public Optional<Candidat> chercher(@PathVariable int id) {

        return daoCandidat.findById(id);
    }

    @PutMapping("/candidat")
    public boolean editCandidat(@RequestBody Candidat candidat){
        Optional<Candidat> ancienCandidat =
                daoCandidat.findById(candidat.getId());

        Candidat candidatBdd = ancienCandidat.get();
        candidatBdd.setNom(candidat.getNom());
        candidatBdd.setPrenom(candidat.getPrenom());
        candidatBdd.setVille(candidat.getVille());
        candidatBdd.setCodePostal(candidat.getCodePostal());
        candidatBdd.setPays(candidat.getPays());
        candidatBdd.setEmail(candidat.getEmail());
            
            daoCandidat.save(candidatBdd);
            return true;

    }
}
