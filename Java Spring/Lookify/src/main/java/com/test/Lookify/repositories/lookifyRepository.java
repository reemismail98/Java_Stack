package com.test.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.Lookify.models.Lookify;
@Repository
public interface lookifyRepository extends CrudRepository<Lookify, Long>{
	
	    List<Lookify> findAll();

		List<Lookify> findByArtistContaining(String search);
		
		List<Lookify>  findTop10ByOrderByRatingDesc();
	}


