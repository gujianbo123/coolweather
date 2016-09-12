package com.example.gujianbo.coolweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.gujianbo.coolweather.service.AutoUpdateService;

/**
 * Created by gujianbo on 16/9/12.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, AutoUpdateService.class);
        context.startService(i);

    }
}
