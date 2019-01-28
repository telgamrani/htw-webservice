package htw.service;

import java.util.List;
import java.util.Optional;

import htw.dao.model.Look;

public interface LookService {
	
	Look save(Look look);
	
	void deleteById(Long id);
	
	List<Look> findAll();
	
	List<Look> findByIsPublished(boolean isPublished, int page, int size);
	
	List<Look> findAll(int page, int size);
	
	Optional<Look> findById(Long id);
	
	boolean saveLookImgOnDisk(Look look);
	
	Look saveLookAndArticlesImgUrl(Look look);
	
	int setPublished(boolean isPublished, Look look);
}
