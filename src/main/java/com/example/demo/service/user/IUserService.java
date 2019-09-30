package com.example.demo.service.user;

import com.example.demo.entity.SysUser;
import sun.rmi.runtime.Log;

import java.util.List;

public interface IUserService {


    /**
     * 条件分页查询用户列表
     * 用户信息集合
     */

    public List<SysUser> selectUserList(SysUser user);
    /**
     * 分页查询分配角色列表
     * 用户信息集合
     */


    public List<SysUser> selectAllocatedList(SysUser user);
    /**
     * 未分配角色查询
    * */
    public List<SysUser> selectUnallocatedList(SysUser user);

    /**
     * 通过用户查询用户
     *
     */
    public  SysUser selectUserByLoginName(String userName);

    /**
     * 通过手机号码查询用户
     */
    public  SysUser selectUserByPhoneNumber(String phoneNumber);

    /**
     * 通过邮箱查询用户
     */

    public SysUser selectUserByEmail (String email);

    /**
     * 通过用户ID查询用户
     */
    public SysUser selectUserById (Long userid);

    /**
     * 通过用户id删除用户
     */

    public int deleteUserById(Long userId);

    /**
     * 批量删除用户
     */
    public int deleteUserByIds (String ids) throws Exception;

    /**
     * 保存用户信息
     *
     */

    public int isertUser(SysUser user);

    /**
     * 保存用户信息
     *  更新
     */

    public int updateUser(SysUser user);

    /**
     * 修改用户详情信息
     */
    public int updateUserInfo(SysUser user);

    /**
     * 修改用户密码信息
     */

    public int resetUserPwd(SysUser user);
/**
 * 效验用户名称是不是唯一
 */

    public String checkLoginNmaeUnique(String loginName);

    /**
     * 校检手机号是否唯一
     */

    public String checkPhoneUnique(SysUser user);

    /**
     * 校检email 是否唯一
     */
    public String checkEmailUnique(SysUser user);

    /**
     * 根据用户id查询 用户所属角色组
     */
    public String selectUserRoleGroup(Long userId);

    /**
     * 根据用户id查询用户所属组岗位组
     */
    public  String selectUserPostGroup(Long userId);

    /**
     * 导入用户数据
     */
    public  String importUser(List<SysUser> userList ,Boolean isUpdateSupport);


    /**
     * 修改用户状态
     */
    public int changeStatus(SysUser user);


}
