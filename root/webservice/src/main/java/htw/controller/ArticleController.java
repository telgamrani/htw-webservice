package htw.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import htw.common.error.ErrorMessage;
import htw.common.exception.ResourceNotFoundException;
import htw.dao.model.Article;
import htw.dao.model.json.ArticleJson;
import htw.service.ArticleService;
import htw.service.request.AddArticleRequest;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@PostMapping(value = "/add")
	public ArticleJson add(@Valid @RequestBody AddArticleRequest addArticleRequest, HttpServletRequest request) {
		 Article article = this.articleService.replaceArticleSizesByDbSizes(addArticleRequest.getArticle().convertToDao());
		 article = this.articleService.replaceArticleCategoriesByDbCategories(article);
		 return articleService.save(article).convertToJson();
	}
	
	@GetMapping(value = "/get/{id}")
	public ArticleJson get(@PathVariable Long id) {
		
		Optional<Article> article = articleService.findById(id);
		
		if(!article.isPresent()) {
			throw new ResourceNotFoundException(ErrorMessage.ARTICLE_NOT_FOUND.concat(String.valueOf(id)));
		}
		
		ArticleJson articleJson = article.get().convertToJson();
		
		return articleJson;
	}
}
