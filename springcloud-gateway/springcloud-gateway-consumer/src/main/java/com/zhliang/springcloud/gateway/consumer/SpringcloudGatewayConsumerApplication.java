package com.zhliang.springcloud.gateway.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudGatewayConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGatewayConsumerApplication.class, args);
    }

}
