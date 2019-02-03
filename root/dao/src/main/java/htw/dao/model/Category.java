package htw.dao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import htw.common.enums.ArticleCategoryType;
import htw.dao.model.json.CategoryJson;

@Entity
@Table(name = "category")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 967835768426536107L;
	
	@Id	
	@Enumerated(EnumType.STRING)
	private ArticleCategoryType value;

	public Category() {}

	public Category(ArticleCategoryType value) {
		this.value = value;
	}
	
	public CategoryJson convertToJson( ) {
		CategoryJson categoryJson = new CategoryJson();
		categoryJson.setCategory(this.getValue());
		return categoryJson;
	}

	public ArticleCategoryType getValue() {
		return value;
	}

	public void setValue(ArticleCategoryType value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [value=" + value + "]";
	}
	
}
