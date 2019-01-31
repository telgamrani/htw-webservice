package htw.service;

import java.util.List;

import htw.robot.scraping.model.RobotScrapingUrl;


public interface RobotScrapingUrlService {

	List<RobotScrapingUrl> findAll();
	
}
