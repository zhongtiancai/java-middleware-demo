package dubbo.support;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DubboConfigRegistrar.class,DubboConfig.class})
@Configuration
public @interface EnableDubbo {
   String basePackage() default "";
   String applicationName() default "";
}
