package com.example.bmiapp.OOP;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmiapp.R;

public class FoodHolder extends RecyclerView.ViewHolder{
    TextView name;
    TextView category;
    TextView calorie;
    public FoodHolder(@NonNull View itemView) {
        super(itemView);
        this.name=itemView.findViewById(R.id.fi_nameVariable);
        this.category=itemView.findViewById(R.id.fi_categoryVariable);
        this.name=itemView.findViewById(R.id.fi_calorieVariable);
    }
}
