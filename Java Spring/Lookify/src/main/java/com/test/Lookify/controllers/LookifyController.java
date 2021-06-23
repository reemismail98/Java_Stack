package com.test.Lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.Lookify.models.Lookify;
import com.test.Lookify.services.lookifyService;

@Controller
public class LookifyController {
	private final lookifyService lookifyService;

	public LookifyController(lookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/dashboard")
	public String display(Model model) {
		List<Lookify> lookify = lookifyService.allLookifies();
		model.addAttribute("lookify", lookify);
		return "dashboard.jsp";
	}


	@RequestMapping("/songs/new")
	public String add(@ModelAttribute("lookify") Lookify lookify) {
		return "add.jsp";
	}

	@RequestMapping(value = "/songs/new", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("lookify") Lookify lookify, BindingResult result) {
		if (result.hasErrors()) {
			return "add.jsp";
		} else {
			lookifyService.createLookify(lookify);
			return "redirect:/dashboard";
		}
	}

	@RequestMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id,Model model) {
    	Lookify lookify=lookifyService.findLookify(id); 
    	 model.addAttribute("lookify",lookify);
    	return "show.jsp";
        }
    
		        @RequestMapping(value="/delete/{id}")
		        public String destroy(@PathVariable("id") Long id) {
		        	lookifyService.deleteLookify(id);
		            return "redirect:/dashboard";
		        }
		        
		        @RequestMapping(value = "/search", method = RequestMethod.POST)
		    	public String search(@RequestParam("search") String search) {
		    		return "redirect:/search/" + search;
		    	}

		    	@RequestMapping(value="/search/{search}", method=RequestMethod.GET)
		    	public String findbyArtist(@PathVariable("search") String search,Model model) {
		    		List<Lookify> songs=lookifyService.searchArtist(search);
		    		model.addAttribute("songs",songs);
		    		model.addAttribute("search",search);
		    		return "search.jsp";
		    	}
		    	
		    	@RequestMapping("/search/topTen")
		    	public String findTopTen(Model model) {
		    		List<Lookify> songs=lookifyService.topTen();
		    		model.addAttribute("songs", songs);
		    		return "topTen.jsp";
		    	}
		    	   
	        

}
