package com.zhongtiancai.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@RestController
@EnableConfigServer
@ComponentScan("com.zhongtiancai")
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
