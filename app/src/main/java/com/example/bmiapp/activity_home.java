package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bmiapp.OOP.FireBaseConnection;

public class activity_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button logout = findViewById(R.id.h_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FireBaseConnection.logout();
                Intent intent = new Intent(activity_home.this,activity_BMI_Login.class);
                finish();
                startActivity(intent);
            }
        });

        Button addFood = findViewById(R.id.h_addFood);
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_home.this, activity_add_food_details.class);
                startActivity(intent);
            }
        });

        Button addRecord = findViewById(R.id.h_addRecord);
        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_home.this, activity_new_record.class);
                startActivity(intent);
            }
        });

        Button viewFood = findViewById(R.id.h_viewFood);
        viewFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_home.this, activity_Food_List.class);
                startActivity(intent);
            }
        });

    }
    public static void check(){}
}