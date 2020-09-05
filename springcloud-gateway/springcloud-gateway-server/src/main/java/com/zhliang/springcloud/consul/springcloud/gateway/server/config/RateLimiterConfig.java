package com.zhliang.springcloud.consul.springcloud.gateway.server.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.gateway.server.config
 * @类描述：路由限流配置 演示IP限流
 * @创建人：colin
 * @创建时间：2019/10/22 20:52
 * @version：V1.0
 */
@Configuration
public class RateLimiterConfig {

    /**
     * SpringCloud Gateway默认集成了Redis限流,可以针对不同服务做不同维度的限流
     * - IP限流
     * - 用户限流
     * - 接口限流
     * <p>
     * 真实的业务场景中：限流数的调整要依赖配置中心做动态调整
     */

    //通过KeyResolver来指定限流的Key
    @Bean(value = "remoteAddrKeyResolver")
    public KeyResolver remoteAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

    //用户限流：请求路径中必须携带userId参数
    @Bean(value = "userKeyResolver")
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }

    //接口限流：获取请求地址uri做为限流key
    @Bean(value = "apiKeyResolver")
    KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }


}
