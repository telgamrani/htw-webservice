package htw.service.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import htw.dao.model.json.ArticleJson;

public class AddArticleRequest implements Serializable {

	private static final long serialVersionUID = -4350288104619896449L;
	
	@NotNull
	@Valid
	private ArticleJson article;

	public AddArticleRequest() {}

	public AddArticleRequest(ArticleJson article) {
		super();
		this.article = article;
	}

	public ArticleJson getArticle() {
		return article;
	}

	public void setArticle(ArticleJson article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "AddArticleRequest [article=" + article + "]";
	}

}
