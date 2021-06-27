package com.test.Countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.Countries.models.City;
import com.test.Countries.models.Countery;
@Repository
public interface CityRepository extends CrudRepository<City, Long>{
	List<City> findAll();

	 @Query("SELECT i FROM City i JOIN i.Country c WHERE c.name='Mexico' AND  c.population > 500000 ORDER BY c.population DESC")
	    List<City> mexicoCities();
	 @Query("SELECT c.name AS countryName, i.name AS cityName, i.district, i.population FROM City i JOIN i.country c WHERE c.name = 'Argentina' AND i.district = 'Buenos Aires' AND i.population > 500000 ")
		List<Object[]> citiesOfArgentinaInside();
	}

