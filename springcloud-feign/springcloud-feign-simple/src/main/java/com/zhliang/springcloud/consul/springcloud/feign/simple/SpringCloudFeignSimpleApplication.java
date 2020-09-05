package com.zhliang.springcloud.consul.springcloud.feign.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//开启对Feign的支持
@EnableFeignClients
@SpringBootApplication
public class SpringCloudFeignSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignSimpleApplication.class, args);
    }

}
