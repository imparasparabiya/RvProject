package com.example.rvproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ToyAirplaneActivity extends AppCompatActivity {

    com.example.rvproject.databinding.ActivityToyAirplaneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.rvproject.databinding.ActivityToyAirplaneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnaddcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToyAirplaneActivity.this, AddtoCartActivity.class);
                startActivity(intent);
            }
        });
    }
}