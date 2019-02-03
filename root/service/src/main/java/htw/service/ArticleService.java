package htw.service;

import java.util.List;

import htw.dao.model.Article;
import htw.dao.model.json.ArticleJson;

public interface ArticleService {

	Article save(Article article);
	
	void saveArticlesImgsOnDisk(List<Article> articles);
	
	Article replaceArticleSizesByDbSizes(Article article);

	Article replaceArticleCategoriesByDbCategories(Article article);
}
