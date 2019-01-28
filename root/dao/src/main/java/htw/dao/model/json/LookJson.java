package htw.dao.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import htw.common.enums.LookArticleAssociationType;
import htw.dao.model.Look;
import htw.dao.model.json.ArticleJson; 

public class LookJson implements Serializable {

	private static final long serialVersionUID = -2424375432071627417L;

	private Long id;
	
	private String imgUrl;
	
	private String imgString;
	
	private boolean isPublished;
	
	private LookArticleAssociationType lookArticleAssociationType;
	
	private int rank;
	
	@NotEmpty
	@Valid
	private List<ArticleJson> articles = new ArrayList<>();

	public LookJson() {}

	public LookJson(Long id, String imgUrl) {
		this.id = id;
		this.imgUrl = imgUrl;
	}

	public LookJson(Long id, String imgUrl, List<ArticleJson> articles) {
		this.id = id;
		this.imgUrl = imgUrl;
		this.articles = articles;
	}
	
	public Look convertToDao() {
		Look look = new Look();
		look.setId(this.getId());
		look.setImgUrl(this.getImgUrl());
		look.setImgString(this.getImgString());
		look.setPublished(this.isPublished());
		articles.forEach(a -> look.addArticle(a.convertToDao(), a.getLookArticleAssociationType(), a.getRank()));
		return look;
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

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<ArticleJson> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleJson> articles) {
		this.articles = articles;
	}
	
	public void addArticle(ArticleJson articleJson, int rank, LookArticleAssociationType lookArticleAssociationType) {
		articleJson.setRank(rank);
		articleJson.setLookArticleAssociationType(lookArticleAssociationType);
		this.articles.add(articleJson);
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
		LookJson other = (LookJson) obj;
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
		return "LookJson [id=" + id + ", imgUrl=" + imgUrl + ", articles=" + articles + "]";
	}
	
}
