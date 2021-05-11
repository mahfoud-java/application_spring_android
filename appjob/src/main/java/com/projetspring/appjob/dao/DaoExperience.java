package com.projetspring.appjob.dao;

import com.projetspring.appjob.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoExperience extends JpaRepository<Experience,Integer> {

}