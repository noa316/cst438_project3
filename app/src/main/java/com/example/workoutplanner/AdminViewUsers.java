package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AdminViewUsers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_users);
    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, AdminViewUsers.class);
        return intent;
    }
}