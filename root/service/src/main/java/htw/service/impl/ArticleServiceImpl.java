package htw.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import htw.common.enums.FileDirectoryName;
import htw.common.utils.Base64Util;
import htw.common.utils.FileUtil;
import htw.dao.model.Article;
import htw.dao.model.Category;
import htw.dao.model.Size;
import htw.dao.model.json.ArticleJson;
import htw.dao.repository.ArticleRepository;
import htw.service.ArticleService;
import htw.service.CategoryService;
import htw.service.SizeService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private SizeService sizeService;
	
	@Autowired
	private CategoryService categoryService;

	@Value("${image.storageRoot}")
	private String imageStorageRoot;

	@Override
	public Article save(Article article) {
		return articleRepository.save(article);
	}
	
	@Override
	public Article replaceArticleSizesByDbSizes(Article article) {
		 List<Size> sizesFromDb = sizeService.findAll();
		 List<Size> sizesTmp = article.getSizes();
		 article.setArticleSizes(new ArrayList<>());
		 sizesTmp.forEach(st -> {
			 if(sizesFromDb.contains(st)) {
				 article.addSize(sizesFromDb.get(sizesFromDb.indexOf(st)));
			 } else {
				 article.addSize(st);
			 }
		 });
		 
		 return article;
	}
	
	@Override
	public Article replaceArticleCategoriesByDbCategories(Article article) {
		 List<Category> categoriesFromDb = categoryService.findAll();
		 List<Category> categoriesTmp = article.getCategories();
		 article.setArticleCategories(new ArrayList<>());
		 categoriesTmp.forEach(ct -> {
			 if(categoriesFromDb.contains(ct)) {
				 article.addCategory(categoriesFromDb.get(categoriesFromDb.indexOf(ct)));
			 } else {
				 article.addCategory(ct);
			 }
		 });
		 
		 return article;
	}
	
	// TODO : A SUPPRIMER
	@Override
	public void saveArticlesImgsOnDisk(List<Article> articles) {
		if (articles != null) {
			articles.forEach( a -> {
				String fileExtension = Base64Util.getExtension(a.getImgString());
				String storagePath = imageStorageRoot.concat(FileDirectoryName.IMAGES.getValue()+"/"+FileDirectoryName.ARTICLES.getValue());
				FileUtil.saveFile(a.getImgString(), 
								  storagePath, 
								  String.valueOf(a.getId()), 
								  fileExtension);
			});
		}
	}

}
