package com.example.eventhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdminView extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6;
    SharedPreferences a,b,c,d;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);
        myDB = new DBHelper(this);

        t1 = (TextView) findViewById(R.id.fname_db);
        t2 = (TextView) findViewById(R.id.pno_db);
        t3 = (TextView) findViewById(R.id.vn_db);
        t4 = (TextView) findViewById(R.id.cat_db);
        t5 = (TextView) findViewById(R.id.dec_db);
        t6 = (TextView) findViewById(R.id.pto_db);

        a = getApplicationContext().getSharedPreferences("VenuePrefs", Context.MODE_PRIVATE);
        String vname = a.getString("venname", "");
        t3.setText(vname);

        b = getApplicationContext().getSharedPreferences("CatPrefs", Context.MODE_PRIVATE);
        String cname = b.getString("cattname", "");
        t4.setText(cname);

        c = getApplicationContext().getSharedPreferences("DecPrefs", Context.MODE_PRIVATE);
        String dname = c.getString("decname", "");
        t5.setText(dname);

        d = getApplicationContext().getSharedPreferences("PhotoPrefs", Context.MODE_PRIVATE);
        String pname = d.getString("photoname", "");
        t6.setText(pname);

        Cursor res = myDB.getData();
        StringBuilder stringBuildera = new StringBuilder();
        StringBuilder stringBuilderb = new StringBuilder();
        while (res.moveToNext()) {
            stringBuildera.append(" " + res.getString(0) + "\n");
            stringBuilderb.append("" + res.getString(1) + "\n");
            t1.setText(stringBuildera);
            t2.setText(stringBuilderb);

        /*viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                }
            }
        });*/

        }
    }
}