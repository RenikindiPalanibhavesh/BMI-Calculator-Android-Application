package com.example.BMI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnContextClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll_Main = findViewById(R.id.ll_Main);
        TextView txtResult = findViewById(R.id.txtResult);
        EditText edtWt = findViewById(R.id.edtWt);
        EditText edtHtFt = findViewById(R.id.edtHtFt);
        EditText edtHtIn =findViewById(R.id.edtHtInch);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int Wt = Integer.parseInt(edtWt.getText().toString());
                int Ht_Ft = Integer.parseInt(edtHtFt.getText().toString());
                int Ht_In = Integer.parseInt(edtHtIn.getText().toString());

                int totalInches = Ht_Ft*12 + Ht_In;

                double totalCm = totalInches*2.53;

                double total_Metres = totalCm/100;

                double bmi = Wt/(total_Metres*total_Metres);

                if (bmi>25){
                    txtResult.setText("You're OverWeight!");
                    ll_Main.setBackgroundColor(getResources().getColor(R.color.colorOWt));
                } else if (bmi<18){
                    txtResult.setText("You're UnderWeight!");
                    ll_Main.setBackgroundColor(getResources().getColor(R.color.colorUWt));
                } else {
                    txtResult.setText("You're Healthy");
                    ll_Main.setBackgroundColor(getResources().getColor(R.color.colorHWt));
                }
            }
        });
    }
}