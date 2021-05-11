package com.projetspring.appjob.dao;

import com.projetspring.appjob.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoCompetence extends JpaRepository<Competence,Integer> {

}
