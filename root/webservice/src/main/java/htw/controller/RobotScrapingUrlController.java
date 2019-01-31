package htw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import htw.controller.utils.RestClient;
import htw.robot.scraping.model.RobotScrapingUrl;
import htw.robot.scraping.model.json.RobotScrapingUrlJson;
import htw.service.RobotScrapingUrlService;
import htw.service.request.RobotScrapingGetResourceByUrlRequest;

@RestController
@RequestMapping(value = "/robot/scraping/url")
public class RobotScrapingUrlController {
	
	@Autowired
	private RobotScrapingUrlService robotScrapingUrlService;
	
	@GetMapping(value = "/get/all")
	public List<RobotScrapingUrlJson> findAll(){
		List<RobotScrapingUrlJson> robotScrapingUrlJsons = new ArrayList<>();
		List<RobotScrapingUrl> robotScrapingUrls = this.robotScrapingUrlService.findAll();
		
		robotScrapingUrls.forEach(rsu -> {
			robotScrapingUrlJsons.add(rsu.convertToJson());
		});

		return robotScrapingUrlJsons;
	}
	


	@PostMapping(value = "/get/resource")
	public @ResponseBody String getResource(@Valid @RequestBody RobotScrapingGetResourceByUrlRequest robotScrapingGetResourceByUrlRequest) {
		System.out.println("test get resource");
		RestClient restClient = new RestClient();
		
		String response = restClient.get(robotScrapingGetResourceByUrlRequest.getUrl());
		
		return response;
	}
	
	

}
