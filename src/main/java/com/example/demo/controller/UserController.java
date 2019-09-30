package com.example.demo.controller;

import com.example.demo.Utils.TableDataInfo;
import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.github.pagehelper.page.PageMethod.startPage;

@Controller
@RequestMapping("/system/user")
public class UserController {

    private  String prefix="system/user";

    @Autowired
    private SysUserService sysUserService;

@GetMapping()
    public String user(){

        return prefix+"user";

    }

    @ResponseBody
    @PostMapping("/list")
    public TableDataInfo list(SysUser user)
    {
        startPage();

        return

    }







}
