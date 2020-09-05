package com.zhliang.springcloud.consul.springcloud.feign.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: colin
 * @Date: 2019/10/22 14:29
 * @Description:
 * @Version: V1.0
 */
//name为服务提供者向注册中心注册的实例名
@FeignClient(name = "springcloud-feign-provider",fallback = HelloFeignFallbackService.class)
public interface HelloFeignService {

    //地址为服务提供者对外暴露的地址
    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

}