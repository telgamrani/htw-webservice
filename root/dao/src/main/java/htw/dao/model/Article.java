package htw.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

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
	
	private String imgUrl;
	
	@Lob
	@Column(name = "imgString", columnDefinition = "LONGTEXT")
	private String imgString;
	
	private Double price;
	
	private String description;
	
//	@OneToMany(
//        mappedBy = "article",
//        cascade = CascadeType.ALL,
//        orphanRemoval = true
//    )
//    private List<LookArticle> looksArticle = new ArrayList<>();

	
	public Article() {}
	
	public Article(String shoppingSiteName, String shoppingUrl, String brand, String imgUrl, Double price, String description) {
		this.shoppingSiteName = shoppingSiteName;
		this.shoppingUrl = shoppingUrl;
		this.brand = brand;
		this.imgUrl = imgUrl;
		this.price = price;
		this.description = description;
	}
	
	public Article(Article article) {
		this.shoppingSiteName = article.getShoppingSiteName();
		this.shoppingUrl = article.getShoppingUrl();
		this.brand = article.getBrand();
		this.imgUrl = article.getImgUrl();
		this.price = article.getPrice();
		this.description = article.getDescription();
	}

	public ArticleJson convertToJson() {
		ArticleJson articleJson = new ArticleJson();
		articleJson.setId(this.getId());
		articleJson.setImgUrl(this.getImgUrl());
		articleJson.setShoppingSiteName(this.getShoppingSiteName());
		articleJson.setShoppingUrl(this.getShoppingUrl());
		articleJson.setBrand(this.getBrand());
		articleJson.setPrice(this.getPrice());
		articleJson.setDescription(this.getDescription());
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
		Article other = (Article) obj;
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
		return "Article [id=" + id + ", shoppingSiteName=" + shoppingSiteName + ", shoppingUrl=" + shoppingUrl
				+ ", imgUrl=" + imgUrl + ", price=" + price + "]";
	}
	
	
	
}
