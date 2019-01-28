package htw.dao.model.association;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import htw.dao.embedded.id.ArticleSizeId;
import htw.dao.model.Article;
import htw.dao.model.Size;

@Entity
@Table(name = "article_size")
public class ArticleSize implements Serializable {
	
	private static final long serialVersionUID = -3166726113353369373L;

	@EmbeddedId
	private ArticleSizeId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("articleId")
	private Article article;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sizeId")
	private Size size;

	public ArticleSize() {}

	public ArticleSize(Article article, Size size) {
		this.article = article;
		this.size = size;
		this.id = new ArticleSizeId(article.getId(), size.getValue());
	}

	public ArticleSizeId getId() {
		return id;
	}

	public void setId(ArticleSizeId id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		ArticleSize other = (ArticleSize) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	
}
