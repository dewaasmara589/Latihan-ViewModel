package com.dewa.myviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.dewa.myviewmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        displayResult();

        activityMainBinding.btnCalculate.setOnClickListener(view -> {
            String width = activityMainBinding.edtWidth.getText().toString();
            String height = activityMainBinding.edtHeight.getText().toString();
            String length = activityMainBinding.edtLength.getText().toString();

            if (width.isEmpty()) {
                activityMainBinding.edtWidth.setError("Masih Kosong");
            }else if(height.isEmpty()){
                activityMainBinding.edtHeight.setError("Masih Kosong");
            }else if(length.isEmpty()){
                activityMainBinding.edtLength.setError("Masih Kosong");
            }else{
                viewModel.calculate(width, height, length);
                displayResult();
            }
        });
    }

    private void displayResult(){
        activityMainBinding.tvResult.setText(String.valueOf(viewModel.result));
    }
}