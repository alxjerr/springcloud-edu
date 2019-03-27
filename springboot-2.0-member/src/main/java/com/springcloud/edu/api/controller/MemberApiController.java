package com.springcloud.edu.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {

    @RequestMapping("/getMember")
    public String getMember(){

        return "this is member,SpringBoot2.0版本！";
    }
}
