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
        System.out.println("shuchu要复制的内容"+ obj.toString() );

        user =new SysUser();
        /**
         * 这里beanutils.copyProperties(a,b)是a复制给b
         * a 是源头，b是被复制放。
         * */
        BeanUtils.copyProperties(obj,user);
        System.out.println("看看复制进入没有"+ user.toString() );
        SysUser user1=user;

//        SysUser user= (SysUser) SecurityUtils.getPrincipal();
        System.out.println("  user+++111   "+user1.toString());
        map.addAttribute("msg2","你已经登录成功");
        map.addAttribute("msg1","现在是主界面");


        return "index";

    }

}
