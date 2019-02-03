package htw.robot.scraping.dao.embedded.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import htw.common.enums.ArticleCategoryType;

@Embeddable
public class RobotScrapingUrlCategoryId implements Serializable {

	private static final long serialVersionUID = -6393867630311848318L;

	@Column(name = "url_id")
	private Long urlId;
	
	@Column(name = "category_id", length = 50)
	@Enumerated(EnumType.STRING)
	private ArticleCategoryType categoryId;
	
	public RobotScrapingUrlCategoryId() {}

	public RobotScrapingUrlCategoryId(Long urlId, ArticleCategoryType categoryId) {
		this.urlId = urlId;
		this.categoryId = categoryId;
	}

	public Long getUrlId() {
		return urlId;
	}

	public void setUrlId(Long urlId) {
		this.urlId = urlId;
	}

	public ArticleCategoryType getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(ArticleCategoryType categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
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
		RobotScrapingUrlCategoryId other = (RobotScrapingUrlCategoryId) obj;
		if (categoryId != other.categoryId)
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
		return "RobotScrapingUrlCategoryId [urlId=" + urlId + ", categoryId=" + categoryId + "]";
	}
	
}
