package com.springcloud.edu.api.controller;

import com.springcloud.edu.api.feign.MemberApiFeigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private MemberApiFeigin memberApiFeigin;

    @RequestMapping("/feignMember")
    public String feignMember(){
        return memberApiFeigin.getMember();
    }

}
