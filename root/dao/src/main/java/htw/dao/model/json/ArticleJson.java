package htw.dao.model.json;

import htw.common.enums.LookArticleAssociationType;
import htw.dao.model.Article;

public class ArticleJson {
	
	private Long id;
	
	private String shoppingSiteName;
	
	private String shoppingUrl;
	
	private String imgUrl;
	
	private String imgString;
	
	private String brand;
	
	private Double price;
	
	private String description;
	
	private LookArticleAssociationType lookArticleAssociationType;
	
	private int rank;

	
	public ArticleJson() {}

	public ArticleJson(Long id, String shoppingSiteName, String shoppingUrl, String imgUrl, String imgString, String brand, Double price, String description) {
		this.id = id;
		this.shoppingSiteName = shoppingSiteName;
		this.shoppingUrl = shoppingUrl;
		this.imgUrl = imgUrl;
		this.imgString = imgString;
		this.brand = brand;
		this.price = price;
		this.description = description;
	}

	public Article convertToDao() {
		Article article = new Article();
		article.setId(this.getId());
		article.setImgUrl(this.getImgUrl());
		article.setImgString(this.getImgString());
		article.setShoppingSiteName(this.getShoppingSiteName());
		article.setShoppingUrl(this.getShoppingUrl());
		article.setBrand(this.getBrand());
		article.setPrice(this.getPrice());
		article.setDescription(this.getDescription());
		return article;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getShoppingSiteName() {
		return shoppingSiteName;
	}


	public void setShoppingSiteName(String shoppingSiteName) {
		this.shoppingSiteName = shoppingSiteName;
	}


	public String getShoppingUrl() {
		return shoppingUrl;
	}


	public void setShoppingUrl(String shoppingUrl) {
		this.shoppingUrl = shoppingUrl;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((shoppingSiteName == null) ? 0 : shoppingSiteName.hashCode());
		result = prime * result + ((shoppingUrl == null) ? 0 : shoppingUrl.hashCode());
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
		ArticleJson other = (ArticleJson) obj;
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
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (shoppingSiteName == null) {
			if (other.shoppingSiteName != null)
				return false;
		} else if (!shoppingSiteName.equals(other.shoppingSiteName))
			return false;
		if (shoppingUrl == null) {
			if (other.shoppingUrl != null)
				return false;
		} else if (!shoppingUrl.equals(other.shoppingUrl))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ArticleJson [id=" + id + ", shoppingSiteName=" + shoppingSiteName + ", shoppingUrl=" + shoppingUrl
				+ ", imgUrl=" + imgUrl + ", price=" + price + "]";
	}
	
}
