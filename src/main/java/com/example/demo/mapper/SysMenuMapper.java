package com.example.demo.mapper;

import com.example.demo.entity.SysMenu;
import com.example.demo.entity.SysUser;
import mybatis.MyMapper;
import sun.rmi.runtime.Log;

import java.util.List;

public interface SysMenuMapper extends MyMapper<SysMenu> {

    public List<SysMenu> selectMenuall();

    public List<SysMenu> selectMenunormalall1();

    public List<SysMenu> selectMenusByUserId(Long userid);

}