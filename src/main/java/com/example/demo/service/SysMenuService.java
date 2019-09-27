package com.example.demo.service;

import com.example.demo.Utils.TreeUtils;
import com.example.demo.entity.SysMenu;
import com.example.demo.entity.SysUser;
import com.example.demo.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    public List<SysMenu> selectMenuall() {
        return sysMenuMapper.selectMenuall();
    }

    /**
     * 根据用户查询菜单
     *
     * @return
     */
    public List<SysMenu> selectMenunormalall1(SysUser sysUser) {
       List<SysMenu> menus=new LinkedList<SysMenu>(  );
       if (sysUser.isAdmin()){
           menus=sysMenuMapper.selectMenunormalall1();
       }
       else{
           menus=sysMenuMapper.selectMenusByUserId( sysUser.getUserId() );
       }


/**
 *  返回一个集合,权限集合 这个需要写一个
 *  权限处理类,是用递归列表,还有返回一个结果
 *
 */

        return TreeUtils.getChildPerms(menus,0);
    }




}
