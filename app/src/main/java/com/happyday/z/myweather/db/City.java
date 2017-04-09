package com.happyday.z.myweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Z on 2017/4/4.
 */

public class City extends DataSupport{
    private int id;

    private int citycode;

    private String cityname;

    private int privinceId;

    public int getPrivinceId() {
        return privinceId;
    }

    public void setPrivinceId(int privinceId) {
        this.privinceId = privinceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCitycode() {
        return citycode;
    }

    public void setCitycode(int citycode) {
        this.citycode = citycode;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
}
