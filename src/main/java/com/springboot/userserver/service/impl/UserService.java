// UserService.java（接口扩展）
package com.springboot.userserver.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.userserver.entity.User;

public interface UserService extends IService<User> {
    // 自定义业务方法示例
    boolean checkUserExists(String username);
}