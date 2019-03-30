package com.springcloud.edu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {

    // SpringBoot的web组件提供，eureka默认整合了ribbon负载均衡器
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/getOrder")
    public String getOrder() {
        String url = "http://app-member/getMember"; //使用别名去注册中心获取对应的服务
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("订单服务调用会员服务result: " + result);
        return result;
    }

    //获取注册中心上的服务列表
    @RequestMapping("/discoveryClient")
    public List<ServiceInstance> discoveryClientMember(){
        List<ServiceInstance> instances = discoveryClient.getInstances("app-member");

        for (ServiceInstance instance : instances){
            System.out.println("url: " + instance.getUri());
        }
        return instances;
    }
}
