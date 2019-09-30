package com.example.demo.service;

import com.example.demo.entity.SysUser;
import com.example.demo.mapper.SysUserMapper;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService implements IUserService {

    @Autowired
    SysUserMapper sysUserMapper;


    public SysUser findUser(SysUser sysUser) {
        return sysUserMapper.findUser( sysUser );
    }


    @Override
    public List<SysUser> selectUserList(SysUser user) {
        return null;
    }

    @Override
    public List<SysUser> selectAllocatedList(SysUser user) {
        return null;
    }

    @Override
    public List<SysUser> selectUnallocatedList(SysUser user) {
        return null;
    }

    @Override
    public SysUser selectUserByLoginName(String userName) {
        return null;
    }

    @Override
    public SysUser selectUserByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public SysUser selectUserByEmail(String email) {
        return null;
    }

    @Override
    public SysUser selectUserById(Long userid) {
        return null;
    }

    @Override
    public int deleteUserById(Long userId) {
        return 0;
    }

    @Override
    public int deleteUserByIds(String ids) throws Exception {
        return 0;
    }

    @Override
    public int isertUser(SysUser user) {
        return 0;
    }

    @Override
    public int updateUser(SysUser user) {
        return 0;
    }

    @Override
    public int updateUserInfo(SysUser user) {
        return 0;
    }

    @Override
    public int resetUserPwd(SysUser user) {
        return 0;
    }

    @Override
    public String checkLoginNmaeUnique(String loginName) {
        return null;
    }

    @Override
    public String checkPhoneUnique(SysUser user) {
        return null;
    }

    @Override
    public String checkEmailUnique(SysUser user) {
        return null;
    }

    @Override
    public String selectUserRoleGroup(Long userId) {
        return null;
    }

    @Override
    public String selectUserPostGroup(Long userId) {
        return null;
    }

    @Override
    public String importUser(List<SysUser> userList, Boolean isUpdateSupport) {
        return null;
    }

    @Override
    public int changeStatus(SysUser user) {
        return 0;
    }
}
