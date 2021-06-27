package com.example.eventhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Customer extends AppCompatActivity {

    LinearLayout linearLayout_a, linearLayout_b, linearLayout_c, linearLayout_d;
    ImageView toolbar_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        linearLayout_a = (LinearLayout) findViewById(R.id.first_linear);
        linearLayout_b = (LinearLayout) findViewById(R.id.sec_linear);
        linearLayout_c = (LinearLayout) findViewById(R.id.third_linear);
        linearLayout_d = (LinearLayout) findViewById(R.id.fourth_linear);
        toolbar_img = (ImageView) findViewById(R.id.image_toolbar);

        linearLayout_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_a = new Intent(Customer.this, VenueRecycler.class);
                startActivity(intent_a);
            }
        });

        linearLayout_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_b = new Intent(Customer.this, CatererRecycler.class);
                startActivity(intent_b);
            }
        });

        linearLayout_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_c = new Intent(Customer.this, DecoratorRecycler.class);
                startActivity(intent_c);
            }
        });

        linearLayout_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_d = new Intent(Customer.this, PhotoRecycler.class);
                startActivity(intent_d);
            }
        });

        toolbar_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_e = new Intent(Customer.this, AddToCart.class);
                startActivity(intent_e);
            }
        });
    }
}