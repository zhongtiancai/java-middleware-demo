package hello;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @RequestMapping("/hello")
    public String hello() throws Exception{
    	JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
    	Client client = dcf.createClient("http://localhost:8081/soap/hello?wsdl");
    	Object[] objects = client.invoke("sayHello", 10002L);
    	return (String)objects[0];
    }
 
}
