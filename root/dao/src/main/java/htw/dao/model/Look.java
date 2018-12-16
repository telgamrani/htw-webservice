package htw.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import htw.dao.model.json.LookJson;

@Entity
@Table(name = "look")
public class Look implements Serializable {

	private static final long serialVersionUID = 1185158431165141203L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String imgUrl;
	
	@OneToMany(
	  mappedBy = "look", 
	  cascade = CascadeType.ALL, 
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
		this.lookArticles.forEach(la -> lookJson.addArticle(la.getArticle().convertToJson()));
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

	public List<LookArticle> getLookArticles() {
		return lookArticles;
	}

	public void setLookArticles(List<LookArticle> lookArticles) {
		this.lookArticles = lookArticles;
	}
	
	public void addLookArticles(LookArticle lookArticle) {
		this.lookArticles.add(lookArticle);
	}
	
	public void addArticle(Article article) {
		LookArticle lookArticle = new LookArticle(this, article);
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
