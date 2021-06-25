package com.test.DojosandNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.DojosandNinjas.models.Dojo;
import com.test.DojosandNinjas.models.Ninja;
import com.test.DojosandNinjas.services.NinjaDojoService;
@Controller
public class NinjaDojoController {
	
    private final NinjaDojoService ninjadojoService;

    public NinjaDojoController(NinjaDojoService ninjadojoService) {
        this.ninjadojoService = ninjadojoService;
    }
    
    @RequestMapping("/dojo/new")
  	public String dojoHome(@ModelAttribute("dojo") Dojo dojo) {
  		return "Dojo.jsp";
  	}
      
      @RequestMapping(value="/dojo", method=RequestMethod.POST)
  	public String create(@Valid @ModelAttribute("dojo") Dojo dojo,BindingResult result) {
  		if (result.hasErrors()) {
              return "Dojo.jsp";
          } else {
        	  ninjadojoService.createDojo(dojo);
              return "redirect:/dojo/new";
          }
  	}
      @GetMapping("/ninja/new")
    	public String ninjaHome(@ModelAttribute("ninja") Ninja ninja,Model model) {
    	    List<Dojo> dojos = ninjadojoService.allDojo();
	        model.addAttribute("dojo", dojos);
    		return "ninja.jsp";
    	}
        
        @RequestMapping(value="/ninja", method=RequestMethod.POST)
    	public String create(@Valid @ModelAttribute("ninja") Ninja ninja,BindingResult result) {
    		if (result.hasErrors()) {
                return "ninja.jsp";
            } else {
          	  ninjadojoService.createNinja(ninja);
                return "redirect:/ninja/new";
            }
    	}
        
    
        
        
        @RequestMapping("/dojo/{id}")
	    public String show(@PathVariable("id") Long id,Model model) {
        	Dojo dojos=ninjadojoService.findDojo(id); 
        	model.addAttribute("dojo",dojos);
        	List <Ninja> ninja=ninjadojoService.allNinja(); 
       	    model.addAttribute("ninja",ninja);

        	return "show.jsp";
	        }
    
}
