package com.AL.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.AL.dojoninjas.models.Dojo;
import com.AL.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {
	// adding the book repository as a dependency
    private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    // returns all the books
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    // creates a book
    public Dojo createDojo(Dojo d) {
        return dojoRepository.save(d);
    }
    // retrieves a book
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
    public Dojo updateDojo(Dojo d) {
    	return dojoRepository.save(d);
    }
    
    public void deleteDojo(Long id) {
    	dojoRepository.deleteById(id);
    }
    
    public Dojo saveDojo(Dojo d) {
    	return dojoRepository.save(d);
    }
}
