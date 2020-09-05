package com.zhliang.springcloud.consul.springcloud.feign.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.feign.simple
 * @类描述：
 * @创建人：colin
 * @创建时间：2019/10/22 14:05
 * @version：V1.0
 */
@RestController
public class IndexController {

    @Autowired
    private HelloFeignService feignService;

    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public String search(String name){
        return feignService.hello(name);
    }

}
