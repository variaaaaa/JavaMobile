package com.example.lab2var5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.lab2var5.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d("Lifecycle", "MainActivity onCreate called");
        sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        binding.buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = binding.editTextPhone.getText().toString();
                String name = binding.editTextName.getText().toString();
                String surname = binding.editTextSurname.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("phone", phone);
                editor.putString("name", name);
                editor.putString("surname", surname);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("phone", phone);
                intent.putExtra("name", name);
                intent.putExtra("surname", surname);
                startActivity(intent);
            }
        });

        if (sharedPreferences.contains("phone")) {
            String phone = sharedPreferences.getString("phone", "");
            String name = sharedPreferences.getString("name", "");
            String surname = sharedPreferences.getString("surname", "");
            binding.editTextPhone.setText(phone);
            binding.editTextName.setText(name);
            binding.editTextSurname.setText(surname);
            binding.buttonRegistration.setText("Log in");
        }
        Log.d("Lifecycle", "MainActivity onCreate finished");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("phone", binding.editTextPhone.getText().toString());
        editor.putString("name", binding.editTextName.getText().toString());
        editor.putString("surname", binding.editTextSurname.getText().toString());
        editor.apply();
        Log.d("Lifecycle", "MainActivity onDestroy called");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "MainActivity onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "MainActivity onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "MainActivity onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "MainActivity onStop called");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle", "MainActivity onRestart called");
    }
}