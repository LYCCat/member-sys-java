package com.springboot.userserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.userserver.entity.Account;
import com.springboot.userserver.entity.Members;
import com.springboot.userserver.mapper.AccountMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>  implements AccountService{


    @Override
    public Account checkUserExists(String phone) {
        return this.baseMapper.selectOne(
                new QueryWrapper<Account>().eq("phone", phone)
        );
    }
}
