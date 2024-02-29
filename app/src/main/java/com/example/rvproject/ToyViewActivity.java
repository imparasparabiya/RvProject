package com.example.rvproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.rvproject.databinding.ActivityToyViewBinding;

public class ToyViewActivity extends AppCompatActivity {
    ActivityToyViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityToyViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.backarrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        binding.btnaddcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToyViewActivity.this, AddtoCartActivity.class);
                startActivity(intent);
            }
        });

    }
void setBinding(){
    Intent intent = getIntent();

    String name = intent.getStringExtra("toyname");
    String amount = intent.getStringExtra("toyamount");
    String img = intent.getStringExtra("toyimg");

    binding.txttoyname.setText(name);
    binding.txttoyamount.setText(amount);
    binding.toyimg.setImageResource(Integer.parseInt(img));


}

}