package com.springboot.userserver.controller;


import com.springboot.userserver.entity.Members;
import com.springboot.userserver.service.impl.MemberService;
import com.springboot.userserver.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 修改后的获取会员列表接口
    @GetMapping
    public Result<List<Members>> getMembers() {
        return Result.success(memberService.list());
    }

    // 新增会员
    @PostMapping
    public Result<String> createMember(@RequestBody Members member) {
        if (memberService.checkUserExists(member.getName())) {
            return Result.error("用户已存在");
        }
        memberService.save(member);
        return Result.success("创建成功");
    }

    // 更新会员
    @PutMapping("/{id}")
    public Result<String> updateMember(
            @PathVariable("id") Integer id,
            @RequestBody Members member) {
        member.setId(id);
        memberService.updateById(member);
        return Result.success("更新成功");
    }

    // 删除会员
    @DeleteMapping("/{id}")
    public Result<String> deleteMember(@PathVariable("id") Integer id) {
        memberService.removeById(id);
        return Result.success("删除成功");
    }
}