package com.zhliang.springcloud.consul.springcloud.ribbon.consumer;

import org.springframework.beans.factory.annotation.Autowired;
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
 */
@RestController
public class IndexControllerOne {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sayHello")
    public String sayHello(String name){
        String url = "http://springcloud-ribbon-provider/hello?name=" + name;
        String result = restTemplate.getForObject(url , String.class);
        return result;
    }
}

