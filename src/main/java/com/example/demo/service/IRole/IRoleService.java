package com.example.demo.service.IRole;

import com.example.demo.entity.SysRole;

import java.util.List;

/**
 * @ProjectName: shiro
 * @Package: com.example.demo.service.IRole
 * @ClassName: IRoleService
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/10/1 20:19
 * @Version: 1.0
 */
public interface IRoleService {

    public List<SysRole> selectRoleList(SysRole role);

    public List<SysRole> selectRoleAll();




}
