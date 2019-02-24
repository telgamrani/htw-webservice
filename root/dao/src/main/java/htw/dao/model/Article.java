package htw.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import htw.dao.model.association.ArticleCategory;
import htw.dao.model.association.ArticleSize;
import htw.dao.model.json.ArticleJson;

@Entity
@Table(name = "article")
public class Article implements Serializable{
	
	private static final long serialVersionUID = 1136508066271557791L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String shoppingSiteName;
	
	private String shoppingUrl;
	
	private String brand;
	
	private int indexImagePrincipal;
	
	// TODO : A SUPPRIMER	
	@Lob
	@Column(name = "imgString", columnDefinition = "LONGTEXT")
	private String imgString;
	
	private Double price;
	
	private String description;
	
	@OneToMany(
			mappedBy = "article",
			cascade = CascadeType.PERSIST
	)
	private List<ArticleCategory> articleCategories = new ArrayList<>();
	
	@OneToMany(
			mappedBy = "article",
			cascade = CascadeType.PERSIST
	)
	private List<ArticleSize> articleSizes = new ArrayList<>();
	
	private String color;
	
	@OneToMany(
			fetch = FetchType.LAZY,
			cascade = CascadeType.PERSIST
	)
	private List<Image> images = new ArrayList<>();
	
// DONT REMOVE
//	@OneToMany(
//  	mappedBy = "article",
//  	cascade = CascadeType.ALL,
//  	orphanRemoval = true
//	)
//	private List<LookArticle> looksArticle = new ArrayList<>();	
	
	public Article() {}
	
	public Article(String shoppingSiteName, String shoppingUrl, String brand, int indexImagePrincipal, Double price, String description) {
		this.shoppingSiteName = shoppingSiteName;
		this.shoppingUrl = shoppingUrl;
		this.brand = brand;
		this.indexImagePrincipal = indexImagePrincipal;
		this.price = price;
		this.description = description;
	}

	public ArticleJson convertToJson() {
		ArticleJson articleJson = new ArticleJson();
		articleJson.setId(this.getId());
		articleJson.setIndexImagePrincipal(this.getIndexImagePrincipal());
		articleJson.setShoppingSiteName(this.getShoppingSiteName());
		articleJson.setShoppingUrl(this.getShoppingUrl());
		articleJson.setBrand(this.getBrand());
		articleJson.setPrice(this.getPrice());
		articleJson.setDescription(this.getDescription());
		articleJson.setColor(this.getColor());
		if(this.getImages() != null && this.getImages().size() > 0) {
			articleJson.setImages(this.getImages().stream().map(i -> i.getPath()).collect(Collectors.toList()));
		}
		if(this.getCategories() != null && this.getCategories().size() > 0) {
			articleJson.setCategories(this.getCategories().stream().map(c -> c.getValue().name()).collect(Collectors.toList()));
		}
		if(this.getSizes() != null && this.getSizes().size() > 0) {
			articleJson.setSizes(this.getSizes().stream().map(s -> s.getValue()).collect(Collectors.toList()));
		}
		return articleJson;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getIndexImagePrincipal() {
		return indexImagePrincipal;
	}

	public void setIndexImagePrincipal(int indexImagePrincipal) {
		this.indexImagePrincipal = indexImagePrincipal;
	}

	public String getImgString() {
		return imgString;
	}

	public void setImgString(String imgString) {
		this.imgString = imgString;
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
	
	public List<ArticleCategory> getArticleCategories() {
		return articleCategories;
	}

	public void setArticleCategories(List<ArticleCategory> articleCategories) {
		this.articleCategories = articleCategories;
	}
	
	public void addArticleCategory(ArticleCategory articleCategory) {
		this.articleCategories.add(articleCategory);
	}
	
	public void addCategory(Category category) {
		ArticleCategory articleCategory = new ArticleCategory(this, category);
		this.addArticleCategory(articleCategory);
	}
	
	public List<Category> getCategories() {
		return this.getArticleCategories().stream().map(ac -> ac.getCategory()).collect(Collectors.toList());
	}

	public List<ArticleSize> getArticleSizes() {
		return articleSizes;
	}

	public void setArticleSizes(List<ArticleSize> articleSizes) {
		this.articleSizes = articleSizes;
	}
	
	public void addArticleSize(ArticleSize articleSize) {
		this.articleSizes.add(articleSize);
	}
	
	public void addSize(Size size) {
		ArticleSize articleSize = new ArticleSize(this, size);
		this.addArticleSize(articleSize);
	}
	
	public List<Size> getSizes() {
		List<Size> sizes = new ArrayList<>();
		if(this.getArticleSizes() != null) {
			this.getArticleSizes().forEach(as -> sizes.add(as.getSize()));
		}
		return this.getArticleSizes().stream().map(as -> as.getSize()).collect(Collectors.toList());
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	
	public void addImage(Image image) {
		this.getImages().add(image);
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
		result = prime * result + indexImagePrincipal;
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
		Article other = (Article) obj;
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
		if (indexImagePrincipal != other.indexImagePrincipal)
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
		return "Article [id=" + id + ", shoppingSiteName=" + shoppingSiteName + ", shoppingUrl=" + shoppingUrl
				+ ", brand=" + brand + ", indexImagePrincipal=" + indexImagePrincipal + ", imgString=" + imgString
				+ ", price=" + price + ", description=" + description + ", articleCategories=" + articleCategories
				+ ", articleSizes=" + articleSizes + ", color=" + color + ", images=" + images + "]";
	}
	
}
