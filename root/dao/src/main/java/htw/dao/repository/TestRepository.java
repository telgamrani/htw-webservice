package htw.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import htw.dao.model.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

}
