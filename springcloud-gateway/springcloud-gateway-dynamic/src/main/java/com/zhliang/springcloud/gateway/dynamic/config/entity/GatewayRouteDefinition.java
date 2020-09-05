package com.zhliang.springcloud.gateway.dynamic.config.entity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springcloud.gateway.dynamic.config
 * @类描述：创建路由模型
 * @创建人：colin
 * @创建时间：2019/10/23 10:07
 * @version：V1.0
 */

@Data
public class GatewayRouteDefinition {
    //路由的Id
    private String id;
    //路由断言集合配置
    private List<GatewayPredicateDefinition> predicates = new ArrayList<>();
    //路由过滤器集合配置
    private List<GatewayFilterDefinition> filters = new ArrayList<>();
    //路由规则转发的目标uri
    private String uri;
    //路由执行的顺序
    private int order = 0;

}
