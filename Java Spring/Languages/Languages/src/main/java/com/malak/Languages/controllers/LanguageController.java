package com.malak.Languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.malak.Languages.models.Language;
import com.malak.Languages.services.languageService;

@Controller
public class LanguageController {
	private final languageService languageService;

	public LanguageController(languageService languageService) {
		this.languageService = languageService;
	}

	@RequestMapping("/languages")
	public String index(Model model, Language language) {
		List<Language> langs = languageService.allLanguage();
		model.addAttribute("languages", langs);
		return "index.jsp";
	}

	@RequestMapping(value = "/languages/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}

	@RequestMapping(value = "/languages/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	  @RequestMapping(value="/languages/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Language language = languageService.findLanguage(id);
	        model.addAttribute("language", language);
	        return "edit.jsp";
	    }
	    
	@RequestMapping(value="/languages/{id}", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	languageService.updateLanguage(language);
            return "redirect:/languages";
        }
        
    }
	@RequestMapping(value="/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "show.jsp";
    }
	

	
}