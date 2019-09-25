package com.example.demo.mapper;

import com.example.demo.entity.SysUser;
import mybatis.MyMapper;

public interface SysUserMapper extends MyMapper<SysUser> {

    SysUser findUser(SysUser sysUser);

}