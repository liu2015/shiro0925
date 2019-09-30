package com.example.demo.framework.aspectj.lang.annotation;


import java.lang.annotation.*;

@Target( ElementType.METHOD )
@Retention( RetentionPolicy.RUNTIME )
@Documented
public @interface  DataScope {
    /**
     * 门店表的区别
     */
    public  String deptAlas() default "";

    public String userAlias() default "";


}
