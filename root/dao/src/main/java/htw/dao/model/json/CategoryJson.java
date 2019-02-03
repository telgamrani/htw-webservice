package htw.dao.model.json;

import htw.common.enums.ArticleCategoryType;

public class CategoryJson {

	private ArticleCategoryType category;

	public CategoryJson() {}

	public CategoryJson(ArticleCategoryType category) {
		super();
		this.category = category;
	}

	public ArticleCategoryType getCategory() {
		return category;
	}

	public void setCategory(ArticleCategoryType category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
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
		CategoryJson other = (CategoryJson) obj;
		if (category != other.category)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoryJson [category=" + category + "]";
	}
	
}
