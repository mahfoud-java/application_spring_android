package com.projetspring.appjob.dao;

import com.projetspring.appjob.model.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoDiplome extends JpaRepository<Diplome,Integer> {

}
