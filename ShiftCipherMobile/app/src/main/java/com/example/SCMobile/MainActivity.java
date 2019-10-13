package com.example.SCMobile;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.caesarcb.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.bgen);

        b1.setOnClickListener(MainActivity.this);
        b2.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {
        Intent myIntent;
        switch (v.getId()) {
            case R.id.button:

                myIntent = new Intent(this, DetailsActivity.class);
                startActivity(myIntent);
                break;

            case R.id.bgen:
                myIntent = new Intent(this, CCBActivity.class);
                startActivity(myIntent);
                break;
        }
    }
}



