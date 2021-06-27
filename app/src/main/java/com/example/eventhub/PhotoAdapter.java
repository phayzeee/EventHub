package com.example.eventhub;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.Constructor>{

    private Photo[] photos;
    Context context;
    SharedPreferences psp;

    public PhotoAdapter(Photo[] photos, Context context) {
        this.photos = photos;
        this.context = context;
    }

    public static class Constructor extends RecyclerView.ViewHolder {

        public ImageView image_pho;
        public TextView name_photo, price_photo;
        public Button btn_pho;
        public Constructor(@NonNull View itemView) {
            super(itemView);

            image_pho = itemView.findViewById(R.id.photo_img);
            name_photo = itemView.findViewById(R.id.photo_name);
            price_photo = itemView.findViewById(R.id.photo_price);
            btn_pho = itemView.findViewById(R.id.photo_btn);
        }
    }

    @NonNull
    @Override
    public Constructor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list = layoutInflater.inflate(R.layout.photo_view, parent, false);
        Constructor ven = new Constructor(list);
        return ven;
    }

    @Override
    public void onBindViewHolder(@NonNull Constructor holder, int position) {
        final Photo data = photos[position];
        holder.image_pho.setImageResource(data.getPhoto_img());
        holder.name_photo.setText(data.getPhoto_name());
        holder.price_photo.setText(data.getPhoto_price());
        holder.btn_pho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                psp =view.getContext().getSharedPreferences("PhotoPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor PhotoEditor = psp.edit();
                PhotoEditor.putString("photoname", data.getPhoto_name());
                PhotoEditor.putString("photoprice",data.getPhoto_price());
                PhotoEditor.commit();

                Intent intent = new Intent(view.getContext(), AddToCart.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return photos.length;
    }


}
