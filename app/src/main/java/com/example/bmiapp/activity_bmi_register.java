package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bmiapp.OOP.FireBaseConnection;
import com.example.bmiapp.OOP.User;

import com.example.bmiapp.OOP.User;
import com.example.bmiapp.OOP.UserException;

public class activity_bmi_register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Context context = this.getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_register);

        //userName
        EditText userNameEditText = findViewById(R.id.r_FirstEditTextUsername);
        String userName = userNameEditText.getText().toString();
        //email
        EditText emailEditText = findViewById(R.id.r_SecondEditTextEmail);
        String email = emailEditText.getText().toString();
        //password
        EditText passwordEditText = findViewById(R.id.r_ThirdEditTextPassword);
        String password = passwordEditText.getText().toString();
        //passwordConfirmation
        EditText passwordConfirmationEditText = findViewById(R.id.r_FourthEditTextPasswordConfirm);
        String passwordConfirmation = passwordConfirmationEditText.getText().toString();
        //Button
        Button registerButton = findViewById(R.id.r_FirstButtonLogin);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v){
                try {
                    User user = new User(userName, email, password, passwordConfirmation, (AppCompatActivity) context);
                    FireBaseConnection.registration(user, (AppCompatActivity) context);
                } catch (UserException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(activity_bmi_register.this, activity_complete_your_information.class);
                    finish();
                    startActivity(intent);
            }
        });

        Button signIn = findViewById(R.id.r_login);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_bmi_register.this, activity_BMI_Login.class);
                startActivity(intent);
            }
        });
    }
}