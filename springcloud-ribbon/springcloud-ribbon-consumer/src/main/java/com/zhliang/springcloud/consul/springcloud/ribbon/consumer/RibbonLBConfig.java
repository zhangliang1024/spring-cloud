package com.zhliang.springcloud.consul.springcloud.ribbon.consumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.zhliang.springcloud.ribbon.MyRibbonRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.ribbon.consumer
 * @类描述：
 * @创建人：colin
 * @创建时间：2019/10/22 16:18
 * @version：V1.0
 */

@Configuration
public class RibbonLBConfig {

    /**
     * Ribbon 的负载均衡策略
     * - 随机、轮询、最小并发、响应时间加权等策略
     * @return
     */
    //使用随机策略
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }

    /**
     * ★ 使用 自定义负载策略
     * 自定义负载均衡算法：https://blog.csdn.net/www1056481167/article/details/81151064
     *
     */
    //@Bean
    public IRule myRule(){
        return new MyRibbonRule();
    }
}
