package com.example.SCMobile;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.caesarcb.R;

import java.util.Timer;
import java.util.TimerTask;

public class DetailsActivity extends AppCompatActivity {

//TextView tt = findViewById(R.id.tView);
TextView  tv2; // do not initialize here u newb
Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tv2= findViewById(R.id.tView2);



        tv2.setVisibility(View.VISIBLE);
        //tv.setText("CHECK THIS OUT \n HOPE IT DON'T CRASH ON ME");

    }



}



