package com.projetspring.appjob.Controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.projetspring.appjob.dao.DaoFormation;
import com.projetspring.appjob.model.Formation;
import com.projetspring.appjob.viewJson.MyJsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FormationController {

    DaoFormation daoFormation;

    @Autowired
    public FormationController(DaoFormation daoFormation) {

        this.daoFormation = daoFormation;
    }
@DeleteMapping("del/formation/{id}")
public boolean effacerFormation(@PathVariable int id){
        daoFormation.deleteById(id);
        return true;
}

    @PostMapping("add/formation")
    public boolean listerFormationCandidat(@RequestBody Formation formation) {

       daoFormation.save(formation);

       return true;
    }
}
