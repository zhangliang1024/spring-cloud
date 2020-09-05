package com.zhliang.springcloud.gateway.dynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

//开启支持定时任务
@EnableScheduling
@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudGatewayDynamicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGatewayDynamicApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
