package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.List;

public class AdminLandingPage extends AppCompatActivity {

    private Button viewUsersBtn;
    private Button viewWorkoutsBtn;
    private Button logOutBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_landing_page);

        viewUsersBtn = findViewById(R.id.ViewUsersBtn);
        viewWorkoutsBtn = findViewById(R.id.ViewWorkoutsBtn);
        logOutBtn = findViewById(R.id.adminLogoutBtn);

        viewUsersBtn.setOnClickListener(view -> {
            startActivity(AdminViewUsers.intentFactory(getApplicationContext()));
        });

        viewWorkoutsBtn.setOnClickListener(view -> {

        });

        logOutBtn.setOnClickListener(view -> {
            startActivity(LogIn.intentFactory(getApplicationContext()));
        });
    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, AdminLandingPage.class);
        return intent;
    }
}

