package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LandingPage extends AppCompatActivity {

    private Button myWorkoutsBtn;
    private Button searchWorkoutsBtn;
    private Button profileBtn;
    private Button logOutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        myWorkoutsBtn = findViewById(R.id.button3);
        searchWorkoutsBtn = findViewById(R.id.button4);
        profileBtn = findViewById(R.id.button5);
        logOutBtn = findViewById(R.id.button6);

        myWorkoutsBtn.setOnClickListener(view -> {
            startActivity(SavedWorkouts.intentFactory(getApplicationContext()));
        });

        searchWorkoutsBtn.setOnClickListener(view -> {
            startActivity(SelectWorkouts.intentFactory(getApplicationContext()));
        });

        searchWorkoutsBtn.setOnClickListener(view -> {
            startActivity(ViewProfile.intentFactory(getApplicationContext()));
        });

        logOutBtn.setOnClickListener(view -> {
            startActivity(LogIn.intentFactory(getApplicationContext()));
        });
    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, LandingPage.class);
        return intent;
    }
}