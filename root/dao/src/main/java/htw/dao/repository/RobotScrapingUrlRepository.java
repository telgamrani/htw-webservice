package htw.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import htw.dao.model.RobotScrapingUrl;

public interface RobotScrapingUrlRepository extends JpaRepository<RobotScrapingUrl, String> {

}
