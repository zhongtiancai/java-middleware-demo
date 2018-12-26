package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class BookApplication {
   Logger logger=LoggerFactory.getLogger(getClass());
  
  
  public static void main(String[] args) {
    SpringApplication.run(BookApplication.class, args);
  }
  
  
  @RequestMapping(value = "/available")
  public String available() {
    return "hello available";
  }

  @RequestMapping(value = "/checked-out")
  public String checkedOut() {
    return "hello checked-out";
  }
}
