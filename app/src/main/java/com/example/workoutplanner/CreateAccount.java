package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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


        usernameEt = findViewById(R.id.logInUsernameET);
        passwordEt = findViewById(R.id.createAccPasswordET);
        confPasswordEt =findViewById(R.id.createAccVerifyPasswordET);
        createAccBtn = findViewById(R.id.createAccountBtm);
        logInbtn = findViewById(R.id.backToLogIn);

        createAccBtn.setOnClickListener(view -> {
            String username = usernameEt.getText().toString().trim();
            String password = passwordEt.getText().toString().trim();
            String confPassword = confPasswordEt.getText().toString().trim();

            if (!password.equals(confPassword)) {
                confPasswordEt.setBackgroundColor(Color.RED);
                return;
            } else  {
                confPasswordEt.setBackgroundColor(Color.WHITE);
            }

            startActivity(LandingPage.intentFactory(getApplicationContext()));

        });

        logInbtn.setOnClickListener(v -> {
            startActivity(LogIn.intentFactory(getApplicationContext()));
        });


    }

    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, CreateAccount.class);
        return intent;
    }
}

