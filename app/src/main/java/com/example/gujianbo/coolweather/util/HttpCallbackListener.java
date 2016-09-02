package com.example.gujianbo.coolweather.util;

/**
 * Created by gujianbo on 16/8/29.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
