package com.mvc.utils;

import java.util.List;

/*
* 数据库分页工具类
* */
public class PageModel <T> {

    private int pageNum;//当前页
    private int pageSize;//每页条数
    private int total;//总条数
    private int maxPageNum;//总页数
    private List<T> data;//当前页数据集

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getMaxPageNum() {
        //计算总页数
        if(total % pageSize == 0){
            return total/pageSize;
        }
        else {
            return (total/pageSize)+1;
        }
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
