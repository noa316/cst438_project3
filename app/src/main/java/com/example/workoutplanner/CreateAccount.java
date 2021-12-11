package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateAccount extends AppCompatActivity {

    private EditText usernameEt;
    private EditText passwordEt;
    private EditText confPasswordEt;
    private Button createAccBtn;
    private Button logInbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);


        usernameEt = findViewById(R.id.createUsernameET);
        passwordEt = findViewById(R.id.createPasswordET);
        confPasswordEt =findViewById(R.id.createAccVerifyPasswordET);
        createAccBtn = findViewById(R.id.createAccountBtn);
        logInbtn = findViewById(R.id.backToLogIn);

        createAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usernameEt.getText().toString().isEmpty() && passwordEt.toString().isEmpty()) {
                    Toast.makeText(CreateAccount.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to post the data and passing our name and job.
                postData(usernameEt.getText().toString(), passwordEt.getText().toString());

            }
        });

        logInbtn.setOnClickListener(v -> {
            startActivity(LogIn.intentFactory(getApplicationContext()));
        });


    }

    private void postData(String username, String password) {

        // on below line we are creating a retrofit
        // builder and passing our base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://heroku.app/users/")
                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        UsersAPI retrofitAPI = retrofit.create(UsersAPI.class);

        // passing data from our text fields to our modal class.
        User modal = new User(username, password);

        // calling a method to create a post and passing our modal class.
        Call<User> call = retrofitAPI.createPost(modal);

        // on below line we are executing our method.
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // this method is called when we get response from our api.
                Toast.makeText(CreateAccount.this, "Data added to API", Toast.LENGTH_SHORT).show();

                // on below line we are setting empty text
                // to our both edit text.
                usernameEt.setText("");
                passwordEt.setText("");

                // we are getting response from our body
                // and passing it to our modal class.
                User responseFromAPI = response.body();

                // on below line we are getting our data from modal class and adding it to our string.
//                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName() + "\n" + "Job : " + responseFromAPI.getJob();

                // below line we are setting our
//                // string to our text view.
//                responseTV.setText(responseString);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(CreateAccount.this, "Error:Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, CreateAccount.class);
        return intent;
    }
}
