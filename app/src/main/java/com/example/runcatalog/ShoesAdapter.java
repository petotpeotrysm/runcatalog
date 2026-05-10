package com.example.runcatalog;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoesAdapter
        extends RecyclerView.Adapter<ShoesAdapter.ViewHolder> {

    ArrayList<Shoes> listShoes;
    Context context;
    public ShoesAdapter(Context context,
                        ArrayList<Shoes> listShoes) {

        this.context = context;
        this.listShoes = listShoes;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shoes,
                        parent,
                        false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        Shoes shoes = listShoes.get(position);

        holder.txtName.setText(shoes.getName());
        holder.txtBrand.setText(shoes.getBrand());
        holder.txtPrice.setText(shoes.getPrice());
        holder.imgShoes.setImageResource(shoes.getImage());
        holder.itemView.setOnClickListener(v -> {

            Intent intent =
                    new Intent(context,
                            DetailActivity.class);

            intent.putExtra("name",
                    shoes.getName());

            intent.putExtra("brand",
                    shoes.getBrand());

            intent.putExtra("price",
                    shoes.getPrice());

            intent.putExtra("image",
                    shoes.getImage());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listShoes.size();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        ImageView imgShoes;
        TextView txtName, txtBrand, txtPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgShoes =
                    itemView.findViewById(R.id.imgShoes);

            txtName =
                    itemView.findViewById(R.id.txtName);

            txtBrand =
                    itemView.findViewById(R.id.txtBrand);

            txtPrice =
                    itemView.findViewById(R.id.txtPrice);
        }
    }
}