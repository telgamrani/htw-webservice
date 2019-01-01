package htw.service;

import java.util.List;

import htw.dao.model.Article;

public interface ArticleService {

	void saveArticlesImgs(List<Article> articles);
}
