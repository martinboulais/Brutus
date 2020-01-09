package com.cpe.brutus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.cpe.brutus.services.NotificationService;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DEMO - Send a notification at a precise time
//        Intent intent = new Intent(this, NotificationService.class);
//        intent.putExtra("titleText", "Va courir gros lard !");
//        intent.putExtra("contentText", "Ouvre ton nouveau challenge.");
//        intent.putExtra("notifTime", "2020-01-08 14:25:00");
//        startService(intent);

    }
}