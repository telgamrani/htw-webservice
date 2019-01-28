package htw.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import htw.common.error.ErrorMessage;
import htw.common.exception.ResourceNotFoundException;
import htw.dao.model.Look;
import htw.dao.model.json.LookJson;
import htw.service.ArticleService;
import htw.service.LookService;
import htw.service.request.AddLookRequest;
import htw.service.request.PublishLookRequest;
import htw.service.request.UpdateLookRequest;

@RestController
@RequestMapping(value = "/look")
public class LookController {
	
	@Autowired
	private LookService lookService;
	
	@Autowired
	private ArticleService articleService;
	
	@PostMapping(value = "/add")
	public LookJson add(@Valid @RequestBody AddLookRequest addLookRequest, HttpServletRequest request) {
		
		LookJson lookJson = addLookRequest.getLook();
		
		Look look = lookService.save(lookJson.convertToDao());
		
		lookService.saveLookAndArticlesImgUrl(look);
		
		lookService.saveLookImgOnDisk(look);
		// TODO : A SUPPRIMER
		articleService.saveArticlesImgsOnDisk(look.getArticles());
		
		return look.convertToJson();
	}
	
	@PutMapping(value ="/update")
	public LookJson update(@Valid @RequestBody UpdateLookRequest updateLookRequest) {
		
		LookJson lookJson = updateLookRequest.getLook();
		Look look = lookService.save(lookJson.convertToDao());
		return look.convertToJson();
	}
	
	@PutMapping(value = "/publish")
	public int setPublished(@Valid @RequestBody PublishLookRequest publishLookRequest) {
		
		LookJson lookJson = publishLookRequest.getLook();
		return lookService.setPublished(publishLookRequest.isPublished(), lookJson.convertToDao());
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable Long id) {
		lookService.deleteById(id);
	}
	
	@GetMapping(value = "/get/{id}")
	public LookJson findById(@PathVariable Long id) {
		
		Optional<Look> look = lookService.findById(id);
		
		if(!look.isPresent()) {
			throw new ResourceNotFoundException(ErrorMessage.LOOK_NOT_FOUND.concat(String.valueOf(id)));
		}
		
		LookJson lookJson = look.get().convertToJson();
		
		return lookJson;
		
	}
	
	@GetMapping(value = "/get/all")
	public List<LookJson> findAll(){
		List<Look> looks = lookService.findAll();
		List<LookJson> looksJson = new ArrayList<>();
		looks.forEach(l -> looksJson.add(l.convertToJson()));
		return looksJson;
	}
	
	@GetMapping(value = "/get/all/published/{page}/{size}")
	public List<LookJson> findAllPublished(@PathVariable int page, @PathVariable int size){
		List<Look> looks = lookService.findByIsPublished(true, page, size);
		List<LookJson> looksJson = new ArrayList<>();
		looks.forEach(l -> looksJson.add(l.convertToJson()));
		return looksJson;
	}
	
	@GetMapping(value = "/get/all/{page}/{size}")
	public List<LookJson> findAll(@PathVariable int page, @PathVariable int size){
		List<Look> looks = lookService.findAll(page, size);
		List<LookJson> looksJson = new ArrayList<>();
		looks.forEach(l -> looksJson.add(l.convertToJson()));
		return looksJson;
	}
}
