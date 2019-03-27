package com.springcloud.edu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    // SpringBoot的web组件提供，eureka默认整合了ribbon负载均衡器
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getOrder")
    public String getOrder() {
        String result = restTemplate.getForObject("http://127.0.0.1:8000/getMember", String.class);
        System.out.println("订单服务调用会员服务result: " + result);
        return result;
    }

}
