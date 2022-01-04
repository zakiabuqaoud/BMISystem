package com.example.bmiapp;

import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bmiapp.OOP.FireBaseConnection;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int counter = 5000;
        CountDownTimer countDownTimer;
        countDownTimer = new CountDownTimer(counter,1000) {
            public void onTick(long millisUntilFinished){}
            public  void onFinish(){ }
        }.start();
        Intent intent = new Intent(MainActivity.this,activity_BMI_Login.class);
        finish();
        startActivity(intent);

        Button nextButton = findViewById(R.id.main_nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_BMI_Login.class);
                finish();
                startActivity(intent);
            }
        });
    }
}