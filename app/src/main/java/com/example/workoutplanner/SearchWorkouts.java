package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class SearchWorkouts extends AppCompatActivity {

    SearchView mySearchView;
    ListView searchList;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_workouts);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WorkoutsApi jsonPlaceHolderApi = retrofit.create(WorkoutsApi.class);

//        Call<ApiResponse> call = WorkoutsApi.getWorkouts();

        mySearchView = (SearchView)findViewById(R.id.searchView);
        searchList = (ListView)findViewById(R.id.searchList);

        list=new ArrayList<String>();

        list.add("Monday");
        list.add("Tuesday");

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, list);
        searchList.setAdapter(adapter);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

    }
}