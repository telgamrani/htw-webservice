package htw.service;

import java.util.List;

import htw.dao.model.RobotScrapingUrl;


public interface RobotScrapingUrlService {

	List<RobotScrapingUrl> findAll();
	
}
