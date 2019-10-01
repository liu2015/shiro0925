package com.example.demo.mapper;

import com.example.demo.entity.SysRole;
import mybatis.MyMapper;

import java.util.List;

public interface SysRoleMapper extends MyMapper<SysRole> {

    public List<SysRole> selectRoleList(SysRole role);




}