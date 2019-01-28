package htw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		 Article article = this.articleService.replaceArticleSizes(addArticleRequest.getArticle());
		 return articleService.save(article).convertToJson();
	}
}
