package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bmiapp.OOP.FireBaseConnection;

public class activity_BMI_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Context context = this.getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_login);

        //email
        EditText emailEditText = findViewById(R.id.l_FirstEditTextUsername);
        String email = emailEditText.getText().toString();
        //password
        EditText passwordEditText = findViewById(R.id.l_SecondEditTextPassword);
        String password = passwordEditText.getText().toString();

        Button loginButton = findViewById(R.id.l_FirstButtonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FireBaseConnection.login((AppCompatActivity) context);
            }
        });

        Button signUp = findViewById(R.id.l_signUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_BMI_Login.this, activity_bmi_register.class);
                startActivity(intent);
            }
        });
    }
}