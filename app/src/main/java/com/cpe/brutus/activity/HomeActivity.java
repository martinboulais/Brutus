package com.cpe.brutus.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.cpe.brutus.R;
import com.cpe.brutus.model.Challenge;
import com.cpe.brutus.model.ChallengeView;
import com.cpe.brutus.model.User;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        User user = (User) getIntent().getSerializableExtra("user");
        List<Challenge> challengeList = (List<Challenge>) getIntent().getSerializableExtra("challengeList");

        setContentView(R.layout.activity_home);
    }
}
