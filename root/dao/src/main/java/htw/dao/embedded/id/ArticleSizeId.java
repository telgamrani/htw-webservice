package htw.dao.embedded.id;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ArticleSizeId implements Serializable {

	private static final long serialVersionUID = -1694241687086246608L;

	private Long articleId;
	
	private String sizeId;

	public ArticleSizeId() {}

	public ArticleSizeId(Long articleId, String sizeId) {
		this.articleId = articleId;
		this.sizeId = sizeId;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getSizeId() {
		return sizeId;
	}

	public void setSizeId(String sizeId) {
		this.sizeId = sizeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articleId == null) ? 0 : articleId.hashCode());
		result = prime * result + ((sizeId == null) ? 0 : sizeId.hashCode());
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
		ArticleSizeId other = (ArticleSizeId) obj;
		if (articleId == null) {
			if (other.articleId != null)
				return false;
		} else if (!articleId.equals(other.articleId))
			return false;
		if (sizeId == null) {
			if (other.sizeId != null)
				return false;
		} else if (!sizeId.equals(other.sizeId))
			return false;
		return true;
	}
	
}
