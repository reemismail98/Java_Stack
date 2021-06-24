package com.test.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.test.relationships.models.License;
import com.test.relationships.models.Person;
import com.test.relationships.repositories.LicenseRepository;
import com.test.relationships.repositories.PersonRepository;
@Service

public class RelationService {	    // adding the book repository as a dependency
	private final PersonRepository personRepository;
	private final LicenseRepository licenseRepository;

	    public RelationService(PersonRepository personRepository,LicenseRepository licenseRepository) {
	        this.personRepository = personRepository;
	        this.licenseRepository=licenseRepository;
	    }
	    // returns all the books
//	    public List<Person> allPersons() {
//	        return personRepository.findAll();
//	    }
	    public List<Person> unlicenseUsers() {
			return personRepository.findByLicenseIdIsNull();
		}
	    
	    public Person createPerson(Person p) {
	        return personRepository.save(p);
	    }
	    public Person findPerson(Long id) {
	        Optional<Person> optionalPerson = personRepository.findById(id);
	        if(optionalPerson.isPresent()) {
	            return optionalPerson.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public License findLicenes(Long id) {
	        Optional<License> optionalLicense = licenseRepository.findById(id);
	        if(optionalLicense.isPresent()) {
	            return optionalLicense.get();
	        } else {
	            return null;
	        }
	    }
	    
	    
		public License createLicense( License license) {
			return licenseRepository.save(license);
			
		}
	}


