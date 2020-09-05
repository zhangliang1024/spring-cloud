package com.zhliang.springcloud.dynamic.route.service;


import com.zhliang.springcloud.dynamic.route.dto.GatewayRouteDefinition;
import com.zhliang.springcloud.dynamic.route.entity.GatewayRoutes;
import com.zhliang.springcloud.dynamic.route.mapper.GatewayRoutesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoutesService {

    @Autowired
    private GatewayRoutesMapper mapper;

    public int add(GatewayRoutes route) {
        route.setIsEbl(false);
        route.setIsDel(false);
        route.setCreateTime(new Date());
        route.setUpdateTime(new Date());
        return mapper.insertSelective(route);
    }

    public int update(GatewayRoutes route) {
        route.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(route);
    }

    public int delete(Long id, boolean isDel) {
        return mapper.deleteByPrimaryKey(id , isDel);
    }

    public int enableById(Long id, boolean isEbl) {
        return mapper.enableById(id , isEbl);
    }

    public GatewayRoutes getById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询路由信息
     * @return
     */
    public List<GatewayRoutes> getRoutes(GatewayRoutes route) {
        return mapper.getRoutes(route);
    }

    /**
     * 返回组装后网关需要的路由信息
     * @return
     */
    public List<GatewayRouteDefinition> getRouteDefinitions() {
        List<GatewayRouteDefinition> routeDefinitions = new ArrayList<>();
        GatewayRoutes route = new GatewayRoutes();
        route.setIsDel(false);
        route.setIsEbl(false);
        List<GatewayRoutes> routes = getRoutes(route);
        for(GatewayRoutes gatewayRoute : routes){
            GatewayRouteDefinition routeDefinition = new GatewayRouteDefinition();
            routeDefinition.setId(gatewayRoute.getRouteId());
            routeDefinition.setUri(gatewayRoute.getRouteUri());
            routeDefinition.setFilters(gatewayRoute.getFilterDefinition());
            routeDefinition.setPredicates(gatewayRoute.getPredicateDefinition());
            routeDefinitions.add(routeDefinition);
        }
        return routeDefinitions;
    }

}
