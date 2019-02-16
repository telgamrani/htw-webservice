package htw.service;

import java.util.List;
import java.util.Optional;

import htw.dao.model.Article;
import htw.dao.model.json.ArticleJson;

public interface ArticleService {

	Article save(Article article);
	
	Optional<Article> findById(Long id);
	
	void saveArticlesImgsOnDisk(List<Article> articles);
	
	Article replaceArticleSizesByDbSizes(Article article);

	Article replaceArticleCategoriesByDbCategories(Article article);
}
