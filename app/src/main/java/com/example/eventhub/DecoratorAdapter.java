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

public class DecoratorAdapter extends RecyclerView.Adapter<DecoratorAdapter.Constructor> {

    private Decorator[] decorators;
    Context context;
    SharedPreferences dsp;

    public DecoratorAdapter(Decorator[] decorators, Context context) {
        this.decorators = decorators;
        this.context = context;
    }
    public static class Constructor extends RecyclerView.ViewHolder {

        public ImageView image_dec;
        public TextView dec_name, dec_price;
        public Button dec_btn;

        public Constructor(@NonNull View itemView) {
            super(itemView);

            image_dec = itemView.findViewById(R.id.decorator_img);
            dec_name = itemView.findViewById(R.id.decorator_name);
            dec_price = itemView.findViewById(R.id.decorator_price);
            dec_btn = itemView.findViewById(R.id.decorator_btn);
        }
    }

    @NonNull
    @Override
    public Constructor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list = layoutInflater.inflate(R.layout.decorator_view, parent, false);
        Constructor ven = new Constructor(list);
        return ven;
    }

    @Override
    public void onBindViewHolder(@NonNull Constructor holder, int position) {

        final Decorator dataList = decorators[position];
        holder.image_dec.setImageResource(dataList.getDec_img());
        holder.dec_name.setText(dataList.getDec_name());
        holder.dec_price.setText(dataList.getDec_price());
        holder.dec_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsp =view.getContext().getSharedPreferences("DecPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor DecEditor = dsp.edit();
                DecEditor.putString("decname", dataList.getDec_name());
                DecEditor.putString("decprice",dataList.getDec_price());
                DecEditor.commit();

                Intent intent = new Intent(view.getContext(), AddToCart.class);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return decorators.length;
    }

}
