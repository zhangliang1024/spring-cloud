package com.zhliang.springboot.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootUserServiceApplication.class, args);
    }

}