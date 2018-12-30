package htw.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import htw.common.error.ErrorMessage;
import htw.common.exception.ResourceNotFoundException;
import htw.dao.model.Look;
import htw.dao.model.json.LookJson;
import htw.service.LookService;
import htw.service.request.AddLookRequest;

@RestController
@RequestMapping(value = "/look")
public class LookController {
	
	@Autowired
	private LookService lookService;
	
	@PostMapping(value = "/add")
	public LookJson add(@Valid @RequestBody AddLookRequest addLookRequest) {
		LookJson lookJson = addLookRequest.getLook();
		Look look = lookService.save(lookJson.convertToDao());
		look.setImgUrl(String.valueOf(look.getId()));
		lookService.save(look);
		return look.convertToJson();
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
	
	@GetMapping(value = "/get")
	public List<LookJson> findAll(){
		List<Look> looks = lookService.findAll();
		List<LookJson> looksJson = new ArrayList<>();
		looks.forEach(l -> looksJson.add(l.convertToJson()));
		return looksJson;
	}
}
