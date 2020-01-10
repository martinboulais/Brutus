package com.cpe.brutus.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.cpe.brutus.services.TrackingService;


public class OnBootReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent arg1) {

        Intent intent = new Intent(context, TrackingService.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.i("Start", "foreground service");
            context.startForegroundService(intent);
        } else {
            Log.i("Start", "service");
            context.startService(intent);
        }
        Log.i("Autostart", "started");
    }
}