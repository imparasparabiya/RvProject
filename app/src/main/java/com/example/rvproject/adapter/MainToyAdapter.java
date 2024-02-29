package com.example.rvproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rvproject.R;
import com.example.rvproject.ToyAirplaneActivity;
import com.example.rvproject.ToyViewActivity;
import com.example.rvproject.modalclass.MainToyModalclass;

import java.util.ArrayList;

public class MainToyAdapter extends RecyclerView.Adapter<MainToyAdapter.ToyViewHolder> {

    Context context;

    ArrayList<MainToyModalclass> modalclasses = new ArrayList<>();

    public MainToyAdapter(Context context, ArrayList<MainToyModalclass> modalclasses) {
        //Constructor
        this.context = context;
        this.modalclasses = modalclasses;
    }

    @NonNull
    @Override
    public ToyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // View Attech
        View view = LayoutInflater.from(context).inflate(R.layout.toy_tile,parent,false);

        return new ToyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToyViewHolder holder, int position) {

        holder.product_img.setImageResource(modalclasses.get(position).toyimg);
        holder.product_name.setText(modalclasses.get(position).toyname);
        holder.product_amount.setText(modalclasses.get(position).toyamount);
        holder.crdtoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ToyViewActivity.class);
                intent.putExtra("toyname", String.valueOf(holder.product_name));
                intent.putExtra("toyamount", String.valueOf(holder.product_amount));
                intent.putExtra("toyimg", holder.product_img.getDrawableState());
                context.startActivity(intent);
            }
        });
        holder.crdtoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ToyAirplaneActivity.class);
                intent.putExtra("toyname", String.valueOf(holder.product_name));
                intent.putExtra("toyamount", String.valueOf(holder.product_amount));
                intent.putExtra("toyimg", holder.product_img.getDrawableState());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return modalclasses.size();
    }

    class ToyViewHolder extends RecyclerView.ViewHolder{

        ImageView product_img;
        TextView product_name;
        TextView product_amount;
        CardView crdtoy;

        public ToyViewHolder(@NonNull View itemView) {
            super(itemView);

            product_img = itemView.findViewById(R.id.product_img);
            product_name = itemView.findViewById(R.id.product_name);
            product_amount = itemView.findViewById(R.id.product_amount);
            crdtoy = itemView.findViewById(R.id.crdtoy);

        }

    }

    public interface OnClickItem{
        void onClick(int position,MainToyModalclass toyModalclass);
    }

}
