package com.zhongtiancai.test.activemq_test;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service  
public class MQConsumerService {  

    @JmsListener(destination = "sample.queue")//监听指定消息队列  
    public void receiveQueue(String text) {   
        System.out.println(text);  
        throw new RuntimeException();
    }  

  
}  