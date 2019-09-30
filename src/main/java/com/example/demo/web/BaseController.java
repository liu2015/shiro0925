package com.example.demo.web;

import com.example.demo.Utils.DateUtils;
import com.example.demo.Utils.PageDomain;
import com.example.demo.Utils.SqlUtil;
import com.example.demo.Utils.StringUtils;
import com.github.pagehelper.PageHelper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * 通用的数据处理
 */

public class BaseController {

    /**
     * 前台数据传递过来的时期格式字符串,自动转换为date类型
     */
@InitBinder
    public  void initBinder(WebDataBinder binder){

    binder.registerCustomEditor( Date.class, new PropertyEditorSupport(){

        public void setAsText(String text){
            setValue( DateUtils.parseDate( text ) );
        }
    } );
}

/**
 * @Method  设置请求分页数据
 * @Author ZHY
 * @Version  1.0
 * @Description
 * @param
 * @Return
 * @Exception
 * @Date 2019/9/30 20:35
 * 设置分页数据
 */
protected  void startPage(){
     PageDomain pageDomain=TableSupport.buildPageRequest();
     Integer pageNum=pageDomain.getPageNum();
     Integer pageSize=pageDomain.getPageSize();
     if (StringUtils.isNotNull( pageNum )&& StringUtils.isNotNull( pageSize ))
     {
         String orderBy=SqlUtil.escapeOrderBySql( pageDomain.getOrderBy() );
         PageHelper.startPage( pageNum,pageSize,orderBy );

     }
}





}
