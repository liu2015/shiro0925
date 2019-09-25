package com.example.demo.controller;

import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class SysUsercontroller {

    @Autowired
    SysUserService sysUserService;
    @RequestMapping("one")
    public String getOne(){
        return "one";
    }
    @RequestMapping("two")
    public String getTwo(){
        return "two";
    }
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("permission")
    public String permission(){
        return "permission";
    }


    @RequestMapping("toLogin")
    public String findUser(SysUser sysUser, Model model) {

        System.out.println( sysUser.getLoginName()+"  "+sysUser.getPassword() );

        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken usertoken=new UsernamePasswordToken( sysUser.getLoginName(),sysUser.getPassword() );

        try {
            subject.login( usertoken );
            System.out.println( "成功" );
            model.addAttribute( "msg","你登录成功" );
            return "redirect:two";


        }catch (UnknownAccountException e) {
            //用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            //密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
}
