package htw.robot.scraping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import htw.robot.scraping.model.RobotScrapingUrl;

public interface RobotScrapingUrlRepository extends JpaRepository<RobotScrapingUrl, String> {

}
