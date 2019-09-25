package com.example.demo.shiro;

import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println( "授权" );
        Subject subject=SecurityUtils.getSubject();
        SysUser user=(SysUser) subject.getPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo(  );
        simpleAuthorizationInfo.addStringPermission( user.getRemark() );
        return simpleAuthorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
      System.out.println( "认证" );

        UsernamePasswordToken user=(UsernamePasswordToken) authenticationToken;
        SysUser sysUser=new SysUser();
        sysUser.setLoginName( user.getUsername() );
        sysUser.setPassword( String.copyValueOf( user.getPassword() ) );

        SysUser newUser=sysUserService.findUser( sysUser );

        if (newUser==null)
        {
            return null;
        }

        return new SimpleAuthenticationInfo(newUser,newUser.getPassword(),"");
    }
}
