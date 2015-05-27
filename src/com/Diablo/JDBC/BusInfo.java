package com.Diablo.JDBC;

import java.util.Date;

/**
 * Created by 黄粟 on 2015/5/23.
 */
public class BusInfo {
    private Date 日期;
    private int 到站人数;
    private String 图;
    private String 节;
    private String 其他;

    public Date get日期() {
        return 日期;
    }

    public void set日期(Date 日期) {
        this.日期 = 日期;
    }

    public int get到站人数() {
        return 到站人数;
    }

    public void set到站人数(int 到站人数) {
        this.到站人数 = 到站人数;
    }

    public String get图() {
        return 图;
    }

    public void set图(String 图) {
        this.图 = 图;
    }

    public String get节() {
        return 节;
    }

    public void set节(String 节) {
        this.节 = 节;
    }

    public String get其他() {
        return 其他;
    }

    public void set其他(String 其他) {
        this.其他 = 其他;
    }
}
