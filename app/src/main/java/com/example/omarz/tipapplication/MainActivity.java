package com.example.omarz.tipapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText billTotal, tipPercentage;
    TextView totalTip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tipCalc = (Button)findViewById(R.id.tipCalc);
        billTotal = (EditText)findViewById(R.id.billTotal);
        tipPercentage = (EditText)findViewById(R.id.tipPercentage);
        totalTip = (TextView)findViewById(R.id.totalTip);
        tipCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double totalCost = Double.parseDouble(billTotal.getText().toString());
                Double tipPerc = Double.parseDouble(tipPercentage.getText().toString());

                Double tip = (tipPerc / 100) * totalCost;
                totalTip.setText(Double.toString(tip));
            }
        });
    }
}
