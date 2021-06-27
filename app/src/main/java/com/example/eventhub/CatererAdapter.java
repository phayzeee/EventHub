package com.example.eventhub;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CatererAdapter extends RecyclerView.Adapter<CatererAdapter.Constructor> {

    private Caterer[] caterers;
    Context context;
    SharedPreferences csp;

    public CatererAdapter(Caterer[] caterers, Context context) {
        this.caterers = caterers;
        this.context = context;
    }

    public static class Constructor extends RecyclerView.ViewHolder {

        public ImageView image_cat;
        public TextView cat_name, cat_price;
        public Button cat_btn;

        public Constructor(@NonNull View itemView) {
            super(itemView);

            image_cat = itemView.findViewById(R.id.caterer_img);
            cat_name = itemView.findViewById(R.id.caterer_name);
            cat_price = itemView.findViewById(R.id.caterer_price);
            cat_btn = itemView.findViewById(R.id.caterer_btn);
        }
    }

    @NonNull
    @Override
    public Constructor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list = layoutInflater.inflate(R.layout.caterer_view, parent, false);
        Constructor ven = new Constructor(list);
        return ven;
    }

    @Override
    public void onBindViewHolder(@NonNull Constructor holder, int position) {

        final Caterer listData = caterers[position];
        holder.image_cat.setImageResource(listData.getCat_img());
        holder.cat_name.setText(listData.getName_cat());
        holder.cat_price.setText(listData.getPrice_cat());
        holder.cat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), AddToCart.class);
//                intent.putExtra("catname",listData.getName_cat());
//                intent.putExtra("catprice",listData.getPrice_cat());
//                view.getContext().startActivity(intent);

                csp =view.getContext().getSharedPreferences("CatPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor CatEditor = csp.edit();
                CatEditor.putString("cattname", listData.getName_cat());
                CatEditor.putString("cattprice",listData.getPrice_cat());
                CatEditor.commit();

                Intent intent = new Intent(view.getContext(), AddToCart.class);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return caterers.length;
    }


}
