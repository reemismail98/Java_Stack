package com.test.Countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.Countries.models.City;
import com.test.Countries.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	List<Language> findAll();

	 @Query("SELECT l.language l.percentage  c.name  FROM Language l JOIN l.Country c WHERE l.percentage  > 89% ORDER BY l.percentage  DESC")
	    List<Object[]> languageCities();
	}

