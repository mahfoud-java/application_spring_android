package com.projetspring.appjob.dao;

import com.projetspring.appjob.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoEntreprise extends JpaRepository<Entreprise,Integer> {

}
