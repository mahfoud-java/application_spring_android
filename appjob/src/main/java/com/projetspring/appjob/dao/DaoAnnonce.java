package com.projetspring.appjob.dao;

import com.projetspring.appjob.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoAnnonce extends JpaRepository<Annonce,Integer> {

}
