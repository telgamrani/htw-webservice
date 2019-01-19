package htw.dao.embedded.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import htw.common.enums.ArticleCategoryType;

@Embeddable
public class ArticleCategoryId implements Serializable {

	private static final long serialVersionUID = 3642379897861615009L;
	
	@Column(name = "article_id")
	private Long articleId;

	@Column(name = "category_id")
	@Enumerated(EnumType.STRING)
	private ArticleCategoryType categoryId;

	public ArticleCategoryId() {}

	public ArticleCategoryId(Long articleId, ArticleCategoryType categoryId) {
		this.articleId = articleId;
		this.categoryId = categoryId;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public ArticleCategoryType getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(ArticleCategoryType categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articleId == null) ? 0 : articleId.hashCode());
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
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
		ArticleCategoryId other = (ArticleCategoryId) obj;
		if (articleId == null) {
			if (other.articleId != null)
				return false;
		} else if (!articleId.equals(other.articleId))
			return false;
		if (categoryId != other.categoryId)
			return false;
		return true;
	}
	
}
