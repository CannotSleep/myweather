package com.happyday.z.myweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Z on 2017/4/10.
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }

}
