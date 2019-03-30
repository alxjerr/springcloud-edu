package com.springcloud.edu.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "app-member")
public interface MemberApiFeigin {

    //Feign 书写方式以SpringMVC 接口形式书写

    @RequestMapping("/getMember")
    public String getMember();

}
