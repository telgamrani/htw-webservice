package htw.service.impl;

import java.util.List;

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
	
	@Override
	public Category findById(ArticleCategoryType articleCategory) {
		return this.categoryRepository.findById(articleCategory).get();
	}

	@Override
	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}

}
