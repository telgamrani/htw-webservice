package htw.dao.model.association;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import htw.dao.embedded.id.ArticleCategoryId;
import htw.dao.model.Article;
import htw.dao.model.Category;

@Entity
@Table(name = "article_category")
public class ArticleCategory implements Serializable {

	private static final long serialVersionUID = 4896785947977325222L;
	
	@EmbeddedId
	private ArticleCategoryId id;

	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("articleId")
	private Article article;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("categoryId")
	private Category category;

	public ArticleCategory() {}

	public ArticleCategory(Article article, Category category) {
		this.article = article;
		this.category = category;
		this.id = new ArticleCategoryId(article.getId(), category.getArticleCategory());
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleCategory other = (ArticleCategory) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}
