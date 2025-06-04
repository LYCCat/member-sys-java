package com.springboot.userserver.controller;

import com.springboot.userserver.entity.User;

import com.springboot.userserver.service.impl.UserService;
import com.springboot.userserver.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService; // 改为接口类型，不要直接引用实现类

    // 获取用户列表（明确泛型类型）
    @GetMapping
    public Result<List<User>> getUserList() {
        return Result.success(userService.list()); // 自动推导泛型
    }

    // 添加用户（返回Void类型Result）
    @PostMapping
    public Result<Void> addUser(@RequestBody User user) {
        return userService.save(user) ?
                Result.success(null) : // 必须显式传递null或调整Result类
                Result.error("添加失败");
    }

    // 修改用户（返回Void类型Result）
    @PutMapping
    public Result<Void> updateUser(@RequestBody User user) {
        return userService.updateById(user) ?
                Result.success(null) :
                Result.error("更新失败");
    }

    // 删除用户（明确路径变量类型）
    @DeleteMapping("/{id}")
    public Result<Void> deleteUser(@PathVariable("id") Integer id) {
        return userService.removeById(id) ?
                Result.success(null) :
                Result.error("删除失败");
    }
}