package com.example.eventhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddToCart extends AppCompatActivity {

    TextView tvatc, catatc, decatc, phoatc;
    Button cnfrm_btn;
    SharedPreferences sp, csp, dsp, psp;
//    Button atc_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        tvatc = (TextView)findViewById(R.id.tv_atc);
        catatc =(TextView)findViewById(R.id.cat_atc);
        decatc = (TextView)findViewById(R.id.dec_atc);
        phoatc = (TextView) findViewById(R.id.photo_atc);
        cnfrm_btn = (Button)findViewById(R.id.atcbtn);
//        sp = getSharedPreferences("VenuePrefs", Context.MODE_PRIVATE);
//        csp =getSharedPreferences("CatPrefs", Context.MODE_PRIVATE);

        sp = getApplicationContext().getSharedPreferences("VenuePrefs", Context.MODE_PRIVATE);
        String vname = sp.getString("venname", "");
        String vprice = sp.getString("venprice", "");
        tvatc.setText(vname+"\n"+vprice);

        csp = getApplicationContext().getSharedPreferences("CatPrefs", Context.MODE_PRIVATE);
        String cname = csp.getString("cattname", "");
        String cprice = csp.getString("cattprice", "");
        catatc.setText(cname+"\n"+cprice);

        dsp = getApplicationContext().getSharedPreferences("DecPrefs", Context.MODE_PRIVATE);
        String dname = dsp.getString("decname", "");
        String dprice = dsp.getString("decprice", "");
        decatc.setText(dname+"\n"+dprice);

        psp = getApplicationContext().getSharedPreferences("PhotoPrefs", Context.MODE_PRIVATE);
        String pname = psp.getString("photoname", "");
        String pprice = psp.getString("photoprice", "");
        phoatc.setText(pname+"\n"+pprice);

        cnfrm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddToCart.this,CustomerInfo.class);
                startActivity(intent);
            }
        });


//        Bundle extras = getIntent().getExtras();
//        Intent extras = getIntent();
//           String venue_names = extras.getStringExtra("key_name");
//           String venue_prices = extras.getStringExtra("key_price");
//           String caterer_names = extras.getStringExtra("catname");
//           String caterer_price = extras.getStringExtra("catprice");

//        SharedPreferences.Editor editor = sp.edit();
//        editor.putString("venname", venue_names);
//        editor.putString("venprice", venue_prices);
//        editor.commit();

//        SharedPreferences.Editor CatEditor = csp.edit();
//        CatEditor.putString("cattname", caterer_names);
//        CatEditor.putString("cattprice",caterer_price);
//        CatEditor.commit();
//
//
//        tvatc.setText(venue_names+"\n"+venue_prices);
//        catatc.setText(caterer_names+"\n"+caterer_price);



    }

}