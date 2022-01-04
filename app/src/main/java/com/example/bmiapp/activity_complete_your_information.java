package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.bmiapp.OOP.FireBaseConnection;
import com.example.bmiapp.OOP.User;

import com.example.bmiapp.OOP.UserException;

public class activity_complete_your_information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_your_information);

        RadioGroup genderRadio = findViewById(R.id.c_radio_group);
        EditText length = findViewById(R.id.c_lengthEditText);
        EditText weight = findViewById(R.id.c_weightEditText);
        EditText birthOfDate = findViewById(R.id.c_DateOfBirthEditText);

        Button increaseLength = findViewById(R.id.c_incLen);
        Button decreaseLength = findViewById(R.id.c_decLen);
        Button increaseWeight = findViewById(R.id.c_incW);
        Button decreaseWeight = findViewById(R.id.c_decW);
        Button saveData = findViewById(R.id.c_saveData);


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
                if(birthOfDate.getText().toString() == null){
                    try {
                        throw new UserException("the birth of date field is empty");
                    } catch (UserException e) {
                        e.printStackTrace();
                    }
                }
                int weightInt = Integer.parseInt(weight.getText().toString());
                int lengthInt = Integer.parseInt(length.getText().toString());
                String BirthOfDateString = birthOfDate.getText().toString();
                int genderID = genderRadio.getCheckedRadioButtonId();
                View viewG = genderRadio.findViewById(genderID);
                String genderString = viewG.toString();

                User.user.setGender("genderString");
                User.user.setGender("BirthOfDateString");
                FireBaseConnection.completeUserData(weightInt,lengthInt);

                Intent intent = new Intent(activity_complete_your_information.this, activity_home.class);
                finish();
                startActivity(intent);
            }
        });
    }
}