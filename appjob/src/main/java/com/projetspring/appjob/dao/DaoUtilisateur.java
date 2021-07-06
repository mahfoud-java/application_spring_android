package com.projetspring.appjob.dao;

import com.projetspring.appjob.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DaoUtilisateur extends JpaRepository<Utilisateur,Integer> {
    @Query("FROM Utilisateur u JOIN FETCH u.listeRoles WHERE email = :emailSaisie")
    Optional<Utilisateur> findByEmail(@Param("emailSaisie") String emailSaisie);
}
