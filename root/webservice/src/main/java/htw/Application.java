package htw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    	Article article1 = new Article("shoppingSiteName1", "shoppingUrl1", "imgUrl1", 1.0);
    	Article article2 = new Article("shoppingSiteName2", "shoppingUrl2", "imgUrl2", 2.0);
    	Look look = new Look("lookImgUrl");
    	look.addArticle(article1);
    	look.addArticle(article2);
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
