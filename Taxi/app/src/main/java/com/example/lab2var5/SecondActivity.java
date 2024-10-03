package com.example.lab2var5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2var5.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;
    private SharedPreferences sharedPreferences;


    private TextView textViewPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Lifecycle", "SecondActivity onCreate called");
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonCallTaxi.setEnabled(false);

        sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        String phone = getIntent().getStringExtra("phone");
        String name = getIntent().getStringExtra("name");
        String surname = getIntent().getStringExtra("surname");

        binding.textViewName.setText(name + " " + surname);
        binding.textViewPhone.setText(phone);
        textViewPath = binding.textViewPath;


        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                            if (data!= null) {
                                String path = data.getStringExtra("path");
                                textViewPath.setText(path); // Set the text of the path TextView
                                binding.buttonCallTaxi.setEnabled(true);
                            } else {
                                binding.buttonCallTaxi.setEnabled(false);
                            }
                        }
                    }
                });

        binding.buttonSetPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                activityResultLauncher.launch(intent);
                }
        });

        binding.buttonCallTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, "Taxi is on the way!", Toast.LENGTH_SHORT).show();
            }
        });

        Log.d("Lifecycle", "SecondActivity onCreate finished");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("phone", binding.editTextPhone.getText().toString());
//        editor.putString("name", binding.editTextName.getText().toString());
//        editor.putString("surname", binding.editTextSurname.getText().toString());
        editor.apply();
        Log.d("Lifecycle", "SecondActivity onDestroy called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "SecondActivity onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "SecondActivity onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "SecondActivity onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "SecondActivity onStop called");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle", "SecondActivity onRestart called");
    }
}
