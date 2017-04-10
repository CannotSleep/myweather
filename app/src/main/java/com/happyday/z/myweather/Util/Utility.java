package com.happyday.z.myweather.Util;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.happyday.z.myweather.db.City;
import com.happyday.z.myweather.db.Country;
import com.happyday.z.myweather.db.Province;
import com.happyday.z.myweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Z on 2017/4/4.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces =new JSONArray(response);
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province =new Province();
                    province.setProvincename(provinceObject.getString("name"));
                    province.setProvincecode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities =new JSONArray(response);
                for(int i=0;i<allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city =new City();
                    city.setCityname(cityObject.getString("name"));
                    city.setCitycode(cityObject.getInt("id"));
                    city.setPrivinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 解析服务器返回的县级数据
     */
    public static boolean handleCountryResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties =new JSONArray(response);
                for(int i=0;i<allCounties.length();i++){
                    JSONObject cityObject = allCounties.getJSONObject(i);
                    Country country =new Country();
                    country.setCountryname(cityObject.getString("name"));
                    country.setWeather_id(cityObject.getString("weather_id"));
                    country.setCityId(cityId);
                    country.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 将返回的Json数据解析成Weather实体类
     */
    public static Weather handleWeatherResponse(String response){
        Log.i("ccc",response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent= jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
