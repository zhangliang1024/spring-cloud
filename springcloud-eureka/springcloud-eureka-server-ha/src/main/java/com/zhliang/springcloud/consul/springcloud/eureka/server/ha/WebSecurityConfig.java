package com.zhliang.springcloud.consul.springcloud.eureka.server.ha;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.eureka.server
 * @类描述：
 * @创建人：colin
 * @创建时间：2019/10/22 11:40
 * @version：V1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 新版的security默认启用了csrf检验，要在eureka-server服务端配置security的csrf检验为false，
     * eureka-client才能注册，而且它还不支持在配置文件中配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
}
