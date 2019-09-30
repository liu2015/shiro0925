package com.example.demo.web;

import com.example.demo.Utils.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

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

    /**
     * @Method getDataTable
     * @Author ZHY
     * @Version  1.0
     * @Description
     * @param list
     * @Return com.example.demo.Utils.TableDataInfo
     * @Exception
     * @Date 2019/9/30 22:55
     */
protected TableDataInfo getDataTable(List<?> list){

    /**
     * @Method getDataTable
     * @Author ZHY
     * @Version  1.0
     * @Description
     * @param list
     * @Return com.example.demo.Utils.TableDataInfo
     * @Exception
     * @Date 2019/9/30 22:55
     */
    TableDataInfo rspData =new TableDataInfo(  );
    rspData.setCode( 0 );
    rspData.setRows( list );
    rspData.setTotal( new PageInfo(list  ).getTotal() );


    return rspData;
}





}
