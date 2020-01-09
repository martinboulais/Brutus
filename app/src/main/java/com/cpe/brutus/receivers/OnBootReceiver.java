package com.cpe.brutus.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.cpe.brutus.services.NotificationService;
import com.cpe.brutus.services.TestService;


public class OnBootReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent arg1) {

        Toast.makeText(context, "Booted !!!", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(context, TestService.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
        Log.i("Autostart", "started");
    }
}