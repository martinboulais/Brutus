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
        Intent intent = new Intent(this, NotificationService.class);
        intent.putExtra("titleText", "Va courir gros lard !");
        intent.putExtra("contentText", "Ouvre ton nouveau challenge.");
        startService(intent);

    }
}