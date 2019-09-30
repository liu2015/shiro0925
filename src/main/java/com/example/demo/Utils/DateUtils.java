package com.example.demo.Utils;

import com.sun.org.apache.bcel.internal.generic.RET;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: shiro
 * @Package: com.example.demo.Utils
 * @ClassName: DateUtils
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/9/30 19:28
 * @Version: 1.0
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static String YYYY="yyyy";
    public static String YYYY_MM="yyyy-MM";
    public static String YYYY_MM_DD="yyyy-MM-dd";
    public static String YYYYMMDDHHMMSS="yyyyMMddHHmmss";
    public static String YYYY_MM_DD_HH_MM_SS="yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns={
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"
    };

    /**
     * 获得当前时间类型
     * @return
     */
    public static Date getNowDate(){

     /**
      * @Method getNowDate
      * @Author ZHY
      * @Version  1.0
      * @Description
      * @param 
      * @Return java.util.Date
      * @Exception 
      * @Date 2019/9/30 19:51
      */
        return new Date(  );
    }


    public  static String getDate(){
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime(){

        return dateTimeNow( YYYY_MM_DD_HH_MM_SS );
    }

    public  static final String dateTimeNow(){
        return dateTimeNow( YYYYMMDDHHMMSS );
    }


    private static String dateTimeNow(final String format) {
        return parseDateToStr(format,new Date());
    }

    public static final String dateTime(final  Date date){

        return parseDateToStr( YYYY_MM_DD,date );
    }



    public static final String parseDateToStr(final String format,final Date date){

        return new SimpleDateFormat( format ).format( date );
    }

    public static final Date dateTime(final String format,final String ts){

        try{
            return new SimpleDateFormat( format ).parse( ts );
        } catch (ParseException e) {

           throw new  RuntimeException( e );

        }

    }

    public static  final String datePath(){
    /**
     * @Method datePath
     * @Author ZHY
     * @Version  1.0
     * @Description
     * @param
     * @Return java.lang.String
     * @Exception
     * @Date 2019/9/30 20:10
     */
        Date now =new Date(  );
        return DateFormatUtils.format( now,"yyyy/MM/dd"  );

    }

    public static final String dateTime(){
        Date now=new Date(  );
        return DateFormatUtils.format(now,"yyyyMMdd"  );
    }

    public static Date parseDate(Object str){
        if (str==null)
        {
            return null;
        }
        try {
            return parseDate( str.toString(),parsePatterns );
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }

//        return null;
    }
    /**
     * @Method 获取服务器启动时间
     * @Author ZHY
     * @Version  1.0
     * @Description
     * @param
     * @Return java.util.Date
     * @Exception
     * @Date 2019/9/30 20:17
     */
    public static Date getServerStartDate(){

        long time=ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date( time );
    }


    public static String getDatePoor(Date endDate,Date nowDate){
        long nd=1000*24*60*60;
        long nh=1000*60*60;
        long nm=1000*60;
        //获得两个时间的毫秒时间差

        long diff=endDate.getTime()-nowDate.getTime();
//        计算差多少天
        long day=diff/nd;
//        计算差多少小时
        long hour=diff%nd/nh;
//        计算差多少秒
        long min=diff%nd%nh/nm;
//        计算差多少秒/输出结果
        // 计算差多少秒

        return day+"天"+hour+"小时"+min+"分钟";
    }


}
