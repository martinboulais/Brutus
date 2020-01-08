package com.cpe.brutus;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecognition();


    }

    public void initRecognition(){
        Activity_recognition act= new Activity_recognition();

        act.startTracking(this);

    }


}
