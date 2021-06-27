package com.example.eventhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CatererRecycler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caterer_recycler);

        Caterer caterers[] = new Caterer[]{
                new Caterer(R.drawable.cat_a, "Rajput Pakwan", "Rs:24000"),
                new Caterer(R.drawable.cat_b, "Express Caterers", "Rs:18000"),
                new Caterer(R.drawable.cat_c, "Data Foods", "Rs:32000"),
                new Caterer(R.drawable.cat_d, "Arena Catering", "Rs:15000")
        };

        RecyclerView recyclerView = findViewById(R.id.recycler_caterer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CatererAdapter catererAdapter = new CatererAdapter(caterers, getApplicationContext());
        recyclerView.setAdapter(catererAdapter);
    }
}