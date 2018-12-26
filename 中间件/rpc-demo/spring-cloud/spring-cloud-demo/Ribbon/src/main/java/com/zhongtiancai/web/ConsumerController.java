package com.zhongtiancai.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhongtiancai.service.ComputeService;

/**
 * Created by pktczwd on 2016/10/13.
 */
@RestController
public class ConsumerController {

    private static final Logger log = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private ComputeService computeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        log.info("receive add request.");
        return computeService.addService();
    }

}
