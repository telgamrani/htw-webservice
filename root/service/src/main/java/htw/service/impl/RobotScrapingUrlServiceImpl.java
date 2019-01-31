package htw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import htw.robot.scraping.model.RobotScrapingUrl;
import htw.robot.scraping.repository.RobotScrapingUrlRepository;
import htw.service.RobotScrapingUrlService;

@Service
public class RobotScrapingUrlServiceImpl implements RobotScrapingUrlService {

	@Autowired
	private RobotScrapingUrlRepository robotScrapingUrlRepository;
	
	@Override
	public List<RobotScrapingUrl> findAll() {
		return robotScrapingUrlRepository.findAll();
	}

}
