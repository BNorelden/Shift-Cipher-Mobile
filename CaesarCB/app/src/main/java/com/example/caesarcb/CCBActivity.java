package com.example.caesarcb;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import mainCCB.DandT;
import mainCCB.DeserializeDemo;

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
    DandT it = null;
    static boolean checker = false;

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


        serMobileIn();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        if(sdf.format(d).compareTo(sdf.format(it.date13))>0) {

            tv.setText("Date1 is after Date2"+ it.date13.toString()); // replace the date with a  new date
            serMobileOut();
        }
            //        else if(date1.compareTo(date2)<0){
//            System.out.println("Date1 is before Date2");
//        }
        else{
            tv.setText("Date1 is equal to Date2"+it.date13.toString());
        }



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

                        CCB(); // RANDOM SHOULD BE CALLED ONCE A DAY NOT ON EVERY CLICK

                        encrption = ss;
                        tv.setText(encrption);
                        //etext.setText(it.date14);

                        break;

                }

            }
        });


    }


    void serMobileOut(){ // serializing
        DandT e = new DandT();

        try {
            FileOutputStream fos = this.openFileOutput("testSerMobile", Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(e);
            //os.writeObject(this);
            os.close();
            fos.close();
        } catch (IOException i) {
                    i.printStackTrace();
                }
    }

    void serMobileIn(){ // deserializing
       // DandT e = null;
        try{
        FileInputStream fis = this.openFileInput("testSerMobile");
        ObjectInputStream is = new ObjectInputStream(fis);
        //e = (DandT) is.readObject();
        it = (DandT) is.readObject();
        is.close();
        fis.close();
        } catch (IOException i){
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("DandT class not found");
            c.printStackTrace();
            return;
        }


    }

}



