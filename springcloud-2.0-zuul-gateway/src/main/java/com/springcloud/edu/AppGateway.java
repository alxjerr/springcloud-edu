package com.springcloud.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy  //开启网关代理
@SpringBootApplication
public class AppGateway {

    public static void main(String[] args) {
        SpringApplication.run(AppGateway.class,args);
    }

}
