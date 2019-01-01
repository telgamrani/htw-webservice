package htw.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import htw.common.enums.FileDirectory;
import htw.common.utils.Base64Util;
import htw.common.utils.FileUtil;
import htw.dao.model.Article;
import htw.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Override
	public void saveArticlesImgs(List<Article> articles) {
		if (articles != null) {
			articles.forEach( a -> {
				String fileExtension = Base64Util.getExtension(a.getImgString());
				FileUtil.saveFile(a.getImgString(), 
								  FileDirectory.IMAGES.getValue()+"/"+FileDirectory.ARTICLES.getValue(), 
								  String.valueOf(a.getId()), 
								  fileExtension);
			});
		}
	}

}
