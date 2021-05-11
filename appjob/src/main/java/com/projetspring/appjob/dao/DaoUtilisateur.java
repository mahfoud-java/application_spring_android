package com.projetspring.appjob.dao;

import com.projetspring.appjob.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoUtilisateur extends JpaRepository<Utilisateur,Integer> {

}
