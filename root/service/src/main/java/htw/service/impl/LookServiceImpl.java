package htw.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import htw.common.enums.FileDirectoryName;
import htw.common.utils.Base64Util;
import htw.common.utils.FileUtil;
import htw.dao.model.Look;
import htw.dao.repository.LookRepository;
import htw.service.LookService;

@Service
public class LookServiceImpl implements LookService {

	@Autowired
	private LookRepository lookRepository;
	
	@Value("${image.storageRoot}")
	private String imageStorageRoot;

	public Look save(Look look) {
		return lookRepository.save(look);
	}
	
	@Override
	public void deleteById(Long id) {
		lookRepository.deleteById(id);
	}
	
	private Sort sortByIdDesc() {
        return new Sort(Sort.Direction.DESC, "id");
    }
	
	@Override
	public List<Look> findAll() {
		return lookRepository.findAll(sortByIdDesc());
	}
	
	@Override
	public List<Look> findAll(int page, int size) {
		return lookRepository.findAll(PageRequest.of(page, size, sortByIdDesc())).getContent();
	}

	@Override
	public List<Look> findByIsPublished(boolean isPublished, int page, int size) {
		return lookRepository.findByIsPublished(isPublished, PageRequest.of(page, size, sortByIdDesc())).getContent();
	}

	@Override
	public Optional<Look> findById(Long id) {
		return lookRepository.findById(id);
	}

	@Override
	public boolean saveLookImgOnDisk(Look look) {
		String fileExtension = Base64Util.getExtension(look.getImgString());
		String storagePath = imageStorageRoot.concat(FileDirectoryName.IMAGES.getValue()+"/"+FileDirectoryName.LOOKS.getValue());
		return FileUtil.saveFile(look.getImgString(), 
								 storagePath, 
								 String.valueOf(look.getId()), 
								 fileExtension);
	}
	
	@Override
	public Look saveLookAndArticlesImgUrl(Look look) {
		
		// Articles
		look.getArticles().forEach(a -> {
			String fileArticleExtension = Base64Util.getExtension(a.getImgString());
			a.setImgUrl(String.valueOf(a.getId()+"."+fileArticleExtension));
		});
		
		// Look
		String fileLookExtension = Base64Util.getExtension(look.getImgString());
		look.setImgUrl(String.valueOf(look.getId()+"."+fileLookExtension));
		
		return lookRepository.save(look);
	}

	@Override
	public int setPublished(boolean isPublished, Look look) {
		if(look == null) {
			return 0;
		}
		return lookRepository.setPublished(isPublished, look.getId());
	}
	
}
