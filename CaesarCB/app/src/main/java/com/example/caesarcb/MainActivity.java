package com.example.caesarcb;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView tv, tv2; // do not initialize here u newb
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.bgen);

        b1.setOnClickListener(MainActivity.this);
        b2.setOnClickListener(MainActivity.this);


        tv= findViewById(R.id.tView);
        tv2= findViewById(R.id.tView2);
        tv.setText("");

        setText(" W E L C O M E ");
        tv2.setVisibility(View.VISIBLE);


    }

    public void setText(final String s)
    {

        final int[] i = new int[1];
        i[0] = 0;
        final int length = s.length();
        final Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                char c= s.charAt(i[0]);
                Log.d("Strange",""+c);
                tv.append(String.valueOf(c));
                i[0]++;
            }
        };

        final Timer timer = new Timer();
        TimerTask taskEverySplitSecond = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
                if (i[0] == length - 1) {
                    timer.cancel();
                }
            }
        };
        timer.schedule(taskEverySplitSecond, 1, 500);
    }

    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
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



