package com.springboot.userserver.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.userserver.entity.Account;

public interface AccountService extends IService<Account> {

  Account checkUserExists(String phone);
}
