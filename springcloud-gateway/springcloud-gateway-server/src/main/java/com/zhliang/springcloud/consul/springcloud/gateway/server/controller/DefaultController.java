package com.zhliang.springcloud.consul.springcloud.gateway.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.gateway.server.controller
 * @类描述：默认降级处理
 * @创建人：colin
 * @创建时间：2019/10/22 20:41
 * @version：V1.0
 */
@RestController
public class DefaultController {

    @RequestMapping("/default/fallback")
    public Map<String, String> defaultfallback() {
        System.out.println("default 降级操作...");
        Map<String, String> map = new HashMap<>();
        map.put("resultCode", "fail");
        map.put("resultMessage", "default 服务异常");
        map.put("resultObj", "null");
        return map;
    }

}
