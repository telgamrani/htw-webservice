package htw.dao.model.json;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import htw.common.enums.ArticleCategoryType;
import htw.common.enums.LookArticleAssociationType;
import htw.dao.model.Article;
import htw.dao.model.Category;
import htw.dao.model.Image;
import htw.dao.model.Size;

public class ArticleJson {
	
	private Long id;
	
	private String shoppingSiteName;
	
	@NotEmpty
	private String shoppingUrl;
	
	// TODO : A SUPPRIMER
	private String imgUrl;
	
	// TODO : A SUPPRIMER
	private String imgString;
	
	private String brand;
	
	private Double price;
	
	private String description;
	
	private LookArticleAssociationType lookArticleAssociationType;
	
	private int rank;
	
	private List<String> sizes = new ArrayList<>();
	
	private String color;
	
	@NotEmpty
	private List<String> images = new ArrayList<>();
	
	private List<String> categories = new ArrayList<>();
	
	public ArticleJson() {}

	public Article convertToDao() {
		Article article = new Article();
		article.setId(this.getId());
		article.setShoppingSiteName(this.getShoppingSiteName());
		article.setShoppingUrl(this.getShoppingUrl());
		article.setBrand(this.getBrand());
		article.setPrice(this.getPrice());
		article.setDescription(this.getDescription());
		article.setColor(this.getColor());
		if(this.getImages() != null && this.getImages().size() > 0) {
			this.getImages().forEach(i -> {
				article.addImage(new Image(i));
			});
		}
		if(this.getCategories() != null && this.getCategories().size() > 0) {
			this.getCategories().forEach(c -> {
				article.addCategory(new Category(ArticleCategoryType.valueOf(c)));
			});
		}
		if(this.getSizes() != null && this.getSizes().size() > 0) {
			this.getSizes().forEach(s -> {
				article.addSize(new Size(s));
			});
		}
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

	public List<String> getSizes() {
		return sizes;
	}

	public void setSizes(List<String> sizes) {
		this.sizes = sizes;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((imgString == null) ? 0 : imgString.hashCode());
		result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
		result = prime * result + ((lookArticleAssociationType == null) ? 0 : lookArticleAssociationType.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + rank;
		result = prime * result + ((shoppingSiteName == null) ? 0 : shoppingSiteName.hashCode());
		result = prime * result + ((shoppingUrl == null) ? 0 : shoppingUrl.hashCode());
		result = prime * result + ((sizes == null) ? 0 : sizes.hashCode());
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
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (imgString == null) {
			if (other.imgString != null)
				return false;
		} else if (!imgString.equals(other.imgString))
			return false;
		if (imgUrl == null) {
			if (other.imgUrl != null)
				return false;
		} else if (!imgUrl.equals(other.imgUrl))
			return false;
		if (lookArticleAssociationType != other.lookArticleAssociationType)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (rank != other.rank)
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
		if (sizes == null) {
			if (other.sizes != null)
				return false;
		} else if (!sizes.equals(other.sizes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArticleJson [id=" + id + ", shoppingSiteName=" + shoppingSiteName + ", shoppingUrl=" + shoppingUrl
				+ ", imgUrl=" + imgUrl + ", imgString=" + imgString + ", brand=" + brand + ", price=" + price
				+ ", description=" + description + ", lookArticleAssociationType=" + lookArticleAssociationType
				+ ", rank=" + rank + ", sizes=" + sizes + ", color=" + color + ", images=" + images + "]";
	}

	
}
