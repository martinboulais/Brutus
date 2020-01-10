package com.cpe.brutus;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.cpe.brutus.services.NotificationService;
import com.cpe.brutus.services.TrackingService;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forceService(this, TrackingService.class);

        // DEMO - Send a notification at a precise time
//        Intent intent = new Intent(this, NotificationService.class);
//        intent.putExtra("titleText", "Va courir gros lard !");
//        intent.putExtra("contentText", "Ouvre ton nouveau challenge.");
//        intent.putExtra("notifTime", "2020-01-08 14:25:00");
//        startService(intent);

    }

    private void forceService(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return;
            }
        }

        Intent intent = new Intent(context, serviceClass);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.i("Start", "foreground service");
            context.startForegroundService(intent);
        } else {
            Log.i("Start", "service");
            context.startService(intent);
        }
        Log.i("Forcestart", "started");
    }

}