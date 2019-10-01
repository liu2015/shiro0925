package com.example.demo.Utils;

import sun.dc.pr.PRError;

import java.util.HashMap;

/**
 * @ProjectName: shiro
 * @Package: com.example.demo.Utils
 * @ClassName: AjaxResult
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/10/1 15:20
 * @Version: 1.0
 */
public class AjaxResult extends HashMap<String ,Object> {


    private static final long serialVersionUID=-1965043958765516751L;

    public static final String CODE_TAG="code";

    public static final String MSG_TAG="msg";

    public static final String DATA_TAG="data";

    public enum Type{
        SUCCESS(0),
        WARN(301),
        ERROR(500);
        private final int value;

        Type(int value)
        {
            this.value=value;
        }

        public int value(){

            return this.value;
        }
    }

    public AjaxResult(){

    }

    public AjaxResult(Type type,String  msg){
        /**
         * @Method AjaxResult 初始化一个新的创建的消息方法,对象
         * @Author ZHY
         * @Version  1.0
         * @Description
         * @param type
 * @param msg
         * @Return
         * @Exception
         * @Date 2019/10/1 20:02
         */
        super.put(CODE_TAG,type.value);
        super.put( MSG_TAG,msg );
    }

    public AjaxResult (Type type,String msg,Object data){
        super.put(CODE_TAG,type.value);
        super.put( MSG_TAG,msg );
        if (StringUtils.isNotNull( data )){
            super.put( DATA_TAG,data );
        }

    }

    public static AjaxResult success(){
        return  AjaxResult.success("操作成功");
    }

    public static AjaxResult success(Object data){

        return AjaxResult.success("操作成功",data);
    }
    public static AjaxResult success(String msg)
    {
        return AjaxResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static AjaxResult success(String msg, Object data)
    {
        return new AjaxResult(Type.SUCCESS, msg, data);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AjaxResult warn(String msg)
    {
        return AjaxResult.warn(msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static AjaxResult warn(String msg, Object data)
    {
        return new AjaxResult(Type.WARN, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static AjaxResult error()
    {
        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AjaxResult error(String msg)
    {
        return AjaxResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static AjaxResult error(String msg, Object data)
    {
        return new AjaxResult(Type.ERROR, msg, data);
    }
}





