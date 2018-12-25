package com.zhongtiancai.test.activemq_test;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service  
public class MQProduceService {  
    @Autowired  
    private JmsMessagingTemplate jmsMessagingTemplate;  

    @Autowired  
    private Queue queue;  

    public void send(String msg) {//向指定队列中发送消息  
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);  
    }  
}  