package com.zhliang.springcloud.gateway.consumer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.gateway.consumer
 * @类描述：
 * @创建人：colin
 * @创建时间：2019/10/22 20:07
 * @version：V1.0
 */
@RestController
public class IndexController {

    @RequestMapping("/hello")
    public String hello(String name) {
        return "hi " + name;
    }

    @RequestMapping("/timeout")
    public String timeout() {
        try {
            //睡5秒，网关Hystrix3秒超时，会触发熔断降级操作
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "timeout";
    }
}