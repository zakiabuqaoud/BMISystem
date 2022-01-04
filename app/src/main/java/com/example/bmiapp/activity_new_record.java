package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bmiapp.OOP.FireBaseConnection;
import com.example.bmiapp.OOP.Record;
import com.example.bmiapp.OOP.User;
import com.example.bmiapp.OOP.UserException;

public class activity_new_record extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_record);

        EditText weight = findViewById(R.id.ar_w);
        EditText length = findViewById(R.id.ar_len);
        EditText time = findViewById(R.id.ar_time);
        EditText date = findViewById(R.id.ar_date);

        Button increaseLength = findViewById(R.id.ar_inc_len);
        Button decreaseLength = findViewById(R.id.ar_dec_len);
        Button increaseWeight = findViewById(R.id.ar_inc_w);
        Button decreaseWeight = findViewById(R.id.ar_dec_w);
        Button saveData = findViewById(R.id.ar_saveData);


        increaseLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int LengthInt;
                if(length.getText().toString() == null){
                    try {
                        throw new UserException("the length field is empty");
                    } catch (UserException e) {
                        e.printStackTrace();
                    }
                }else{
                    LengthInt = Integer.parseInt(length.getText().toString());
                    LengthInt++;
                    length.setText(LengthInt + "");
                }
            }
        });

        decreaseLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int LengthInt;
                if(length.getText().toString() == null){
                    try {
                        throw new UserException("the length field is empty");
                    } catch (UserException e) {
                        e.printStackTrace();
                    }
                }else{
                    LengthInt = Integer.parseInt(length.getText().toString());
                    LengthInt--;
                    length.setText(LengthInt + "");
                }

            }
        });

        increaseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weightInt;
                if(weight.getText().toString() == null){
                    try {
                        throw new UserException("the weight field is empty");
                    } catch (UserException e) {
                        e.printStackTrace();
                    }
                }else{
                    weightInt = Integer.parseInt(weight.getText().toString());
                    weightInt++;
                    weight.setText(weightInt + "");
                }
            }
        });

        decreaseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weightInt;
                if(weight.getText().toString() == null){
                    try {
                        throw new UserException("the weight field is empty");
                    } catch (UserException e) {
                        e.printStackTrace();
                    }
                }else{
                    weightInt = Integer.parseInt(weight.getText().toString());
                    weightInt--;
                    weight.setText(weightInt + "");
                }

            }
        });

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(time.getText().toString() == null){
                    try {
                        throw new UserException("the time field is empty");
                    } catch (UserException e) {
                        e.printStackTrace();
                    }
                }
                if(date.getText().toString() == null){
                    try {
                        throw new UserException("the  date field is empty");
                    } catch (UserException e) {
                        e.printStackTrace();
                    }
                }
                int weightInt = Integer.parseInt(weight.getText().toString());
                int lengthInt = Integer.parseInt(length.getText().toString());
                String dateString = date.getText().toString();
                String timeString = time.getText().toString();
                User user = User.user;
                Record record = new Record(weightInt, weightInt,dateString,timeString);
                FireBaseConnection.addRecord(record);

                Intent intent = new Intent(activity_new_record.this, activity_home.class);
                finish();
                startActivity(intent);
            }
        });

    }
}