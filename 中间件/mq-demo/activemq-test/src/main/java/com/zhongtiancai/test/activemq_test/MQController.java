package com.zhongtiancai.test.activemq_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class MQController {  

    @Autowired  
    private MQProduceService produceService;  



    @RequestMapping("/send")  
    public String send() {  
        produceService.send("this is an activemq message");  
        return "send";  
    }  
      
    
}  