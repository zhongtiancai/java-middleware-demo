/**
 * 
 */
package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhongtiancai
 * @copyright frontpay.cn
 * @date 2017年1月18日
 */
@RequestMapping("/")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
   @RequestMapping("/customer")
   public ResponseEntity<String> qiangou(){
	 //  Customer customer=customerService.addCustomer();
	   kafkaTemplate.send("test","{\"hello\",\"world\"}");
	   return ResponseEntity.ok("hello");
   }
}
