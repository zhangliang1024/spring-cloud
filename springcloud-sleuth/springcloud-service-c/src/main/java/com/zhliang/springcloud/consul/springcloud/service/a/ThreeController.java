package com.zhliang.springcloud.consul.springcloud.service.a;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreeController {

    @RequestMapping("/Three")
    public String Three(){
        System.out.println("Three...");
        return " service-c hello , ";
    }

}
