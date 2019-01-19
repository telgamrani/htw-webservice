package htw.dao.model.association;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import htw.common.enums.LookArticleAssociationType;
import htw.dao.embedded.id.LookArticleId;
import htw.dao.model.Article;
import htw.dao.model.Look;

@Entity
@Table(name = "look_article")
public class LookArticle implements Serializable {
	
	private static final long serialVersionUID = 6965589877489244938L;

	@EmbeddedId
	private LookArticleId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("lookId")
	private Look look;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("articleId")
	private Article article;
	
	@Enumerated(EnumType.STRING)
	private LookArticleAssociationType lookArticleAssociationType;
	
	private int rank;
	
	public LookArticle() {}

	public LookArticle(Look look, Article article) {
		this.look = look;
		this.article = article;
		this.id = new LookArticleId(look.getId(), article.getId());
	}

	public LookArticle(Look look, Article article, LookArticleAssociationType lookArticleAssociationType, int rank) {
		this.look = look;
		this.article = article;
		this.lookArticleAssociationType = lookArticleAssociationType;
		this.rank = rank;
		this.id = new LookArticleId(look.getId(), article.getId());
	}

	public LookArticleId getId() {
		return id;
	}

	public void setId(LookArticleId id) {
		this.id = id;
	}

	public Look getLook() {
		return look;
	}

	public void setLook(Look look) {
		this.look = look;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public LookArticleAssociationType getLookArticleAssociationType() {
		return lookArticleAssociationType;
	}

	public void setLookArticleAssociationType(LookArticleAssociationType lookArticleAssociationType) {
		this.lookArticleAssociationType = lookArticleAssociationType;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lookArticleAssociationType == null) ? 0 : lookArticleAssociationType.hashCode());
		result = prime * result + rank;
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
		LookArticle other = (LookArticle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lookArticleAssociationType != other.lookArticleAssociationType)
			return false;
		if (rank != other.rank)
			return false;
		return true;
	}

}
