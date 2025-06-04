package com.springboot.userserver.controller;


import com.springboot.userserver.entity.Account;
import com.springboot.userserver.entity.Members;
import com.springboot.userserver.service.impl.AccountService;

import com.springboot.userserver.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 会员充值
 */
@RestController
@RequestMapping("/api/account")
public class MemberAccountController {
@Autowired
    private AccountService accountService;

    @PostMapping
    public Result account(@RequestBody Map map) {
        String phone= (String) map.get("phone");
        String account = (String) map.get("account");
        Account account2= accountService.checkUserExists(phone);
        Account account1 = new Account();
        account1.setAccount(account);
        account1.setPhone(phone);
        accountService.save(account1);
        if(account2!=null) {
            account1.setId(account2.getId());
            account1.setAccount(account2.getAccount() + account);
            accountService.updateById(account1);
        }
        return Result.success();
    }

}