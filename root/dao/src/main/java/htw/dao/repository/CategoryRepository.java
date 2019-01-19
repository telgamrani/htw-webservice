package htw.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import htw.common.enums.ArticleCategoryType;
import htw.dao.model.Category;

public interface CategoryRepository extends JpaRepository<Category, ArticleCategoryType> {

}
