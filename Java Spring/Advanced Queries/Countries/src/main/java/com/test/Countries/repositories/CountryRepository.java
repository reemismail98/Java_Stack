package com.test.Countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.Countries.models.Countery;

@Repository
public interface CountryRepository extends CrudRepository<Countery, Long> {
	List<Countery> findAll();

	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c  JOIN c.languages l WHERE l.language=?1 ORDER BY l.percentage DESC")
	List<Object[]> findCountryByLanguage(String language);
    @Query("SELECT c.name COUNT(i.id) AS num_city FROM Country c JOIN c.cities i GROUP BY c.id ORDER BY num_city DESC")
    List<Object[]> findNumberCityInCountry();
    @Query("SELECT c  FROM Country c  WHERE c.surface_area < 501 AND c.population > 100000")
    List<Object[]> findCountry();
    @Query("SELECT c  FROM Country c  WHERE c.government_form = 'Constitutional Monarchy' AND c.life_expectancy > 75 AND c.capital > 200")
    List<Object[]> findCountries();
    @Query("SELECT c.region, COUNT(c.id) AS num_countries FROM Country c GROUP BY c.region ORDER BY num_countries DESC")
	List<Object[]> findCountryByRegion();
    
 
}
