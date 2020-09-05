package com.zhliang.springcloud.consul.springcloud.service.a;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FourController {

    @RequestMapping("/Four")
    public String Four(){
        System.out.println("Four...");
        return " service-d hello , end";
    }
}
