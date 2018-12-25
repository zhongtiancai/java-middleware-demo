/**
 * 
 */
package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhongtiancai
 * @copyright frontpay.cn
 * @date 2017年1月18日
 */
@Component
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer() {
		// 模拟其他处理例如获取用户id 当前时间处理
		
		
			
				Customer customer = new Customer("zhong", "tiancai");
				return customerRepository.save(customer);
		

	}
}
