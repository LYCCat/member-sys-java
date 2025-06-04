// UserServiceImpl.java（实现类）
package com.springboot.userserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.userserver.entity.User;
import com.springboot.userserver.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean checkUserExists(String username) {
        return baseMapper.selectCount(
                new QueryWrapper<User>().eq("user_name", username)
        ) > 0;
    }
}