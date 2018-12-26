package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@ImportResource({"classpath:spring/applicationContext*.xml"})
@SpringBootApplication
@RestController
public class Application {
   @Autowired
   private IHelloworld hello;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @RequestMapping("/hello")
    public String hello(){
    	return hello.sayHello();
    }
 
}
