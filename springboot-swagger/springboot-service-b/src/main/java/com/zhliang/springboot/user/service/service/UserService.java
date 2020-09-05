package com.zhliang.springboot.user.service.service;

import com.zhliang.springboot.user.service.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @项目名称：spring-cloud
 * @包名：com.zhliang.springboot.user.service
 * @类描述：
 * @创建人：colin
 * @创建时间：2019/10/23 17:37
 * @version：V1.0
 */
@Service
public class UserService {

    public int addUser(User user) {
        return 1;
    }

    public Object findAllUser(int pageNum, int pageSize) {
        return null;
    }
}
