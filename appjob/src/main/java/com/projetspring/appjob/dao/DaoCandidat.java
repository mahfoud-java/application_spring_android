package com.projetspring.appjob.dao;

import com.projetspring.appjob.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoCandidat extends JpaRepository<Candidat,Integer> {


}
