package htw.robot.scraping.model.json;

import java.util.ArrayList;
import java.util.List;

import htw.common.enums.ElementTarget;
import htw.common.enums.NumberOfElements;
import htw.robot.scraping.model.RobotScrapingSelector;
import htw.robot.scraping.model.RobotScrapingUrl;

public class RobotScrapingUrlJson {

	private String url;
	
	private List<RobotScrapingSelectorJson> selectors = new ArrayList<>();

	public RobotScrapingUrlJson() {}

	public RobotScrapingUrlJson(String url) {
		super();
		this.url = url;
	}
	
	public RobotScrapingUrl convertToDao() {
		RobotScrapingUrl robotScrapingUrl = new RobotScrapingUrl();
		robotScrapingUrl.setUrl(this.getUrl());
		return robotScrapingUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<RobotScrapingSelectorJson> getSelectors() {
		return selectors;
	}

	public void setSelectors(List<RobotScrapingSelectorJson> selectors) {
		this.selectors = selectors;
	}
	
	public void addSelector(RobotScrapingSelectorJson selectorJson, int rank, ElementTarget elementTarget, NumberOfElements numberOfElements) {
		if(selectorJson != null) {
			selectorJson.setRank(rank);
			selectorJson.setElementTarget(elementTarget);
			selectorJson.setNumberOfElements(numberOfElements);
			this.getSelectors().add(selectorJson);
		}
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
		RobotScrapingUrlJson other = (RobotScrapingUrlJson) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
}
