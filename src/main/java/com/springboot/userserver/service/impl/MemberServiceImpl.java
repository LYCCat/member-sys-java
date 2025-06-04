package com.springboot.userserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.userserver.entity.Members;
import com.springboot.userserver.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Members> implements MemberService {

    @Override
    public boolean checkUserExists(String username) {
        return this.baseMapper.selectCount(
                new QueryWrapper<Members>().eq("name", username)
        ) > 0;
    }
}