package htw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import htw.common.enums.ArticleCategoryType;
import htw.dao.model.Category;
import htw.dao.repository.CategoryRepository;
import htw.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category save(Category category) {
		return this.categoryRepository.save(category);
	}
	
	public Category findById(ArticleCategoryType articleCategory) {
		return this.categoryRepository.findById(articleCategory).get();
	}

}
