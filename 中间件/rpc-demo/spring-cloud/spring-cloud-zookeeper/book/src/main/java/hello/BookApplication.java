package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import feign.RequestLine;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BookApplication {
   Logger logger=LoggerFactory.getLogger(getClass());
   
   
   @FeignClient(name="book2")
   interface Book2 {  // 1
	   @RequestMapping(value = "/available", method = RequestMethod.GET)
       String available();
       
	   @RequestMapping(value = "/checked-out", method = RequestMethod.GET)
       String checkedOut();
   }

   @Autowired
   private Book2 book2;

  @RequestMapping(value = "/available")
  public String available() {
    return book2.available();
  }

  @RequestMapping(value = "/checked-out")
  public String checkedOut() {
    return book2.checkedOut();
  }

  public static void main(String[] args) {
    SpringApplication.run(BookApplication.class, args);
  }
}
