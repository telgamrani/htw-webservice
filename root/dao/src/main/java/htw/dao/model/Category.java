package htw.dao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import htw.common.enums.ArticleCategoryType;

@Entity
@Table(name = "category")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 967835768426536107L;
	
	@Id	
	@Enumerated(EnumType.STRING)
	private ArticleCategoryType articleCategory;

	public Category() {}

	public Category(ArticleCategoryType articleCategory) {
		this.articleCategory = articleCategory;
	}

	public ArticleCategoryType getArticleCategory() {
		return articleCategory;
	}

	public void setArticleCategory(ArticleCategoryType articleCategory) {
		this.articleCategory = articleCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articleCategory == null) ? 0 : articleCategory.hashCode());
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
		Category other = (Category) obj;
		if (articleCategory != other.articleCategory)
			return false;
		return true;
	}	
	
}
