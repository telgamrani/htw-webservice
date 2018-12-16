package htw.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LookArticleId implements Serializable {
	
	private static final long serialVersionUID = 2904503491001423552L;

	@Column(name = "look_id")
	private Long lookId;
	
	@Column(name = "article_id")
	private Long articleId;

	public LookArticleId() {}

	public LookArticleId(Long lookId, Long articleId) {
		this.lookId = lookId;
		this.articleId = articleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articleId == null) ? 0 : articleId.hashCode());
		result = prime * result + ((lookId == null) ? 0 : lookId.hashCode());
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
		LookArticleId other = (LookArticleId) obj;
		if (articleId == null) {
			if (other.articleId != null)
				return false;
		} else if (!articleId.equals(other.articleId))
			return false;
		if (lookId == null) {
			if (other.lookId != null)
				return false;
		} else if (!lookId.equals(other.lookId))
			return false;
		return true;
	}
	
	
	
	
}
