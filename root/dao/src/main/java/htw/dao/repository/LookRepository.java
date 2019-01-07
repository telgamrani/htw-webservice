package htw.dao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import htw.dao.model.Look;

public interface LookRepository extends JpaRepository<Look, Long>{
	
	Page<Look> findByIsPublished(boolean isPublished, Pageable pageable);
	
	@Transactional
	@Modifying
	@Query("update Look l  set l.isPublished = :isPublished where l.id = :id")
	int setPublished(@Param("isPublished") boolean isPublished, @Param("id") Long id);
}
