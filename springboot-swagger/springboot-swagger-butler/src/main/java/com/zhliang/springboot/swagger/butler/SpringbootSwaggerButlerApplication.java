package com.zhliang.springboot.swagger.butler;

import com.didispace.swagger.butler.EnableSwaggerButler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 程序员DD
 * API文档汇总管理工具Swagger Butler:
 *   - http://blog.didispace.com/opensource-api-mgt-Swagger-Butler/
 *   - https://github.com/dyc87112/swagger-butler
 *
 *   问题：
 *   1. 整合过程中，新建service-a\service-b 服务来配置演示没有加入eureka时通过zuul来指定服务路由
 *   2. 加入eureka中，注意版本的兼容问题。1.x和2.x 要使用不同的版本。
 *      否则版本不兼容：
 *      java.lang.NoSuchMethodError: org.springframework.boot.builder.SpringApplicationBuilder.<init>([Ljava/lang/Object;)V
 */
@SpringBootApplication
@EnableSwaggerButler
@EnableDiscoveryClient
public class SpringbootSwaggerButlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwaggerButlerApplication.class, args);
    }

}
