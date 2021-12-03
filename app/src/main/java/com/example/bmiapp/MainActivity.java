package com.example.bmiapp;

import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

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
        this.finish();
        startActivity(intent);
    }
}