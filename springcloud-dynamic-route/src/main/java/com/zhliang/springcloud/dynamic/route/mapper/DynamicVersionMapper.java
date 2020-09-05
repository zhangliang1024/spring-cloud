package com.zhliang.springcloud.dynamic.route.mapper;


import com.zhliang.springcloud.dynamic.route.entity.DynamicVersion;

import java.util.List;

public interface DynamicVersionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DynamicVersion record);

    int insertSelective(DynamicVersion record);

    DynamicVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DynamicVersion record);

    int updateByPrimaryKey(DynamicVersion record);

    //获取最后一次发布的版本号
    Long getLastVersion();

    //获取所有的版本发布信息
    List<DynamicVersion> listAll();
}