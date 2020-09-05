package com.zhliang.springcloud.consul.springcloud.gateway.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 查询当前网关的所有路由信息的接口地址：
 *     http://localhost:8888/actuator/gateway/routes
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudGatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGatewayServerApplication.class, args);
    }

}
