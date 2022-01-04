package com.example.bmiapp.OOP;

import com.example.bmiapp.R;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecordHolder extends RecyclerView.ViewHolder {
    TextView weight;
    TextView length;
    TextView status;
    TextView Date;
    public RecordHolder(@NonNull View itemView) {
        super(itemView);
        this.weight=itemView.findViewById(R.id.weightVariable);
        this.length=itemView.findViewById(R.id.lengthVariable);
        this.status=itemView.findViewById(R.id.statusVariable);
        this.Date=itemView.findViewById(R.id.dateVariable);

    }
}
