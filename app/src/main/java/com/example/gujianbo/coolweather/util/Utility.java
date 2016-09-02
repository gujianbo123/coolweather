package com.example.gujianbo.coolweather.util;

import android.text.TextUtils;

import com.example.gujianbo.coolweather.db.CoolWeatherDB;
import com.example.gujianbo.coolweather.model.City;
import com.example.gujianbo.coolweather.model.County;
import com.example.gujianbo.coolweather.model.Province;

/**
 * Created by gujianbo on 16/8/29.
 */
public class Utility {
    public static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            for (String p :
                    allProvinces) {
                String[] array = p.split("\\|");
                Province province = new Province();
                province.setProvinceCode(array[0]);
                province.setProvinceName(array[1]);
                coolWeatherDB.saveProvince(province);
                return true;


            }

        }

        return false;
    }

    public static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB, String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            for (String c : allCities) {
                String[] array = c.split("\\|");
                City city = new City();
                city.setCityCode(array[0]);
                city.setCityName(array[1]);
                city.setProvinceId(provinceId); // 将解析出来的数据存储到City表
                coolWeatherDB.saveCity(city);
            }
            return true;

        }

        return false;
    }

    public static boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB, String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            for (String c : allCounties) {
                String[] array = c.split("\\|");
                County county = new County();
                county.setCountyCode(array[0]);
                county.setCountyName(array[1]);
                county.setCityId(cityId);
                // 将解析出来的数据存储到County表
                coolWeatherDB.saveCounty(county);
            }
            return true;

        }
        return false;
    }


}
