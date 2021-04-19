package com.AL.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.AL.dojoninjas.models.Ninja;
import com.AL.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	// adding the book repository as a dependency
    private final NinjaRepository ninjaRepository;
    
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    // returns all the books
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    // creates a book
    public Ninja createNinja(Ninja n) {
        return ninjaRepository.save(n);
    }
    // retrieves a book
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
    public Ninja updateNinja(Ninja n) {
    	return ninjaRepository.save(n);
    }
    
    public void deleteNinja(Long id) {
    	ninjaRepository.deleteById(id);
    }
    
    public Ninja saveNinja(Ninja n) {
    	return ninjaRepository.save(n);
    }
}
