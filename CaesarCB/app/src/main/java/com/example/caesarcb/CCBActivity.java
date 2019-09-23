package com.example.caesarcb;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    public static boolean checker = true;
    public static ArrayList<Integer> numby = new ArrayList<Integer>();


    SimpleDateFormat formattert= new SimpleDateFormat("HH:mm:ss z");
    SimpleDateFormat formatterd= new SimpleDateFormat("yyyy-MM-dd");


    Date d = new Date(System.currentTimeMillis());

    public static int s;
    public static String ss = "";
    static Date dwitht; //= DeserializeDemo.dandt
    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
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


        /*
        I WILL JUST REDO THE WHOLE LOGIC THING
        FIRST CHECK IF SOMETHING WAS SERIALIZED, IF NOT CALL RANDOM NUMS

        for now the bool only works with true will commit just to be safe

        ONLY USING DandT and CCB ACTIVITY SO FAR

         */



        bgenerate = findViewById(R.id.bgen);
        bgenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.bgen:
                        serMobileIn(); //deserial

                        if(sdf.format(d).compareTo(sdf.format(it.date13))>0) {
                            checker = true;
                            tv.setText("Date1 is after Date2"+ it.date13.toString()); // replace the date with a  new date
                            serMobileOut();
                        }else{
                            tv.setText("Date1 is equal to Date2"+it.date13.toString());
                            numbers = numby;
                        }

                        tvtime.setText(formattert.format(d));
                        tvdate.setText(formatterd.format(d));
                        tvshift.setText("Current Shift: "+s); // something is wrong here, numbers are wrong
                        tvshift2.setText(numby.toString());// this isnt working for some reason


                        ss = etext.getText().toString();

                        CCB(); // RANDOM SHOULD BE CALLED ONCE A DAY NOT ON EVERY CLICK

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
        //e = (DandT) is.readObject();
        it = (DandT) is.readObject();
        numby = (ArrayList) is.readObject();;

        is.close();
        fis.close();
        } catch (IOException i){
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("DandT class not found");
            c.printStackTrace();

        }

    }


    public static void CCB() {
        /*
         * *******************************************************************************************
         * WILL HAVE TO RENAME NUMBERS TO 2 DIFFERENT VARS 1 FROM DANDT and other for generator
         *  */
        // going to have to check date here, first save then compare and if state redo random else use same 1
        // have to check mobile serialization first
        // have to work on this RANDOM WITH CCB. TELL IT to check the checker, if its a different date generate, else use old ones

        // much cleaner
        // will have to auto run this everyday from here

        if(checker == true) {
            Random randomGenerator = new Random();
            while (numbers.size() < 4) {

                int random = randomGenerator.nextInt(26); // from 0-25
                if (!numbers.contains(random)) {
                    numbers.add(random);
                }
            }    //System.out.println(numbers);
            checker = false;
        }else{
            numbers = numby;
        }



//            Random randomGenerator = new Random();
//            while (numbers.size() < 4) {
//
//                int random = randomGenerator.nextInt(26); // from 0-25
//                if (!numbers.contains(random)) {
//                    numbers.add(random);
//                }
//            }    //System.out.println(numbers);


        Calendar cal = Calendar.getInstance();
        //cal.get(Calendar.HOUR); //cal.getTime() //12 hr format

        int curr = cal.get(Calendar.HOUR_OF_DAY); //cal.get(Calendar.HOUR_OF_DAY) 24 hrs format ------------ Calendar.HOUR_OF_DAY 12 hrs format
        //System.out.println("curr is : "+ curr);

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'Time: ' HH:mm:ss z");
        Date date13 = new Date(System.currentTimeMillis());
        //System.out.println("Today's Date and Time: " + formatter.format(date13));

/******************************************************CONDITION STATEMENT TO CHECK WHICH QUART WE CURRENTLY IN ****************************************/
        if(curr>=1 && curr<=6)
        {
            //Index: 0, Size: 0 GODSSSSSSSSSSSSSSSSSSSSSS maybe try to save it again
            s = numbers.get(0);  //here i had local variables s, but i just created a main static one above to use it in all of them.
            encrypt(ss, s);
// 	    	System.out.println("The 1st quarter");
// 	    	System.out.println("Cipher Q1 with shift "+ s +": " + encrypt(ss, s));
        }

        else if(curr>=7 && curr<=12)
        {
            s = numbers.get(1);
            encrypt(ss, s);
//            System.out.println("The 2nd quarter");
// 	   System.out.println("Cipher Q2 with shift "+ s +": " + encrypt(ss, s));
        }

        else if(curr>=13 && curr<=18)
        {
            s = numbers.get(2);
            encrypt(ss, s);
//            System.out.println("The 3rd quarter");
// 	   System.out.println("Cipher Q3 with shift "+ s +": " + encrypt(ss, s));
        }

        else if(curr>=19 && curr<=23 || curr == 0 )
        {
            s = numbers.get(3);
            encrypt(ss, s);
//            System.out.println("The 4th quarter");
// 	   System.out.println("Cipher Q4 with shift "+ s +": " + encrypt(ss, s));
        }

    }


}

