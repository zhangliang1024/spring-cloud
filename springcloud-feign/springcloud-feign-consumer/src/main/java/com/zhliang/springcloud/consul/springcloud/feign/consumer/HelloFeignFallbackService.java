package com.zhliang.springcloud.consul.springcloud.feign.consumer;

import org.springframework.stereotype.Service;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.feign.consumer
 * @类描述： hystrix服务降级处理，防止因超时、异常等导致的服务调用雪崩
 * @创建人：colin
 * @创建时间：2019/10/22 14:48
 * @version：V1.0
 */
@Service
public class HelloFeignFallbackService implements HelloFeignService{

    @Override
    public String hello(String name) {
        return "未找到" + name ;
    }
}
