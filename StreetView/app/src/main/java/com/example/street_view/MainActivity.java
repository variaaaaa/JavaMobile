package com.example.street_view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.street_view.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnOpenStreetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStreetView();
            }
        });
    }

    private void openStreetView() {
        Uri intentUri = Uri.parse("google.streetview:cbll=59.939448,30.328264&cbp=1,99.56,,1,2.0&mz=19");
        Intent streetView = new Intent(Intent.ACTION_VIEW, intentUri);
        streetView.setPackage("com.google.android.apps.maps");
        startActivity(streetView);
    }
}
