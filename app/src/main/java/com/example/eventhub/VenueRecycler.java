package com.example.eventhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VenueRecycler extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_recycler);



        Venue venues[] =new Venue[]{
                new Venue(R.drawable.venue_a, "The Mark Hotel", "Rs:24000"),
                new Venue(R.drawable.venue_b, "Clark Suites", "Rs:18000"),
                new Venue(R.drawable.venue_c, "The Palace", "Rs:32000"),
                new Venue(R.drawable.venue_d, "Arena Club", "Rs:15000")
        };

        RecyclerView recyclerView =findViewById(R.id.recycler_venue);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         VenueAdapter venueAdapter = new VenueAdapter(venues, getApplicationContext());
        recyclerView.setAdapter(venueAdapter);

    }

//    private List<Venue> getVenueData() {
//        List<Venue> list = new ArrayList<>();
//        list.add(new Venue(R.drawable.venue_a, "The Mark Hotel", "Rs:24000"));
//        list.add(new Venue(R.drawable.venue_b, "Clark Suites", "Rs:18000"));
//        list.add(new Venue(R.drawable.venue_c, "The Palace", "Rs:32000"));
//        list.add(new Venue(R.drawable.venue_d, "Arena Club", "Rs:15000"));
//        return list;
//    }


}