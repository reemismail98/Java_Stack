package com.test.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.relationships.models.License;
import com.test.relationships.models.Person;
import com.test.relationships.services.RelationService;

@Controller
public class RelationController {
	    private final RelationService relationService;
	    
	    public RelationController(RelationService relationService) {
	        this.relationService = relationService;
	    }
	    
	    @RequestMapping("/person/new")
	    public String newPerson(@ModelAttribute("person") Person person) {
	        return "person.jsp";
	    }
	    @RequestMapping(value="/person", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
	        if (result.hasErrors()) {
	            return "person.jsp";
	        } else {
	        	relationService.createPerson(person);
	            return "redirect:/person/new";
	        }
	    }
//	    @RequestMapping("/license/new")
//	    public String newLicense(@ModelAttribute("license") License license, Model model) {
//	    	List<Person> persons = relationService.allPersons();
//	        model.addAttribute("persons", persons);
//	        return "license.jsp";
//	    }
	    
	    @RequestMapping("/license/new")
	    public String newLicense(@ModelAttribute("license") License license, Model model) {
	    	List<Person> persons = relationService.unlicenseUsers();
	        model.addAttribute("persons", persons);
	        return "license.jsp";
	    }
	    @RequestMapping(value="/license/new/create", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("license") License license, BindingResult result) {
	        if (result.hasErrors()) {
	            return "license.jsp";
	        } else {
	        	relationService.createLicense(license);
	            return "redirect:/license/new";
	        }
	    }
	    
	    @RequestMapping("/persons/{id}")
	    public String show(@PathVariable("id") Long id,Model model) {
        	Person person=relationService.findPerson(id); 
        	 model.addAttribute("person",person);
         	License license=relationService.findLicenes(id); 
       	 model.addAttribute("license",license);

        	return "profile.jsp";
	        }
}

