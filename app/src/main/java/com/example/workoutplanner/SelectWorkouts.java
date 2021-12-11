package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SelectWorkouts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_workouts);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WorkoutsApi jsonPlaceHolderApi = retrofit.create(WorkoutsApi.class);

//        Call<ApiResponse> call = WorkoutsApi.getWorkouts();
    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, SelectWorkouts.class);
        return intent;
    }
}
