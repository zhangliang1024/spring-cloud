package com.zhliang.springcloud.dynamic.route.service;


import com.alibaba.fastjson.JSON;
import com.zhliang.springcloud.dynamic.route.config.RedisConfig;
import com.zhliang.springcloud.dynamic.route.entity.DynamicVersion;
import com.zhliang.springcloud.dynamic.route.mapper.DynamicVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DynamicVersionService {

    @Autowired
    private DynamicVersionMapper mapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RoutesService routesService;

    public int add(DynamicVersion version) {
        version.setCreateTime(new Date());
        int result = mapper.insertSelective(version);

        //发布时，把版本信息与路由信息存入redis
        redisTemplate.opsForValue().set(RedisConfig.versionKey , String.valueOf(version.getId()));
        redisTemplate.opsForValue().set(RedisConfig.routeKey , JSON.toJSONString(routesService.getRouteDefinitions()));

        return result;
    }

    public int update(DynamicVersion version) {
        return mapper.updateByPrimaryKeySelective(version);
    }

    public int delete(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * 获取最后一次发布的版本号
     * @return
     */
    public Long getLastVersion() {
        return mapper.getLastVersion();
    }

    public List<DynamicVersion> listAll() {
        return mapper.listAll();
    }
}
