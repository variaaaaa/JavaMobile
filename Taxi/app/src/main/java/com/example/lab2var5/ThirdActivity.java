package com.example.lab2var5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.widget.SwitchCompat;

import androidx.appcompat.app.AppCompatActivity;


import com.example.lab2var5.databinding.ActivityThirdBinding;


public class ThirdActivity extends AppCompatActivity {

    public SwitchCompat switchSound;

    private ActivityThirdBinding binding;

    private MediaPlayer mediaPlayer;

    private void playSound() {
        if (switchSound.isChecked()) {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.music);
                mediaPlayer.setLooping(true);
            }
            mediaPlayer.start();
        } else {
            mediaPlayer.pause();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Lifecycle", "ThirdActivity onCreate called");
        setContentView(R.layout.activity_third);
        binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        switchSound = binding.switchSound;
       // Загрузка предыдущего состояния переключателя из SharedPreferences
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        boolean soundState = sharedPref.getBoolean("sound_state", true);
        switchSound.setChecked(soundState);

        switchSound.setChecked(true);

        playSound();

        switchSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mediaPlayer.start();
                } else{
                    mediaPlayer.pause();
                }

            }
        });

        binding.buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String streetView = binding.streetView.getText().toString();
                String houseView = binding.houseView.getText().toString();
                String flatView = binding.flatView.getText().toString();

                String streetView2 = binding.streetView2.getText().toString();
                String houseView2 = binding.houseView2.getText().toString();
                String flatView2 = binding.flatView2.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("path", "From " + streetView + " " + houseView + " " + flatView + " to " + streetView2 + " " + houseView2 + " " + flatView2);
                playSound();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        Log.d("Lifecycle", "ThirdActivity onCreate finished");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "ThirdActivity onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "ThirdActivity onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "ThirdActivity onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "ThirdActivity onStop called");
        mediaPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "ThirdActivity onDestroy called");
        mediaPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle", "ThirdActivity onRestart called");
    }

}


