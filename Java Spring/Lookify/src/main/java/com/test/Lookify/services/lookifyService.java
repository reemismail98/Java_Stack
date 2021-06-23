package com.test.Lookify.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.test.Lookify.models.Lookify;
import com.test.Lookify.repositories.lookifyRepository;
	@Service
	public class lookifyService {	
	private final lookifyRepository lookifyRepository;
	    
	    public lookifyService(lookifyRepository lookifyRepository) {
	        this.lookifyRepository = lookifyRepository;
	    }
	    public List<Lookify> allLookifies() {
	        return lookifyRepository.findAll();
	    }
	    public Lookify createLookify(Lookify b) {
	        return lookifyRepository.save(b);
	    }
	    public Lookify findLookify(Long id) {
	        Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
	        if(optionalLookify.isPresent()) {
	            return optionalLookify.get();
	        } else {
	            return null;
	        }
	    }
		public void deleteLookify(Long id) {
			   lookifyRepository.deleteById(id);
			
		}
		 public List<Lookify> searchArtist(String artist) {
			 return lookifyRepository.findByArtistContaining(artist);
		 }
		 public List<Lookify> topTen(){
				return lookifyRepository. findTop10ByOrderByRatingDesc();
			}
			
}
