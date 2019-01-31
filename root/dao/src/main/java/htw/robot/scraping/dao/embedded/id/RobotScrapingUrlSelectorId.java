package htw.robot.scraping.dao.embedded.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RobotScrapingUrlSelectorId implements Serializable{

	private static final long serialVersionUID = -2289277889605986500L;
	
	@Column(name = "url_id", length = 1000)
	private String urlId;
	
	@Column(name = "selector_id")
	private Long selectorId;

	public RobotScrapingUrlSelectorId() {}

	public RobotScrapingUrlSelectorId(String urlId, Long selectorId) {
		super();
		this.urlId = urlId;
		this.selectorId = selectorId;
	}

	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	public Long getSelectorId() {
		return selectorId;
	}

	public void setSelectorId(Long selectorId) {
		this.selectorId = selectorId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((selectorId == null) ? 0 : selectorId.hashCode());
		result = prime * result + ((urlId == null) ? 0 : urlId.hashCode());
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
		RobotScrapingUrlSelectorId other = (RobotScrapingUrlSelectorId) obj;
		if (selectorId == null) {
			if (other.selectorId != null)
				return false;
		} else if (!selectorId.equals(other.selectorId))
			return false;
		if (urlId == null) {
			if (other.urlId != null)
				return false;
		} else if (!urlId.equals(other.urlId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RobotScrapingUrlSelectorId [urlId=" + urlId + ", selectorId=" + selectorId + "]";
	}

}
