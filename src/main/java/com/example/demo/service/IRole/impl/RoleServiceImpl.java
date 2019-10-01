package com.example.demo.service.IRole.impl;

import com.example.demo.entity.SysRole;
import com.example.demo.mapper.SysRoleMapper;
import com.example.demo.service.IRole.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ProjectName: shiro
 * @Package: com.example.demo.service.IRole.impl
 * @ClassName: RoleServiceImpl
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/10/1 22:06
 * @Version: 1.0
 */
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Override
    public List<SysRole> selectRoleList(SysRole role) {


        return sysRoleMapper.selectRoleList( role );
    }

    @Override
    public List<SysRole> selectRoleAll() {
        return this.selectRoleList( new SysRole() );
    }
}
