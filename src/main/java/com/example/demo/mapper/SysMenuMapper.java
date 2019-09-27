package com.example.demo.mapper;

import com.example.demo.entity.SysMenu;
import com.example.demo.entity.SysUser;
import mybatis.MyMapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface SysMenuMapper extends MyMapper<SysMenu> {

    public List<SysMenu> selectMenuall();

    public List<SysMenu> selectMenunormalall1();

    public List<SysMenu> selectMenusByUserId(Long userid);

}