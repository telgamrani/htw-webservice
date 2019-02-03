package htw.robot.scraping.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import htw.dao.model.Category;
import htw.dao.robot.scraping.model.association.RobotScrapingUrlCategory;
import htw.dao.robot.scraping.model.association.RobotScrapingUrlSelector;
import htw.robot.scraping.model.json.RobotScrapingUrlJson;

@Entity
@Table(name = "robot_scraping_url")
public class RobotScrapingUrl implements Serializable {

	private static final long serialVersionUID = 2332163559228016906L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 1000, unique = true)
	private String url;
	
	@OneToMany(
		mappedBy = "robotScrapingUrl"
	)
	private List<RobotScrapingUrlSelector> robotScrapingUrlSelectors = new ArrayList<>();
	
	@OneToMany(
			mappedBy = "robotScrapingUrl"
		)
	private List<RobotScrapingUrlCategory> robotScrapingUrlCategories = new ArrayList<>();

	public RobotScrapingUrl() {}
	
	public RobotScrapingUrl(Long id, String url) {
		super();
		this.id = id;
		this.url = url;
	}

	public RobotScrapingUrlJson convertToJson() {
		RobotScrapingUrlJson robotScrapingUrlJson = new RobotScrapingUrlJson();
		robotScrapingUrlJson.setUrl(this.getUrl());
		
		this.getRobotScrapingUrlSelector().forEach(us -> {
			robotScrapingUrlJson.addSelector(us.getRobotScrapingSelector().convertToJson(), 
											 us.getRank(), 
											 us.getFlags(),
											 us.getElementTarget(), 
											 us.getNumberOfElements());
		});
		
		this.getRobotScrapingUrlCategories().forEach(uc -> {
			robotScrapingUrlJson.addCategory(uc.getCategory().convertToJson());
		});
		
		return robotScrapingUrlJson;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<RobotScrapingUrlSelector> getRobotScrapingUrlSelector() {
		return robotScrapingUrlSelectors;
	}

	public void setRobotScrapingUrlSelector(List<RobotScrapingUrlSelector> robotScrapingUrlSelectors) {
		this.robotScrapingUrlSelectors = robotScrapingUrlSelectors;
	}
	
	public List<RobotScrapingSelector> getRobotScrapingSelectors(){
		return this.getRobotScrapingUrlSelector().stream().map(us -> us.getRobotScrapingSelector()).collect(Collectors.toList());
	}

	public List<RobotScrapingUrlSelector> getRobotScrapingUrlSelectors() {
		return robotScrapingUrlSelectors;
	}

	public void setRobotScrapingUrlSelectors(List<RobotScrapingUrlSelector> robotScrapingUrlSelectors) {
		this.robotScrapingUrlSelectors = robotScrapingUrlSelectors;
	}

	public List<RobotScrapingUrlCategory> getRobotScrapingUrlCategories() {
		return robotScrapingUrlCategories;
	}

	public void setRobotScrapingUrlCategories(List<RobotScrapingUrlCategory> robotScrapingUrlCategories) {
		this.robotScrapingUrlCategories = robotScrapingUrlCategories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		RobotScrapingUrl other = (RobotScrapingUrl) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RobotScrapingUrl [id=" + id + ", url=" + url + ", robotScrapingUrlSelectors="
				+ robotScrapingUrlSelectors + ", robotScrapingUrlCategories=" + robotScrapingUrlCategories + "]";
	}
	
}
