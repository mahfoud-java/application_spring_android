package com.projetspring.appjob.dao;

import com.projetspring.appjob.model.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoNiveau extends JpaRepository<Niveau,Integer> {

}
