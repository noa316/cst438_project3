package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AdminViewUsers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_users);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WorkoutsApi jsonPlaceHolderApi = retrofit.create(WorkoutsApi.class);

//        Call<ApiResponse> call = WorkoutsApi.getWorkouts();
    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, AdminViewUsers.class);
        return intent;
    }
}