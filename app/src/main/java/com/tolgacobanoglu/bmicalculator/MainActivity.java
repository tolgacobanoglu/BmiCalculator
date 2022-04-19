package com.tolgacobanoglu.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tolgacobanoglu.bmicalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding activityMainBinding;
    private BMI bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main); //it has more benefits than findViewByID more easy to find UI objects there are less codes and don't declare objects

        activityMainBinding.buttonCalculate.setOnClickListener(v -> {
            String height = activityMainBinding.editTextHeight.getText().toString().replace(',','.'); //protect application if user wants to enter "12,8" program will throw exception
            String weight = activityMainBinding.editTextWeight.getText().toString().replace(',','.');
            if (height.equals("") || weight.equals(""))
            {
                Toast.makeText(MainActivity.this, "PLEASE ENTER VALID INPUTS!!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                bmi = new BMI(Double.parseDouble(weight),Double.parseDouble(height));
                activityMainBinding.buttonCalculate.setVisibility(View.INVISIBLE);
                activityMainBinding.textViewBMIResultValue.setText(String.valueOf(bmi.calculate()));
                activityMainBinding.textViewBMIResult.setText(bmi.state());
                activityMainBinding.calculatedLayout.setVisibility(View.VISIBLE);
            }

        });


        activityMainBinding.textViewRecalculate.setOnClickListener(v -> {
            activityMainBinding.calculatedLayout.setVisibility(View.INVISIBLE);
            activityMainBinding.buttonCalculate.setVisibility(View.VISIBLE);
            activityMainBinding.editTextWeight.setText("");
            activityMainBinding.editTextHeight.setText("");
        });

    }

}