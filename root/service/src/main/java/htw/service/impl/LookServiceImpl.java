package htw.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import htw.common.enums.FileDirectory;
import htw.common.utils.Base64Util;
import htw.common.utils.FileUtil;
import htw.dao.model.Look;
import htw.dao.model.json.LookJson;
import htw.dao.repository.LookRepository;
import htw.service.LookService;

@Service
public class LookServiceImpl implements LookService {

	@Autowired
	private LookRepository lookRepository;

	public Look save(Look look) {
		return lookRepository.save(look);
	}
	
	@Override
	public void deleteById(Long id) {
		lookRepository.deleteById(id);
	}
	
	@Override
	public List<Look> findAll() {
		return lookRepository.findAll();
	}

	@Override
	public Optional<Look> findById(Long id) {
		return lookRepository.findById(id);
	}

	@Override
	public boolean saveLookImg(Look look) {
		String fileExtension = Base64Util.getExtension(look.getImgString());
		return FileUtil.saveFile(look.getImgString(), 
								 FileDirectory.IMAGES.getValue()+"/"+FileDirectory.LOOKS.getValue(), 
								 String.valueOf(look.getId()), 
								 fileExtension);
	}
	
}
