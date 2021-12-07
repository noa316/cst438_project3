package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {


    EditText mUsername;
    EditText mPassword;

    private Button mLogInBtn;
    private Button mCreateAccBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mUsername = findViewById(R.id.logInUsernameET);
        mPassword= findViewById(R.id.createAccPasswordET);
        mLogInBtn = findViewById(R.id.createAccountBtm);
//
//        mLogInBtn.setOnClickListener(view -> {
//            String username = mUsername.getText().toString();
//            String password = mPassword.getText().toString();
////
//            User user = verifyLogin(username,password);
//
//            String user = "New User";
//
//            if(user == null ){
//                Toast toast = Toast.makeText(this, "Try Again",Toast.LENGTH_LONG);
//                toast.show();
//            }
//            else{
//                    startActivity(LandingPage.intentFactory((getApplicationContext())));
//                }
//
//        });

        mCreateAccBtn = findViewById(R.id.mCreateAccount);

        mCreateAccBtn.setOnClickListener(v -> {
            startActivity(CreateAccount.intentFactory(getApplicationContext()));
        });
    }


    public static Intent intentFactory(Context ctx) {
        Intent intent = new Intent(ctx, MainActivity.class);
        return intent;
    }

//    private User verifyLogin(String username, String password){
//
//        if(user == null){
//            Toast toast = Toast.makeText(this, "Invalid Username",Toast.LENGTH_LONG);
//            toast.show();
//            mUsername.setText(null);
//            mPassword.setText(null);
//            return null;
//        }
//
//        String truePassword = user.getPassword();
//        if(truePassword.equals(password)){
//            user.signIn();
//            return user;
//        }
//        else{
//            Toast toast = Toast.makeText(this, "Invalid Password",Toast.LENGTH_LONG);
//            toast.show();
//            mPassword.setText(null);
//            return null;
//        }
//    }

}


