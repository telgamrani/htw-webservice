package htw.service;

import java.util.List;
import java.util.Optional;

import htw.dao.model.Look;

public interface LookService {
	
	Look save(Look look);
	
	void deleteById(Long id);
	
	List<Look> findAll();
	
	Optional<Look> findById(Long id);
}
