package com.example.demo.Utils;



/**
 * @ProjectName: shiro
 * @Package: com.example.demo.Utils
 * @ClassName: PageDomain
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/9/30 20:36
 * @Version: 1.0
 */
public class PageDomain {
    private Integer pageNum;
    private Integer pageSize;
    private String orderByColumn;
    private String isAse;

    public String getOrderBy(){

        if (StringUtils.isEmpty( orderByColumn ))
        {
            return "";
        }
        return StringUtils.toUnderScoreCase( orderByColumn )+" "+isAse;

    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum=pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
    }

    public String getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn=orderByColumn;
    }

    public String getIsAse() {
        return isAse;
    }

    public void setIsAse(String isAse) {
        this.isAse=isAse;
    }
}
