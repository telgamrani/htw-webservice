package htw.robot.scraping.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import htw.dao.robot.scraping.model.association.RobotScrapingUrlSelector;
import htw.robot.scraping.model.json.RobotScrapingUrlJson;

@Entity
@Table(name = "robot_scraping_url")
public class RobotScrapingUrl implements Serializable {

	private static final long serialVersionUID = 2332163559228016906L;
	
	@Id
	@Column(length = 1000)
	private String url;
	
	@OneToMany(
		mappedBy = "robotScrapingUrl"
	)
	private List<RobotScrapingUrlSelector> robotScrapingUrlSelectors = new ArrayList<>();

	public RobotScrapingUrl() {}

	public RobotScrapingUrl(String url) {
		this.url = url;
	}
	
	public RobotScrapingUrlJson convertToJson() {
		RobotScrapingUrlJson robotScrapingUrlJson = new RobotScrapingUrlJson();
		robotScrapingUrlJson.setUrl(this.getUrl());
		return robotScrapingUrlJson;
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
	
}
