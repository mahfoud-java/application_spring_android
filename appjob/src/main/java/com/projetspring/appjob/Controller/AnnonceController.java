package com.projetspring.appjob.Controller;


import com.projetspring.appjob.dao.DaoAnnonce;
import com.projetspring.appjob.model.Annonce;
import com.projetspring.appjob.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class AnnonceController {

    DaoAnnonce daoAnnonce;
    private JwtUtil jwtUtil;
    @Autowired
    public AnnonceController(DaoAnnonce daoAnnonce,JwtUtil jwtUtil) {

        this.daoAnnonce = daoAnnonce;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/annonces")
    public List<Annonce> listerAnnonces() {
        return daoAnnonce.findAll();
    }

    @GetMapping("/annonces/{id}")
    public Optional<Annonce> getAnnonceById(@PathVariable int id) {

        return daoAnnonce.findById(id);
    }

    @PostMapping("/annonce/add")
    public void addAnnonce(@RequestBody Annonce annonce){
if(annonce.getId() == null)
       daoAnnonce.saveAndFlush(annonce);
else{
    Optional<Annonce> annonceBdd = daoAnnonce.findById(annonce.getId());
    annonceBdd.get().setIntitule(annonce.getIntitule());
    annonceBdd.get().setDescriptifDuPoste(annonce.getDescriptifDuPoste());
    annonceBdd.get().setSalaire(annonce.getSalaire());
    annonceBdd.get().setDiplome(annonce.getDiplome());
daoAnnonce.save(annonceBdd.get());
    }

    }
    @DeleteMapping("/annonce/delete/{id}")
    public ResponseEntity<Integer> deleteNoteListe (@PathVariable int id) {

        if(daoAnnonce.existsById(id)) {
            daoAnnonce.deleteById(id);
            return ResponseEntity.ok(id);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
