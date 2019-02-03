package htw.dao.robot.scraping.model.association;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import htw.common.enums.ElementTarget;
import htw.common.enums.NumberOfElements;
import htw.robot.scraping.dao.embedded.id.RobotScrapingUrlSelectorId;
import htw.robot.scraping.model.RobotScrapingSelector;
import htw.robot.scraping.model.RobotScrapingUrl;

@Entity
@Table(name="robot_scraping_url_selector")
public class RobotScrapingUrlSelector {
	
	@EmbeddedId
	private RobotScrapingUrlSelectorId id;
	
	@ManyToOne
	@MapsId("urlId")
	private RobotScrapingUrl robotScrapingUrl;
	
	@ManyToOne
	@MapsId("selectorId")	
	private RobotScrapingSelector robotScrapingSelector;
	
	private int rank;
	
	private String flags;
	
	@Enumerated(EnumType.STRING)
	private ElementTarget elementTarget;
	
	@Enumerated(EnumType.STRING)
	private NumberOfElements numberOfElements;

	public RobotScrapingUrlSelector() {}

	public RobotScrapingUrlSelector(RobotScrapingUrl robotScrapingUrl, RobotScrapingSelector robotScrapingSelector) {
		this.robotScrapingUrl = robotScrapingUrl;
		this.robotScrapingSelector = robotScrapingSelector;
		this.id = new RobotScrapingUrlSelectorId(robotScrapingUrl.getId(), robotScrapingSelector.getId());
	}

	public RobotScrapingUrlSelectorId getId() {
		return id;
	}

	public void setId(RobotScrapingUrlSelectorId id) {
		this.id = id;
	}

	public RobotScrapingUrl getRobotScrapingUrl() {
		return robotScrapingUrl;
	}

	public void setRobotScrapingUrl(RobotScrapingUrl robotScrapingUrl) {
		this.robotScrapingUrl = robotScrapingUrl;
	}

	public RobotScrapingSelector getRobotScrapingSelector() {
		return robotScrapingSelector;
	}

	public void setRobotScrapingSelector(RobotScrapingSelector robotScrapingSelector) {
		this.robotScrapingSelector = robotScrapingSelector;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public ElementTarget getElementTarget() {
		return elementTarget;
	}

	public void setElementTarget(ElementTarget elementTarget) {
		this.elementTarget = elementTarget;
	}

	public NumberOfElements getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(NumberOfElements numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elementTarget == null) ? 0 : elementTarget.hashCode());
		result = prime * result + ((flags == null) ? 0 : flags.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numberOfElements == null) ? 0 : numberOfElements.hashCode());
		result = prime * result + rank;
		result = prime * result + ((robotScrapingSelector == null) ? 0 : robotScrapingSelector.hashCode());
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
		RobotScrapingUrlSelector other = (RobotScrapingUrlSelector) obj;
		if (elementTarget != other.elementTarget)
			return false;
		if (flags == null) {
			if (other.flags != null)
				return false;
		} else if (!flags.equals(other.flags))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numberOfElements != other.numberOfElements)
			return false;
		if (rank != other.rank)
			return false;
		if (robotScrapingSelector == null) {
			if (other.robotScrapingSelector != null)
				return false;
		} else if (!robotScrapingSelector.equals(other.robotScrapingSelector))
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
		return "RobotScrapingUrlSelector [id=" + id + ", robotScrapingUrl=" + robotScrapingUrl
				+ ", robotScrapingSelector=" + robotScrapingSelector + ", rank=" + rank + ", flags=" + flags
				+ ", elementTarget=" + elementTarget + ", numberOfElements=" + numberOfElements + "]";
	}
	
}
