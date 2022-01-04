package com.example.bmiapp.OOP;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.bmiapp.R;
import com.example.bmiapp.OOP.RecordHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecordAdapter extends RecyclerView.Adapter<RecordHolder>{

    @NonNull
    @Override
    public RecordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecordHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.record_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecordHolder holder, int position) {
        holder.weight.setText();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
