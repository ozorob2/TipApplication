package com.example.omarz.tipapplication;

import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText billTotal, tipPercentage, people;
    TextView totalTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tipCalc = (Button)findViewById(R.id.tipCalc);
        billTotal = (EditText)findViewById(R.id.billTotal);
        tipPercentage = (EditText)findViewById(R.id.tipPercentage);
        people = (EditText)findViewById(R.id.people);
        totalTip = (TextView)findViewById(R.id.totalTip);
        tipCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(billTotal.getText().toString().matches("") || tipPercentage.getText().toString().matches("") || people.getText().toString().matches(""))
                    Toast.makeText(MainActivity.this, "None Of The Fields Can Be Empty!!", Toast.LENGTH_SHORT).show();
                else
                {
                    double totalCost = Double.parseDouble(billTotal.getText().toString());
                    double tipPerc = Double.parseDouble(tipPercentage.getText().toString());
                    int numberOfPeople = Integer.parseInt(people.getText().toString());

                    if (numberOfPeople <= 0)
                        Toast.makeText(MainActivity.this, "Number of People Can Not Be 0!!", Toast.LENGTH_SHORT).show();

                    else
                    {
                        double tip = (tipPerc / 100) * totalCost;
                        double totCost = (totalCost + tip) / numberOfPeople;
                        totalTip.setText(Double.toString(totCost));
                    }
                }
            }
        });
    }
}
