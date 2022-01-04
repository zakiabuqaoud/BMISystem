package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bmiapp.OOP.FireBaseConnection;
import com.example.bmiapp.OOP.Food;
import com.example.bmiapp.OOP.UserException;

public class activity_add_food_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_details);

        EditText name = findViewById(R.id.af_name);
        Spinner category = findViewById(R.id.af_category);
        EditText calorie = findViewById(R.id.af_calorie);
        Button save = findViewById(R.id.save);

        String nameString = name.getText().toString();
        double calorieDouble = Double.parseDouble(calorie.getText().toString());
        TextView tv = (TextView) category.getSelectedView();
        String categoryString = tv.getText().toString();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nameString == null || categoryString ==null || calorie.getText().toString() == null ){
                    try {
                        throw new UserException("please, full the fields");
                    } catch (UserException e) {
                        e.printStackTrace();
                    }
                }else{
                    Food food = new Food(nameString,categoryString,calorieDouble);
                    FireBaseConnection.addFood(food);
                }
                Intent intent=new Intent(activity_add_food_details.this, activity_home.class);
                finish();
                startActivity(intent);
            }
        });
    }
}