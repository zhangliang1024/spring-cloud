package com.zhliang.springcloud.consul.springcloud.ribbon.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudRibbonProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonProviderApplication.class, args);
    }

}
