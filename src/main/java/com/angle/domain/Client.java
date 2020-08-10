package com.angle.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Client {
    private Integer id;

    private String username;

    private String password;

    private Date createtime;

    private String createtimestr;

    private long status;

    private List<Info> list;

    private List<Info> listResult;

    private int totalNum;//信息总数

    private int pageNum;//当前页数

    public List<Info> getListResult() {
        return listResult;
    }

    public void setListResult(List<Info> listResult) {
        this.listResult = listResult;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }


    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getCreatetimestr() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(this.createtime);
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public List<Info> getList() {
        return list;
    }

    public void setList(List<Info> list) {
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}