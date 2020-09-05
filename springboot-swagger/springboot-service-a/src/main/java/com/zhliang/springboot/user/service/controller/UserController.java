package com.zhliang.springboot.user.service.controller;

import com.zhliang.springboot.user.service.service.UserService;
import com.zhliang.springboot.user.service.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springboot.user.service.controller
 * @类描述：
 * @创建人：colin
 * @创建时间：2019/10/23 17:36
 * @version：V1.0
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户信息", notes = "添加用户信息")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true)
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @ApiOperation(value = "查看信息", notes = "查看用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页个数", required = true, dataType = "int")
    })
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {

        return userService.findAllUser(pageNum, pageSize);
    }
}