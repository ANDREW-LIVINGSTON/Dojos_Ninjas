package com.AL.dojoninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AL.dojoninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	
	
	List<Ninja> findAll();
	
	Optional<Ninja> findById(Long x);
	
	void deleteById(Long id);
	
	Ninja save(Ninja ninja);
}
