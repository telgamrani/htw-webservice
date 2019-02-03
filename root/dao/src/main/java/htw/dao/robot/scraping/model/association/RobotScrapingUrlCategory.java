package htw.dao.robot.scraping.model.association;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import htw.dao.model.Category;
import htw.robot.scraping.dao.embedded.id.RobotScrapingUrlCategoryId;
import htw.robot.scraping.model.RobotScrapingUrl;

@Entity
@Table(name = "robot_scraping_url_category")
public class RobotScrapingUrlCategory {

	@EmbeddedId
	private RobotScrapingUrlCategoryId id;
	
	@ManyToOne
	@MapsId("urlId")
	private RobotScrapingUrl robotScrapingUrl;
	
	@ManyToOne
	@MapsId("categoryId")	
	private Category category;

	public RobotScrapingUrlCategory() {}

	public RobotScrapingUrlCategory(RobotScrapingUrl robotScrapingUrl, Category category) {
		this.robotScrapingUrl = robotScrapingUrl;
		this.category = category;
		this.id = new RobotScrapingUrlCategoryId(robotScrapingUrl.getId(), category.getValue());
	}

	public RobotScrapingUrlCategoryId getId() {
		return id;
	}

	public void setId(RobotScrapingUrlCategoryId id) {
		this.id = id;
	}

	public RobotScrapingUrl getRobotScrapingUrl() {
		return robotScrapingUrl;
	}

	public void setRobotScrapingUrl(RobotScrapingUrl robotScrapingUrl) {
		this.robotScrapingUrl = robotScrapingUrl;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((robotScrapingUrl == null) ? 0 : robotScrapingUrl.hashCode());
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
		RobotScrapingUrlCategory other = (RobotScrapingUrlCategory) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (robotScrapingUrl == null) {
			if (other.robotScrapingUrl != null)
				return false;
		} else if (!robotScrapingUrl.equals(other.robotScrapingUrl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RobotScrapingUrlCategory [id=" + id + ", robotScrapingUrl=" + robotScrapingUrl + ", category="
				+ category + "]";
	}
	
}
