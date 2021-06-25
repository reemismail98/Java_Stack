package com.test.DojosandNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.test.DojosandNinjas.models.Dojo;
import com.test.DojosandNinjas.models.Ninja;
import com.test.DojosandNinjas.repositories.DojoRepositories;
import com.test.DojosandNinjas.repositories.NinjaRepository;
@Service
public class NinjaDojoService {
	private final NinjaRepository ninjaRepository;
	private final DojoRepositories dojoRepository;
	
	public NinjaDojoService(NinjaRepository ninjaRepository,DojoRepositories dojoRepository) {
		this.ninjaRepository=ninjaRepository;
		this.dojoRepository=dojoRepository;
	}

	public Dojo createDojo( Dojo dojo) {
		return dojoRepository.save(dojo);	
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);	

	}
	public List<Dojo> allDojo() {
        return dojoRepository.findAll();
	}
	public List<Ninja> allNinja() {
        return ninjaRepository.findAll();
	}
	
//	  public Dojo findDojo(Long id) {
//	        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
//	        if(optionalDojo.isPresent()) {
//	            return optionalDojo.get();
//	        } else {
//	            return null;
//	        }
//	    }
	    
	    public Ninja findNinja(Long id) {
	        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
	        if(optionalNinja.isPresent()) {
	            return optionalNinja.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public Dojo findDojo(Long id){
			Optional<Dojo> dojo = dojoRepository.findById(id);
			if(dojo.isPresent()) {
				return dojo.get();
				
			}
			else {
				return null;
			}
		}
	    

}