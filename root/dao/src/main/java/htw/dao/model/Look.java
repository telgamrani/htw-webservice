package htw.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import htw.common.enums.LookArticleAssociationType;
import htw.dao.model.association.LookArticle;
import htw.dao.model.json.LookJson;

@Entity
@Table(name = "look")
public class Look implements Serializable {

	private static final long serialVersionUID = 1185158431165141203L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String imgUrl;
	
	@Lob
	@Column(name = "imgString", columnDefinition = "LONGTEXT")
	private String imgString;
	
	private boolean isPublished = false;
	
	@OneToMany(
	  mappedBy = "look", 
	  cascade = CascadeType.MERGE, 
	  orphanRemoval = true
	)
	private List<LookArticle> lookArticles = new ArrayList<>();

	public Look() {}

	public Look(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public LookJson convertToJson() {
		LookJson lookJson = new LookJson();
		lookJson.setId(this.getId());
		lookJson.setImgUrl(this.getImgUrl());
		lookJson.setPublished(this.isPublished());
		this.lookArticles.forEach(la -> lookJson.addArticle(la.getArticle().convertToJson(), la.getRank(), la.getLookArticleAssociationType()));
		return lookJson;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getImgString() {
		return imgString;
	}

	public void setImgString(String imgString) {
		this.imgString = imgString;
	}

	public boolean isPublished() {
		return isPublished;
	}

	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

	public List<LookArticle> getLookArticles() {
		return lookArticles;
	}

	public void setLookArticles(List<LookArticle> lookArticles) {
		this.lookArticles = lookArticles;
	}
	
	public List<Article> getArticles(){
		return this.getLookArticles().stream().map(la -> la.getArticle()).collect(Collectors.toList());
	}
	
	public void addLookArticles(LookArticle lookArticle) {
		this.lookArticles.add(lookArticle);
	}
	
	public void addArticle(Article article, LookArticleAssociationType lookArticleAssociationType, int rank) {
		LookArticle lookArticle = new LookArticle(this, article, lookArticleAssociationType, rank);
		this.addLookArticles(lookArticle);
	}
	
	public void removeArticle(Article article) {
		this.lookArticles.removeIf(a -> a.getArticle().equals(article));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
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
		Look other = (Look) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imgUrl == null) {
			if (other.imgUrl != null)
				return false;
		} else if (!imgUrl.equals(other.imgUrl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Look [id=" + id + ", imgUrl=" + imgUrl + ", lookArticles=" + lookArticles + "]";
	}
	
	
	
}
