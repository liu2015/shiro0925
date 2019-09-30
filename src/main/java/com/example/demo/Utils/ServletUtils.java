package com.example.demo.Utils;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: shiro
 * @Package: com.example.demo.Utils
 * @ClassName: ServletUtils
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/9/30 22:01
 * @Version: 1.0
 */
public class ServletUtils {

    public static String getParameter(String name){


        return getRequest().getParameter( name );
    }


    public static HttpServletRequest getRequest(){

        return getRequestAttributes().getRequest();
    }

    public static Integer getParameterToInt(String name){

        return Convert.toInt( getRequest().getParameter( name ) );
    }

    private static ServletRequestAttributes getRequestAttributes() {

        RequestAttributes attributes=RequestContextHolder.getRequestAttributes();
    return (ServletRequestAttributes) attributes;
    }




}
