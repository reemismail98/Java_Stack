package com.test.Countries.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.Countries.models.City;
import com.test.Countries.models.Countery;
import com.test.Countries.models.Language;
import com.test.Countries.services.ApiService;
@RestController
public class CountryController {
	private ApiService apiService;
	@GetMapping("/")
	public List<Countery> index() {
		return apiService.getCountries();
	}
	@GetMapping("/{name}")
	public List<Object[]> countryByName(@PathVariable("name") String name) {
		return apiService.getCountryByLanguage(name);
	}
	@GetMapping("/cityCount")
	public List<Object[]> countryByCityCount() {
		return this.apiService.getCountriesByCityCount();
	}
	@GetMapping("/region")
	public List<Object[]> countryByRegion() {
		return apiService.getCountryByRegion();
	}

	@GetMapping("/mexico")
	public List<City> mexicanCities() {
		return apiService.getMexicanCities();
	}
	@GetMapping("/Buenos")
	public List<Object[]> buenosAiresCities() {
		return apiService.getBuenosAiresCities();
	}
	@GetMapping("/l")
	public List<Language> languages() {
		return apiService.getLanguages();
	}
	@GetMapping("/languagues")
	public List<Object[]> countryLanguagues() {
		return apiService.getCountryLanguagues();
	}
}
