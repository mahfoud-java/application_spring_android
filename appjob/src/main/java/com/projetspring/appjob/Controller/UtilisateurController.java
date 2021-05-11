package com.projetspring.appjob.Controller;


import com.projetspring.appjob.dao.DaoUtilisateur;
import com.projetspring.appjob.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UtilisateurController {

    DaoUtilisateur daoUtilisateur;

    @Autowired
    public UtilisateurController(DaoUtilisateur daoUtilisateur) {
        this.daoUtilisateur = daoUtilisateur;
    }

    @GetMapping("/utilisateurs")
    public List<Utilisateur> chercher() {

        return daoUtilisateur.findAll();
    }

    @GetMapping("/utilisateur/{id}")
    public Optional<Utilisateur> chercher(@PathVariable int id) {

        return daoUtilisateur.findById(id);
    }

    @PutMapping("/utilisateur")
    public boolean editUser(@RequestBody Utilisateur utilisateur){
        Optional<Utilisateur> ancienUtilisateur =
                daoUtilisateur.findById(utilisateur.getId());

            Utilisateur utilisateurBdd = ancienUtilisateur.get();
            utilisateurBdd.setPays(utilisateur.getPays());

            daoUtilisateur.save(utilisateurBdd);
            return true;

    }
}
