package com.test.DojosandNinjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.DojosandNinjas.models.Ninja;
@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	
    List<Ninja> findAll();


}
