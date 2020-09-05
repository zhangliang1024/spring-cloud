package com.zhliang.springcloud.consul.springcloud.feign.simple;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.feign.simple
 * @类描述：
 * @创建人：colin
 * @创建时间：2019/10/22 14:04
 * @version：V1.0
 */

//指定了url就会访问该url地址，否则会把name参数当作服务名到注册中心中查询该名字服务，此时指定了url后可以随意命名
@FeignClient(name = "search-github" , url = "https://api.github.com")
public interface IIndexFeignService {

    @RequestMapping(value = "/search/repositories" , method = RequestMethod.GET)
    String search(@RequestParam("q") String query);

}

