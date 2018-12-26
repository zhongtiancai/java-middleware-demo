package com.zhongtiancai.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongtiancai.web.response.InfoResponse;

/**
 * Created by pktczwd on 2016/11/24.
 */
@RestController
public class InfoController {

    @RequestMapping(path = "/info")
    public InfoResponse health() {
        InfoResponse response = new InfoResponse();
        response.setStatus("UP");
        return response;
    }

}
