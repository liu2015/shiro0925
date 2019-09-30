package com.example.demo.Utils;

import java.io.Serializable;
import java.util.List;

/**
 * 表格分页数据对象
 */

public class TableDataInfo implements Serializable {

    private static final long serialVersionUID=-5978457978924211050L;

    private long total;

    private List<?> rows;

    private int code;

    private int msg;

    public TableDataInfo(){

    }

    /**
     * 分页
     */
    public  TableDataInfo(List<?> list,int total){

        this.rows=list;
        this.total=total;

    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total=total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows=rows;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code=code;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg=msg;
    }
}
