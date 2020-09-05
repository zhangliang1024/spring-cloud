package com.zhliang.springcloud.consul.springcloud.feign.provider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.feign.provider
 * @类描述：
 * @创建人：colin
 * @创建时间：2019/10/22 14:27
 * @version：V1.0
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("... request begin ...");
        try {
            //睡眠60秒，测试feign的熔断、降级
            Thread.sleep(10 * 1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("... request end ...");
        return  "hello " + name;
    }

}
