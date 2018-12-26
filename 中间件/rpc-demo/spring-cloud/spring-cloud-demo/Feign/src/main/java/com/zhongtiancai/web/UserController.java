package com.zhongtiancai.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhongtiancai.client.UserClient;

/**
 * Created by pktczwd on 2016/10/24.
 */
@RestController
public class UserController {

    @Autowired
    private UserClient userClient;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Integer get(@PathVariable Integer id) {
        return userClient.get(id);
    }


}
