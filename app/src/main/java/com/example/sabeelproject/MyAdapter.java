package com.example.sabeelproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<DataClass> list;

    public MyAdapter(Context context, ArrayList<DataClass> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.donation_items,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataClass user=list.get(position);
        holder.item.setText(user.getItem());
        holder.firstname.setText(user.getFirstname());
        holder.lastname.setText(user.getLastname());
        holder.phone.setText(user.getPhone());
        holder.address.setText(user.getAddress());
        holder.details.setText(user.getDetails());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item,firstname,lastname,phone,address,details;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item=itemView.findViewById(R.id.item);
            firstname=itemView.findViewById(R.id.firstname);
            lastname=itemView.findViewById(R.id.lastname);
            phone=itemView.findViewById(R.id.phonenumber);
            address=itemView.findViewById(R.id.adderss);
            details=itemView.findViewById(R.id.details);
        }
    }
}
