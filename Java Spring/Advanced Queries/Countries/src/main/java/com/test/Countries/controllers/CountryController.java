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
	public List<Countery> Index() {
		return apiService.getCountries();
	}
	@GetMapping("/n/{name}")
	public List<Object[]> CountryByName(@PathVariable("name") String name) {
		return apiService.getCountryByLanguage(name);
	}
	@GetMapping("/n/cityCount")
	public List<Object[]> CountryByCityCount() {
		return this.apiService.getCountriesByCityCount();
	}
	@GetMapping("/n/region")
	public List<Object[]> CountryByRegion() {
		return apiService.getCountryByRegion();
	}

	@GetMapping("/c/mexico")
	public List<City> MexicanCities() {
		return apiService.getMexicanCities();
	}
	@GetMapping("/c/arg")
	public List<Object[]> BACities() {
		return apiService.getBuenosAiresCities();
	}
	@GetMapping("/l")
	public List<Language> Languages() {
		return apiService.getLanguages();
	}
	@GetMapping("/l/c")
	public List<Object[]> CountryLangs() {
		return apiService.getCountryLanguagues();
	}
}
