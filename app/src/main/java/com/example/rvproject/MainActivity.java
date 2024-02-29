package com.example.rvproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.rvproject.adapter.MainToyAdapter;
import com.example.rvproject.databinding.ActivityMainBinding;
import com.example.rvproject.modalclass.MainToyModalclass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String[] toysname = {"School Bus","Toy Airplane","Rubber Ducky","Toy Car","Toy Dinosaur","Teddy Bear"};
    Integer[] toyimg = {R.drawable.schoolbus_blue,R.drawable.airplane,R.drawable.dykes,R.drawable.toy_car,R.drawable.dinosaur,R.drawable.bear};
    String[] toyamount = {"$100","$540","$350","$659","$900","$850"};


    ArrayList<MainToyModalclass> modalclasses = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        for (int i=0;i<toysname.length;i++){
            MainToyModalclass m1 = new MainToyModalclass(toysname[i],toyimg[i],toyamount[i]);
            modalclasses.add(m1);
        }

        MainToyAdapter adapter = new MainToyAdapter(this,modalclasses);
        binding.rvData.setAdapter(adapter);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        binding.rvData.setLayoutManager(lm);

    }
}