package com.example.SCMobile;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.caesarcb.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import mainCCB.DandT;


public class CCBActivity extends AppCompatActivity {
    private static final String TAG = "CALL DESERIALIZE ";


    // FUTURE NOTES
// maybe make 2 buttons 1 to clear etext with an up arrow, and 1 for text view. also the etext size should \n and maybe expand



    TextView tv, tvdate,tvtime,tvshift,tvshift2; // do not initialize here u newb
    Button bgenerate;
    EditText etext;
    String encryption;
    static DandT it;


    SimpleDateFormat formattert= new SimpleDateFormat("HH:mm:ss z");
    SimpleDateFormat formatterd= new SimpleDateFormat("yyyy-MM-dd");

    Date d = new Date(System.currentTimeMillis()); // stopped using to check Sys.curr alone if this was un-necessary

    public static int s;
    public static String ss = "";
    public static ArrayList<Integer> numbers = new ArrayList<Integer>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");


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
        tvshift2 = findViewById(R.id.tvShift2);
        etext = findViewById(R.id.etext);

        randy(); //now i have to call randy within the DandT function with the serialization of serMobileOut() **************************************DO FIRST*******
            serMobileOut(); // ser
//        if(it.statnum == null && numbers == null){
//            randy(); //now i have to call randy within the DandT function with the serialization of serMobileOut() **************************************DO FIRST*******
//            serMobileOut(); // ser
//        } Attempt to read from field 'java.util.ArrayList mainCCB.DandT.statnum' on a null object reference

        serMobileIn();      //deserialize

        if (numbers.size() == 0 && it.statnum.size() == 0) {
            randy(); //now i have to call randy within the DandT function with the serialization of serMobileOut() **************************************DO FIRST*******
            serMobileOut(); // ser
        }

        tv.setText(it.statnum.toString());  //TESTCASE#1
        //tv.setText(it.date13.toString()+" compared with "+d.toString()) //TESTCASE#2
        //tv.setText(sdf.format(d)+" is being compared with "+sdf.format(it.date13)); //TESTCASE#3
        if(sdf.format(System.currentTimeMillis()).compareTo(sdf.format(it.date13))>0) {

            randy();
            tv.setText("Date1 is after Date2 "+ it.statnum.toString()); // replace the date with a  new date
            serMobileOut();
            serMobileOut();
        }

        bgenerate = findViewById(R.id.bgen);
        bgenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.bgen:

                        if(sdf.format(System.currentTimeMillis()).compareTo(sdf.format(it.date13))>0) {
                            randy();
                            tv.setText("Date1 is after Date2 "+ it.statnum.toString()); // replace the date with a  new date
                            serMobileOut();
                            serMobileOut();

                        }else{
                            tv.setText("Date1 is equal to Date2: "+it.statnum.toString());
                        }

                        tvtime.setText(formattert.format(System.currentTimeMillis()));
                        tvdate.setText(formatterd.format(System.currentTimeMillis()));
                        tvshift.setText("Current Shift: "+s);
                        tvshift2.setText(it.statnum.toString());

                        ss = etext.getText().toString();

                        CCB();

                        encryption = ss;
                        tv.setText(encryption);
                        break;
                }
            }
        });
    }

    public static StringBuffer encrypt(String text, int s) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) + s - 65) % 26 + 65); // 26 representing the alphabet and 65 is
                // first letter A in ASCII TABLE
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) + s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        ss = result.toString();
        return result;
    }

    void serMobileOut(){ // serializing
        DandT e = new DandT();
        e.statnum = numbers;
        Log.d(TAG, "serMobileOut: curr values" + e.statnum.toString());
        try {
            FileOutputStream fos = this.openFileOutput("testSerMobile", Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(e);
            os.close();
            fos.close();
        } catch (IOException i) {
                    i.printStackTrace();
                }
    }

    void serMobileIn(){ // deserializing
        try{
        FileInputStream fis = this.openFileInput("testSerMobile");
        ObjectInputStream is = new ObjectInputStream(fis);
        it = (DandT) is.readObject();
        Log.d(TAG, "serMobileOut: curr values #2 " + it.statnum.toString());
        is.close();
        fis.close();
        } catch (IOException i){
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("DandT class not found");
            c.printStackTrace();

        }

    }

    public static void randy(){
            Random randomGenerator = new Random();
            while (numbers.size() < 4) {

                int random = randomGenerator.nextInt(26); // from 0-25
                if (!numbers.contains(random)) {
                    numbers.add(random);
                }
            }
        }

    public static void CCB() {


        Calendar cal = Calendar.getInstance();


        int curr = cal.get(Calendar.HOUR_OF_DAY); //cal.get(Calendar.HOUR_OF_DAY) 24 hrs format ------------ Calendar.HOUR_OF_DAY 12 hrs format


//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'Time: ' HH:mm:ss z");
//        Date date13 = new Date(System.currentTimeMillis());
//        //System.out.println("Today's Date and Time: " + formatter.format(date13));

/******************************************************CONDITION STATEMENT TO CHECK WHICH QUART WE CURRENTLY IN ****************************************/
        if(curr>=1 && curr<=6)
        {
            s = it.statnum.get(0);
            encrypt(ss, s);
        }
        else if(curr>=7 && curr<=12)
        {
            s = it.statnum.get(1);
            encrypt(ss, s);
        }
        else if(curr>=13 && curr<=18)
        {
            s = it.statnum.get(2);
            encrypt(ss, s);

        }
        else if(curr>=19 && curr<=23 || curr == 0 )
        {
            s = it.statnum.get(3);
            encrypt(ss, s);

        }
    }
}