package com.zhongtiancai.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.endpoint.BusEndpoint;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@RefreshScope
@ComponentScan("com.zhongtiancai")
public class App 
{
	@Value("${name:World}")
    String bar;

    @RequestMapping("/")
    String hello() {
        return "Hello " + bar + "!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
