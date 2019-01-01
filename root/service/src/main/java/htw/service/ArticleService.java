package htw.service;

import java.util.List;

import htw.dao.model.Article;

public interface ArticleService {

	void saveArticlesImgsOnDisk(List<Article> articles);
}
