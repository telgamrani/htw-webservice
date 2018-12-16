package htw.dao.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import htw.common.enums.LookArticleAssociation;

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
	private LookArticleAssociation type;
	
	private int rank;
	
	public LookArticle() {}

	public LookArticle(Look look, Article article) {
		this.look = look;
		this.article = article;
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

	public LookArticleAssociation getType() {
		return type;
	}

	public void setType(LookArticleAssociation type) {
		this.type = type;
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
		result = prime * result + rank;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (rank != other.rank)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
