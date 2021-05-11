package com.projetspring.appjob.dao;

import com.projetspring.appjob.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoSecteur extends JpaRepository<Secteur,Integer> {

}
