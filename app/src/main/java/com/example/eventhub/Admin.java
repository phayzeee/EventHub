package com.example.eventhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

    EditText admin,pass;
    Button loginbtn;
    String user = "admin";
    String password = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        admin = (EditText) findViewById(R.id.admin_edt);
        pass = (EditText) findViewById(R.id.pass_edt);
        loginbtn = (Button)findViewById(R.id.login_btn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(admin.getText().toString().equals(user) && pass.getText().toString().equals(password)){
                    Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Admin.this, AdminView.class);
                    startActivity(intent);
                }
                else if(TextUtils.isEmpty(admin.getText().toString()) || TextUtils.isEmpty(pass.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Empty fields", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Invalid Username/Password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}