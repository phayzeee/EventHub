package com.example.eventhub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Splashscreen extends AppCompatActivity {

    TextView textView;
    String fname,sname;
    private final int SPLASH_DISPLAY_LENGTH = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Hide Notification Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        //SplashScreen
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splashscreen.this,Login.class);
                Splashscreen.this.startActivity(mainIntent);
                Splashscreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);


        //Initialization
        TextView textView = (TextView) findViewById(R.id.first_txt);
        String name = getColoredSpanned("Event", "#ffffff");
        String sname = getColoredSpanned("Hub","#F7AEF8");
        textView.setText(Html.fromHtml(name+""+sname));
    }
    //Color Change in Text
    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }
}