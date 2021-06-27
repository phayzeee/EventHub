package com.example.eventhub;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.Constructor> {

    private Venue[] venuedata;
    Context context;
    SharedPreferences sp;


    public VenueAdapter(Venue[] venuedata, Context context) {
        this.venuedata = venuedata;
        this.context = context;
    }


    //    private AddtoCartListener addtoCartListener;

//    public interface AddtoCartListener{
//        void onClickAddtoCart(Button venue_btn, Venue venue);
//    }




//    public void setVenuedata(List<Venue> listdata, AddtoCartListener listener) {
//        this.venuedata = listdata;
//        this.addtoCartListener = listener;
//        notifyDataSetChanged();
//    }

    public static class Constructor extends RecyclerView.ViewHolder{

        public ImageView image_venues;
        public TextView venue_name, venue_price;
        public Button venue_btn;

        public Constructor(@NonNull View itemView) {
            super(itemView);

            image_venues =itemView.findViewById(R.id.venue_img);
            venue_name= itemView.findViewById(R.id.venue_name);
            venue_price=itemView.findViewById(R.id.venue_price);
            venue_btn = itemView.findViewById(R.id.venue_btn);
        }
    }

    @NonNull
    @Override
    public VenueAdapter.Constructor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list = layoutInflater.inflate(R.layout.venue_view, parent, false);
        Constructor ven = new Constructor(list);
        return ven;
    }

    @Override
    public void onBindViewHolder(@NonNull Constructor holder, int position) {
        final Venue listData = venuedata[position];
       // Venue venue = venuedata.get(position);
        holder.image_venues.setImageResource(listData.getVenue_img());
        holder.venue_name.setText(listData.getName_venue());
        holder.venue_price.setText(listData.getPrice_venue());
        holder.venue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(view.getContext(), AddToCart.class);
//                intent.putExtra("key_name",listData.getName_venue());
//                intent.putExtra("key_price",listData.getPrice_venue());
//                view.getContext().startActivity(intent);

                sp = view.getContext().getSharedPreferences("VenuePrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("venname", listData.getName_venue());
                editor.putString("venprice", listData.getPrice_venue());
                editor.commit();

                Intent intent = new Intent(view.getContext(), AddToCart.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return venuedata.length;
    }


}
