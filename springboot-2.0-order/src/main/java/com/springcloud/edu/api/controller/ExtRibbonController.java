package com.springcloud.edu.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 手写Ribbon本地负载均衡
 */
@RestController
public class ExtRibbonController {

    //可以获取注册中心上的服务列表
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    //定义接口请求总数
    private int reqCount = 1;

    @RequestMapping("/ribbonMember")
    public String ribbonMember(){
        String instacesUrl = getInstace() + "/getMember";
        //2.使用rest方式发送请求
        String result = restTemplate.getForObject(instacesUrl, String.class);
        return result;
    }

    private String getInstace(){
        //1.获取对应服务器的远程调用地址
        List<ServiceInstance> instances = discoveryClient.getInstances("app-member");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        //获取集群中服务器的个数
        int instanceSize =instances.size();
        int serviceIndex = reqCount % instanceSize;
        reqCount++;
        return instances.get(serviceIndex).getUri().toString();
    }

}
