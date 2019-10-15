package com.example.compoundinterest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float i;
    int y, r;

    EditText initialDeposit, years, rate;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialDeposit = (EditText) findViewById(R.id.rate);
        initialDeposit.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        years = (EditText) findViewById(R.id.years);
        rate = (EditText) findViewById(R.id.rate);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = Float.parseFloat(initialDeposit.getText().toString());
                y = Integer.parseInt(years.getText().toString());
                r = Integer.parseInt(rate.getText().toString())/100;

                double result = Math.pow((1+r), y)*i;

                Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
