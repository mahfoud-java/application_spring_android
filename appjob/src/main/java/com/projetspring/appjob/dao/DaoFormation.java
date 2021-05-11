package com.projetspring.appjob.dao;

import com.projetspring.appjob.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoFormation extends JpaRepository<Formation,Integer> {

}
