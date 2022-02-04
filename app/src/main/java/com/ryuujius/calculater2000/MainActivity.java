package com.ryuujius.calculater2000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextOne;
    EditText editTextTwo;
    TextView textView;
    SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferencesNumberOne;
    SharedPreferences getSharedPreferencesNumberTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextOne = findViewById(R.id.editTextNumber);
        editTextTwo = findViewById(R.id.editTextNumber2);
        textView = findViewById(R.id.textView);

        sharedPreferences = this.getSharedPreferences("com.ryuujius.calculater2000", Context.MODE_PRIVATE);

        float storedResult = sharedPreferences.getFloat("storedResult",0);
        if (storedResult != 0){
            textView.setText("Result is " + storedResult);
        }else{
            textView.setText("pls enter number");
        }


    }

    public void Sum(View view){
        if (!editTextOne.getText().toString().matches("") && !editTextTwo.getText().toString().matches("")){
            float numberOne = Integer.parseInt(editTextOne.getText().toString());

            float numberTwo = Integer.parseInt(editTextTwo.getText().toString());

            float result = numberOne + numberTwo;
            textView.setText("Result is " + result);
            sharedPreferences.edit().putFloat("storedResult",result).apply();
        }else{
            textView.setText("pls enter a number");
        }
    }

    public void Extract(View view){
        if (!editTextOne.getText().toString().matches("") && !editTextTwo.getText().toString().matches("")){
            float numberOne = Integer.parseInt(editTextOne.getText().toString());

            float numberTwo = Integer.parseInt(editTextTwo.getText().toString());

            float result = numberOne - numberTwo;
            textView.setText("Result is " + result);
            sharedPreferences.edit().putFloat("storedResult",result).apply();
        }else{
            textView.setText("pls enter a number");
        }
    }

    public void Divide(View view){
        if (!editTextOne.getText().toString().matches("") && !editTextTwo.getText().toString().matches("")){
            float numberOne = Integer.parseInt(editTextOne.getText().toString());

            float numberTwo = Integer.parseInt(editTextTwo.getText().toString());

            float result = numberOne / numberTwo;
            textView.setText("Result is " + result);
            sharedPreferences.edit().putFloat("storedResult",result).apply();
        }else{
            textView.setText("pls enter a number");
        }
    }

    public void Multiply(View view){
        if (!editTextOne.getText().toString().matches("") && !editTextTwo.getText().toString().matches("")){
            float numberOne = Integer.parseInt(editTextOne.getText().toString());

            float numberTwo = Integer.parseInt(editTextTwo.getText().toString());

            float result = numberOne * numberTwo;
            textView.setText("Result is " + result);
            sharedPreferences.edit().putFloat("storedResult",result).apply();
        }else{
            textView.setText("pls enter a number");
        }
    }

    public void Reset(View view){
        float storedData = sharedPreferences.getFloat("storedResult",0);

        if (storedData != 0){
            sharedPreferences.edit().remove("storedResult");
            textView.setText("Result:");
        }
    }

}