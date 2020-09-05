package com.zhliang.springcloud.dynamic.route.entity;

import com.alibaba.fastjson.JSON;
import com.zhliang.springcloud.dynamic.route.dto.GatewayFilterDefinition;
import com.zhliang.springcloud.dynamic.route.dto.GatewayPredicateDefinition;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Data
public class GatewayRoutes {

    private Long id;            //主键ID
    private String routeId;     //路由ID
    private String routeUri;    //转发目标URI
    private Integer routeOrder; //路由执行顺序
    private Boolean isEbl;      //是否启用
    private Boolean isDel;      //是否删除
    private Date createTime;    //创建时间
    private Date updateTime;    //更新时间
    private String predicates;  //断言字符串
    private String filters;     //过滤器字符串

    /**
     * 获取断言集合
     * @return
     */
    public List<GatewayPredicateDefinition> getPredicateDefinition(){
        if(!StringUtils.isEmpty(this.predicates)){
            return JSON.parseArray(this.predicates , GatewayPredicateDefinition.class);
        }
        return null;
    }

    /**
     * 获取过滤器集合
     * @return
     */
    public List<GatewayFilterDefinition> getFilterDefinition(){
        if(!StringUtils.isEmpty(this.filters)){
            return JSON.parseArray(this.filters , GatewayFilterDefinition.class);
        }
        return null;
    }

}