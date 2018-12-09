package htw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import htw.dao.Test;
import htw.dao.impl.TestRepository;

@SpringBootApplication
@RestController
public class Application {
	
	@Autowired
	private TestRepository testRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }	
    
    @GetMapping("/test")
    public void test() {
    	System.out.println("start");
    	Test test = new Test();
    	test.setName("test");
    	testRepository.save(test);
    	System.out.println("ok");
    	
    }
    
}
