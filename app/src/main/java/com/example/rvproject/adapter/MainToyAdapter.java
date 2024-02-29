package com.example.rvproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rvproject.R;
import com.example.rvproject.modalclass.MainToyModalclass;

import java.util.ArrayList;

public class MainToyAdapter extends RecyclerView.Adapter<MainToyAdapter.ToyViewHolder> {

    Context context;

    ArrayList<MainToyModalclass> modalclasses = new ArrayList<>();

    private SelectListener listener;



    public MainToyAdapter(Context context, ArrayList<MainToyModalclass> modalclasses) {
        //Constructor
        this.context = context;
        this.modalclasses = modalclasses;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ToyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // View Attech
        View view = LayoutInflater.from(context).inflate(R.layout.toy_layout_style,parent,false);

        return new ToyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToyViewHolder holder, int position) {

        MainToyModalclass toyModalclass = modalclasses.get(position);
        holder.product_img.setImageResource(modalclasses.get(position).toyimg);
        holder.product_name.setText(modalclasses.get(position).toyname);
        holder.product_amount.setText(modalclasses.get(position).toyamount);

        holder.crdtoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(modalclasses.get(position));
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
}
