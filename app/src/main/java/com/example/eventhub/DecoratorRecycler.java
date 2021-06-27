package com.example.eventhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class DecoratorRecycler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator_recycler);

        Decorator decorator[] = new Decorator[]{
                new Decorator(R.drawable.dec_a, "Pure Events", "Rs:24000"),
                new Decorator(R.drawable.dec_b, "Precious Flourists", "Rs:44000"),
                new Decorator(R.drawable.dec_c, "Coco Designs", "Rs:33000"),
                new Decorator(R.drawable.dec_d, "A for Art Events", "Rs:21000")
        };

        RecyclerView recyclerView = findViewById(R.id.recycler_decorator);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DecoratorAdapter decoratorAdapter = new DecoratorAdapter(decorator, getApplicationContext());
        recyclerView.setAdapter(decoratorAdapter);
    }
}