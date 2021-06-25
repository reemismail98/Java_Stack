package com.test.DojosandNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.DojosandNinjas.models.Dojo;
@Repository
public interface DojoRepositories extends CrudRepository<Dojo, Long>{
	
    List<Dojo> findAll();



}
