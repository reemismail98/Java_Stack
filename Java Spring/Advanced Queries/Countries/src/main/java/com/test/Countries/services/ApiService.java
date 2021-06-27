package com.test.Countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.Countries.models.City;
import com.test.Countries.models.Countery;
import com.test.Countries.models.Language;
import com.test.Countries.repositories.CityRepository;
import com.test.Countries.repositories.CountryRepository;
import com.test.Countries.repositories.LanguageRepository;

@Service
public class ApiService {

		private CountryRepository countryRepository;
		private CityRepository cityRepository;
		private LanguageRepository languageRepository;
		
		public List<Countery> getCountries() {
			return countryRepository.findCountries();
		}
	
		public List<Language> getLanguages() {
			return languageRepository.findAll();
		}
		public List<Object[]> getCountryByLanguage(String language) {
			return countryRepository.findCountryByLanguage(language);
		}
		public List<Object[]> getCountryByRegion() {
			return countryRepository.findCountryByRegion();
		}
		public List<Object[]> getCountriesByCityCount() {
			return countryRepository.findNumberCityInCountry();
		}
		public List<Object[]> getCountryLanguagues() {
			return languageRepository.languageCities();
		}
		public List<City> getMexicanCities() {
			return this.cityRepository.mexicoCities();
		}
		public List<Object[]> getBuenosAiresCities() {
			return this.cityRepository.citiesOfArgentinaInside();
		}
}
