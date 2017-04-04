package com.happyday.z.myweather.db;

/**
 * Created by Z on 2017/4/4.
 */

public class Province {
    //数据库主键
    private int id;
    //省份名称
    private String provincename;
    //省份编码
    private int provincecode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    public int getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(int provincecode) {
        this.provincecode = provincecode;
    }
}
