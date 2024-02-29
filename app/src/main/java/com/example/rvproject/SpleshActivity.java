package com.example.rvproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.rvproject.databinding.ActivitySpleshBinding;

public class SpleshActivity extends AppCompatActivity {

    ActivitySpleshBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpleshBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SpleshActivity.this, MainActivity.class));
                finish();
            }
        },2000);
    }
}