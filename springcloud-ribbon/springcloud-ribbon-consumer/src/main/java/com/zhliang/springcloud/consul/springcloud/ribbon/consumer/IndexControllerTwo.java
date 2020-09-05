package com.zhliang.springcloud.consul.springcloud.ribbon.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.ribbon.consumer
 * @类描述：
 * @创建人：colin
 * @创建时间：2019/10/22 16:15
 * @version：V1.0
 *
 * Ribbon自定义负载均衡： https://blog.csdn.net/zzzzzz55300411/article/details/54352534
 */
@RestController
//name是provider的服务名  RibbonConfiguration为自定义配置
//@RibbonClient(name = "springcloud-ribbon-provider", configuration = RibbonConfiguration.class)
public class IndexControllerTwo {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sayHello")
    public String sayHello(String name){
        String url = "http://springcloud-ribbon-provider/hello?name=" + name;
        String result = restTemplate.getForObject(url , String.class);
        return result;
    }
}

