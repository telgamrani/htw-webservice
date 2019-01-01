package htw.service;

import java.util.List;
import java.util.Optional;

import htw.dao.model.Look;
import htw.dao.model.json.LookJson;

public interface LookService {
	
	Look save(Look look);
	
	void deleteById(Long id);
	
	List<Look> findAll();
	
	Optional<Look> findById(Long id);
	
	boolean saveLookImgOnDisk(Look look);
}
