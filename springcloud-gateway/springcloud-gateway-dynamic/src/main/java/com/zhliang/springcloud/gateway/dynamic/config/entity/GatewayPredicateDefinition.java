package com.zhliang.springcloud.gateway.dynamic.config.entity;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.gateway.dynamic.config
 * @类描述：路由断言模型
 * @创建人：colin
 * @创建时间：2019/10/23 10:09
 * @version：V1.0
 */
@Data
public class GatewayPredicateDefinition {

    //断言对应的Name
    private String name;
    //配置的断言规则
    private Map<String, String> args = new LinkedHashMap<>();
}
