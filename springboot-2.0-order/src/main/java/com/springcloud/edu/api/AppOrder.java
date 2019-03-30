package com.springcloud.edu.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AppOrder {

    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class,args);
    }

    //如果使用rest以别名方式进行调用依赖，需要使用ribbon
    @Bean
    @LoadBalanced //能让这个RestTemplate在请求时拥有客户端负载均衡能力
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
