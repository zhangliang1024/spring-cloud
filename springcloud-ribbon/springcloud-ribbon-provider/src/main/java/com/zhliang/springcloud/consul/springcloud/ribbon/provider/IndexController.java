package com.zhliang.springcloud.consul.springcloud.ribbon.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.ribbon.provider
 * @类描述：
 * @创建人：colin
 * @创建时间：2019/10/22 16:10
 * @version：V1.0
 */
@RestController
public class IndexController {

    @GetMapping("/hello")
    public String hello(String name , HttpServletRequest request){
        //返回端口信息
        return " From Port : " + request.getServerPort() + " , hello " + name;
    }
}

