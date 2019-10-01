package com.example.demo.controller;

import com.example.demo.Utils.TableDataInfo;
import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import com.example.demo.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {

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
        List<SysUser> list=sysUserService.selectUserList( user );
        return getDataTable(list);

    }

//    @PostMapping("export")
//     @ResponseBody
//    public AjaxResult export( SysUser user){
//
//    List<SysUser> list=sysUserService.selectUserList( user );
//
//    return  ;
//
//
//    }


    @GetMapping("/add")
    public  String add(ModelMap mmap){

    mmap.put( "roles",roleservice.selectRoleAll() );

    return prefix+"/add";
    }








}
