package htw.service;

import htw.common.enums.ArticleCategoryType;
import htw.dao.model.Category;

public interface CategoryService {

	Category save(Category category);
	Category findById(ArticleCategoryType articleCategory);
	
}
