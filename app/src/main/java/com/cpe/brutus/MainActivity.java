package com.cpe.brutus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.cpe.brutus.activity.HomeActivity;
import com.cpe.brutus.model.Challenge;
import com.cpe.brutus.model.Difficulty;
import com.cpe.brutus.model.EffortType;
import com.cpe.brutus.model.SecondsDuration;
import com.cpe.brutus.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent homeActivity = new Intent(MainActivity.this, HomeActivity.class);

        //DEBUG

        List<Challenge> challenges = new ArrayList<>();
        challenges.add(new Challenge(
                new SecondsDuration(0, 30),
                3000,
                new Difficulty("Easy", 50),
                new EffortType(null)
        ));

        //END OF DEBUG

        homeActivity.putExtra("user", new User(5, 32, 2));
        homeActivity.putExtra("challenges", (Serializable) challenges);

        startActivity(homeActivity);
    }
}
