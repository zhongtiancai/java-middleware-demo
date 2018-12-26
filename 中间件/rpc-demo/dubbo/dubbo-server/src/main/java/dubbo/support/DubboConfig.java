package dubbo.support;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;

@Configuration
public class DubboConfig {
	
	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig(DubboConfigRegistrar.getApplicationName());
		return applicationConfig;
	}

	@Bean
	public RegistryConfig registerConfig() {
		RegistryConfig registryConfig = new RegistryConfig("zookeeper://139.129.28.224:2181");
		return registryConfig;
	}

	@Bean
	public ProtocolConfig protocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig("dubbo", 20880);
		return protocolConfig;
	}

	@Bean
	public AnnotationBean annotationBean() {
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage(DubboConfigRegistrar.getBasePackage());
		return annotationBean;
	}
}
