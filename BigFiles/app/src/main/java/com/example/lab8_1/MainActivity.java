package com.example.lab8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.lab8_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    String name = "???";
    final static String strVariableKey = "STRING_VARIABLE";
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.Savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveName(v);
            }
        });

        binding.getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName(v);
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putString(strVariableKey, name);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        name = savedInstanceState.getString(strVariableKey);
        binding.nameView.setText(name);
    }

    public void saveName(View view){
        name = binding.nameBox.getText().toString();
    }

    public void getName(View view){
        binding.nameView.setText(name);
    }
}