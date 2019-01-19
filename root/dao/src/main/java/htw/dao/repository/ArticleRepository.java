package htw.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import htw.dao.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}
