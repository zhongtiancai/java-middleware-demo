package hello;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

@Component
@Service
public class Helloworld implements IHelloworld{

	@Override
	public String sayHello() {
		
		return "hello zhongtiancai";
	}

}
