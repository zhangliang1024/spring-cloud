package com.zhliang.springcloud.consul.springcloud.feign.consumer;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.feign.consumer
 * @类描述：
 * @创建人：colin
 * @创建时间：2019/10/22 14:37
 * @version：V1.0
 */
@Configuration
public class FeignLogConfig {

    /**
     * feign开启日志有两种方式：
     *  - 一种是使用配置文件
     *  - 一种是使用java代码
     *
     * 下面将介绍代码方式：
     *
     * 日志level有4个级别
     * 1.NONE，不记录任何日志
     * 2.BASIC，仅记录请求方法、URL以及响应状态码和执行时间
     * 3.HEADRES，除了BASIC以外的还会记录请求和响应的头信息
     * 4.FULL,所有
     * @return
     */
    @Bean
    Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}
