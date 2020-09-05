package com.zhliang.springcloud.consul.springcloud.feign.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * SpringCloud实战六：Spring Cloud Feign 高级应用
 *  - https://blog.csdn.net/zhuyu19911016520/article/details/84963568
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudFeignProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudFeignProviderApplication.class, args);
    }

}
