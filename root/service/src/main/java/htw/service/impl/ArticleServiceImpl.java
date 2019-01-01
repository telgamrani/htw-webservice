package htw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import htw.common.enums.FileDirectory;
import htw.common.utils.Base64Util;
import htw.common.utils.FileUtil;
import htw.dao.model.Article;
import htw.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Value("${image.storageRoot}")
	private String imageStorageRoot;
	
	@Override
	public void saveArticlesImgsOnDisk(List<Article> articles) {
		if (articles != null) {
			articles.forEach( a -> {
				String fileExtension = Base64Util.getExtension(a.getImgString());
				String storagePath = imageStorageRoot.concat(FileDirectory.IMAGES.getValue()+"/"+FileDirectory.ARTICLES.getValue());
				FileUtil.saveFile(a.getImgString(), 
								  storagePath, 
								  String.valueOf(a.getId()), 
								  fileExtension);
			});
		}
	}

}
