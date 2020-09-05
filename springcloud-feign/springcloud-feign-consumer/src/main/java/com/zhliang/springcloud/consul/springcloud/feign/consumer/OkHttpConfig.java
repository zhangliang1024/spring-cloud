package com.zhliang.springcloud.consul.springcloud.feign.consumer;

import feign.Feign;
import okhttp3.ConnectionPool;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.feign.consumer
 * @类描述： 配置okhttp与连接池 ConnectionPool默认创建5个线程，保持5分钟长连接
 * @创建人：colin
 * @创建时间：2019/10/22 14:41
 * @version：V1.0
 */
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class OkHttpConfig {

    @Bean
    public okhttp3.OkHttpClient okHttpClient(){
        return new okhttp3.OkHttpClient.Builder()
                //设置连接超时
                .connectTimeout(10 , TimeUnit.SECONDS)
                //设置读超时
                .readTimeout(10 , TimeUnit.SECONDS)
                //设置写超时
                .writeTimeout(10 , TimeUnit.SECONDS)
                //是否自动重连
                .retryOnConnectionFailure(true)
                //默认创建10个线程，保持5分钟长连接
                .connectionPool(new ConnectionPool(10 , 5L, TimeUnit.MINUTES))
                .build();
    }
}
