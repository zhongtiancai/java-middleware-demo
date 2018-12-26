package com.zhongtiancai;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.zhongtiancai.health.CustomizedHealthCheckHandler;

/**
 * Created by pktczwd on 2016/10/12.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ComputeServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ComputeServiceApplication.class).web(true).run(args);
    }

    //屏蔽自定义的HealthCheckHandler
    //@Bean
    public CustomizedHealthCheckHandler customizedHealthCheckHandler() {
        return new CustomizedHealthCheckHandler();
    }
}
