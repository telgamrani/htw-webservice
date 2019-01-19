package htw.service;

import java.util.List;

import htw.dao.model.Article;

public interface ArticleService {

	Article save(Article article);
	
	void saveArticlesImgsOnDisk(List<Article> articles);
}
