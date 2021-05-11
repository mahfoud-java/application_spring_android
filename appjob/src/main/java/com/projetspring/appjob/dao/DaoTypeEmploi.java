package com.projetspring.appjob.dao;

import com.projetspring.appjob.model.TypeEmploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoTypeEmploi extends JpaRepository<TypeEmploi,Integer> {

}
