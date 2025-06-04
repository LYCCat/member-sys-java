package com.springboot.userserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.userserver.entity.Account;

public interface AccountMapper extends BaseMapper<Account>{
    // 这里可以添加自定义查询方法
    // 例如：List<Account> findAccountsByUserId(Long userId);
}
