package com.example.eventhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerInfo extends AppCompatActivity {

    DBHelper myDB;
    EditText edtname,edtphone;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        myDB = new DBHelper(this);

        edtname = (EditText) findViewById(R.id.user_edt);
        edtphone = (EditText) findViewById(R.id.phone_edt);
        btn_submit = (Button) findViewById(R.id.cus_btn);
        addData();
    }

    public void addData(){
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = myDB.insertData(edtname.getText().toString(),edtphone.getText().toString());
                if (isInserted=true){
                    Toast.makeText(CustomerInfo.this, "Application Submitted", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(CustomerInfo.this, "Fields are Empty", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}