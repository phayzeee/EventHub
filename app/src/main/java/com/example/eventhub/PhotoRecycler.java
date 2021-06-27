package com.example.eventhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PhotoRecycler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_recycler);

        Photo photo[] = new Photo[]{
                new Photo(R.drawable.photog_a, "Ghouri Photographers", "Rs:24000"),
                new Photo(R.drawable.photog_b, "OK Productions", "Rs:44000"),
                new Photo(R.drawable.photog_c, "Demon Studio", "Rs:33000"),
                new Photo(R.drawable.photog_d, "Hidden Captures", "Rs:21000")
        };

        RecyclerView recyclerView = findViewById(R.id.recycler_photo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PhotoAdapter photoAdapter = new PhotoAdapter(photo, getApplicationContext());
        recyclerView.setAdapter(photoAdapter);
    }
}