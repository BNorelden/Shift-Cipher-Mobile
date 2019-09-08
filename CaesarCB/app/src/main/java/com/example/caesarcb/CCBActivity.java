package com.example.caesarcb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import static mainCCB.MobileCaeserCB.CCB;
import static mainCCB.MobileCaeserCB.encrypt;
import static mainCCB.MobileCaeserCB.s;
import static mainCCB.MobileCaeserCB.ss;

public class CCBActivity extends AppCompatActivity {





    // FUTURE NOTES
// maybe make 2 buttons 1 to clear etext with an up arrow, and 1 for text view. also the etext size should \n and maybe expand



    TextView tv, tvdate,tvtime,tvshift; // do not initialize here u newb
    Button bgenerate;
    EditText etext;
    String encrption;

    //SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'Time: 'HH:mm:ss z");
    SimpleDateFormat formattert= new SimpleDateFormat("HH:mm:ss z");
    SimpleDateFormat formatterd= new SimpleDateFormat("yyyy-MM-dd");


    Date d = new Date(System.currentTimeMillis());
        //System.out.println("Today's Date and Time: " + formatter.format(date13));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ccb);

        tv = findViewById(R.id.tviewgen);
        tvtime = findViewById(R.id.tvTime);
        tvtime.setText(formattert.format(d));

        tvdate = findViewById(R.id.tvDate);
        tvdate.setText(formatterd.format(d));

        tvshift = findViewById(R.id.tvShift);
        //tvshift.setText("Current Shift: "+s);

        etext = findViewById(R.id.etext);
        bgenerate = findViewById(R.id.bgen);
        bgenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.bgen:

                        tvtime.setText(formattert.format(d));
                        tvdate.setText(formatterd.format(d));
                        tvshift.setText("Current Shift: "+s); // something is wrong here, numbers are wrong

                        ss = etext.getText().toString();
                        CCB();
                        encrption = ss;
                        tv.setText(encrption);

                        break;

                }

            }
        });


    }



}



