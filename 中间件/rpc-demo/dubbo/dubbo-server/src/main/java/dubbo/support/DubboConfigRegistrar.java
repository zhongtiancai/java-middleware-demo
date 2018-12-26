package dubbo.support;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

@Configuration
public class DubboConfigRegistrar implements ImportBeanDefinitionRegistrar{
	private static  String basePackage = "";
	private static  String applicationName = "";
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

	    AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata
	        .getAnnotationAttributes(EnableDubbo.class.getName()));
	    basePackage = attributes.getString("basePackage");
	    applicationName=attributes.getString("applicationName");
	  
	}
	
	public static String getBasePackage(){
		return basePackage;
		
	}
	public static String getApplicationName(){
		return applicationName;
		
	}


}
