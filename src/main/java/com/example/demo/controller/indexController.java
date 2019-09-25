package com.example.demo.controller;

import com.example.demo.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.apache.shiro.SecurityUtils.getSubject;


@Controller
public class indexController {



    @RequestMapping("/index")
    public String index(ModelMap map){

        SysUser user=null;

        Object obj = getSubject().getPrincipal();

        user =new SysUser();
        BeanUtils.copyProperties(user,obj);
        SysUser user1=user;

//        SysUser user= (SysUser) SecurityUtils.getPrincipal();
        System.out.println("user"+user.getLoginName());
        map.addAttribute("msg2","你已经登录成功");
        map.addAttribute("msg1","现在是主界面");


        return "index";

    }

}
