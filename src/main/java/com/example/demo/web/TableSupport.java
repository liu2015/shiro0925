package com.example.demo.web;

import com.example.demo.Utils.Constants;
import com.example.demo.Utils.PageDomain;
import com.example.demo.Utils.ServletUtils;
import sun.security.krb5.internal.PAData;


/**
 * @ProjectName: shiro
 * @Package: com.example.demo.web
 * @ClassName: TableSupport
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/9/30 21:02
 * @Version: 1.0
 */
public   class TableSupport {

    public static PageDomain getPageDomain(){
/**
 * @Method 封装分页对象
 * @Author ZHY
 * @Version  1.0
 * @Description
 * @param
 * @Return com.example.demo.Utils.PageDomain
 * @Exception
 * @Date 2019/9/30 22:27
 */
        PageDomain pageDomain=new PageDomain();
        pageDomain.setPageNum( ServletUtils.getParameterToInt( Constants.PAGE_NUM ) );
        pageDomain.setPageSize( ServletUtils.getParameterToInt( Constants.PAGE_SIZE ) );
        pageDomain.setOrderByColumn( ServletUtils.getParameter( Constants.ORDER_BY_COLUMN ) );
        pageDomain.setIsAse( ServletUtils.getParameter( Constants.IS_ASC ) );


        return pageDomain;
    }


    public static PageDomain buildPageRequest(){

        return getPageDomain();
    }

}
