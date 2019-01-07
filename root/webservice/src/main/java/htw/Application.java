package htw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import htw.common.enums.LookArticleAssociationType;
import htw.dao.model.Article;
import htw.dao.model.Look;
import htw.service.LookService;

@SpringBootApplication
@RestController
public class Application {
	
	@Autowired
	private LookService lookService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }	
    
    @GetMapping("/testLookArticleAssociation")
    public void testLookArticleAssociation() {
    	
    	System.out.println("start");
    	Article article1 = new Article("shoppingSiteName1", "shoppingUrl1", "brand1", "imgUrl1", 1.0, "desc");
    	Article article2 = new Article("shoppingSiteName2", "shoppingUrl2", "brand2", "imgUrl2", 2.0, "desc");
    	Look look = new Look("lookImgUrl");
    	look.addArticle(article1, LookArticleAssociationType.PRINCIPAL, 1);
    	look.addArticle(article2, LookArticleAssociationType.SECONDARY, 1);
    	lookService.save(look);
    	System.out.println("ok");
    	
    }
    
    @GetMapping("/testGetAllLook")
    public List<Look> testGetAllLooks(){
    	
    	List<Look> looks = lookService.findAll();
    	looks.forEach(l -> {
    		System.out.println("LOOK : "+l.getLookArticles().get(0).getArticle());
    	});
    	return null;
    	
    }
    
}
