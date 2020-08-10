package com.angle.domain;

import java.util.Calendar;
import java.util.Date;

public class Info {
    private Integer id;

    private Integer cid;

    private Date nowtime;
    private String nowtimestr;

    private Date clocktime;
    private String clocktimestr;

    private Date forenoonon;
    private String forenoononstr;

    private Date forenoondoen;
    private String forenoondoenstr;

    private Date afternoonon;
    private String afternoononstr;

    private Date afternoondown;
    private String afternoondownstr;

    private Date nighton;
    private String nightonstr;

    private Date nightdown;
    private String nightdownstr;

    public Date getNowtime() {
        return nowtime;
    }

    public Date getClocktime() {
        return clocktime;
    }

    public Date getForenoonon() {
        return forenoonon;
    }

    public Date getForenoondoen() {
        return forenoondoen;
    }

    public Date getAfternoonon() {
        return afternoonon;
    }

    public Date getAfternoondown() {
        return afternoondown;
    }

    public Date getNighton() {
        return nighton;
    }

    public Date getNightdown() {
        return nightdown;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getNowtimestr() {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (this.nowtime == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.nowtime);
        String str = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        return str;
    }

    public void setNowtime(Date nowtime) {
        this.nowtime = nowtime;
    }

    public String getClocktimestr() {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (this.clocktime == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.clocktime);
        String str = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        return str;
    }

    public void setClocktime(Date clocktime) {
        this.clocktime = clocktime;
    }

    public String getForenoononstr() {


        if (this.forenoonon == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.forenoonon);
        String str = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        return str;
    }

    public void setForenoonon(Date forenoonon) {
        this.forenoonon = forenoonon;
    }

    public String getForenoondoenstr() {


        if (this.forenoondoen == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.forenoondoen);
        String str = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        return str;
    }

    public void setForenoondoen(Date forenoondoen) {
        this.forenoondoen = forenoondoen;
    }

    public String getAfternoononstr() {

        if (this.afternoonon == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.afternoonon);
        String str = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        return str;
    }

    public void setAfternoonon(Date afternoonon) {
        this.afternoonon = afternoonon;
    }

    public String getAfternoondownstr() {
        if (this.afternoondown == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.afternoondown);
        String str = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        return str;
    }

    public void setAfternoondown(Date afternoondown) {
        this.afternoondown = afternoondown;
    }

    public String getNightonstr() {

        if (this.nighton == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.nighton);
        String str = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        return str;
    }

    public void setNighton(Date nighton) {
        this.nighton = nighton;
    }

    public String getNightdownstr() {

        if (this.nightdown == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.nightdown);
        String str = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        return str;
    }

    public void setNightdown(Date nightdown) {
        this.nightdown = nightdown;
    }
}