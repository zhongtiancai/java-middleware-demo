package hello;

import org.springframework.context.annotation.Configuration;

import dubbo.support.EnableDubbo;

@Configuration
@EnableDubbo(basePackage = "hello",applicationName="hello")
public class MyConfigure {
	
}
