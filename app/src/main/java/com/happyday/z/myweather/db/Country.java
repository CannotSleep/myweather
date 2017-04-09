package com.happyday.z.myweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Z on 2017/4/4.
 */

public class Country extends DataSupport {
    private int id;
    private String countryname;
    private int cityId;
    private String weather_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int countrycode) {
        this.cityId = countrycode;
    }

    public String getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(String weather_id) {
        this.weather_id = weather_id;
    }
}
