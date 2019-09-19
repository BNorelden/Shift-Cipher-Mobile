package mainCCB;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;

import static com.example.caesarcb.CCBActivity.checker;
import static com.example.caesarcb.CCBActivity.numby;
import static mainCCB.DandT.numb;

public class MobileCaeserCB  {

	public static int s;
	public static String ss = "";
	String t = DeserializeDemo.globalS;
	static Date dwitht; //= DeserializeDemo.dandt
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	static ArrayList<Integer> numbers = new ArrayList<Integer>();


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
	
	
	public static Date dateCompare(Date  d1, Date d2) {
		//String t = DeserializeDemo.globalS;
		 //e.date14;
		 long l1 = d1.getTime();
		 long l2 = d2.getTime();
		
		 if (l1 > l2) {
			 System.out.println("I m the first date");
			 return d1;
		 }
		 else {
			 System.out.println("I m the second date");
			 return d2;
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
		}
        
    	//System.out.print(numbers.get(0)+" "+ numbers.get(1)+"\n");
   
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
 	        s = numby.get(0);  //here i had local variables s, but i just created a main static one above to use it in all of them.
            encrypt(ss, s);
// 	    	System.out.println("The 1st quarter");
// 	    	System.out.println("Cipher Q1 with shift "+ s +": " + encrypt(ss, s));
 	    }
 	    
        else if(curr>=7 && curr<=12)
 	    {
 	        s = numby.get(1);
            encrypt(ss, s);
//            System.out.println("The 2nd quarter");
// 	   System.out.println("Cipher Q2 with shift "+ s +": " + encrypt(ss, s));
 	    }
 	    
 	   else if(curr>=13 && curr<=18)
 	    {
 	        s = numby.get(2);
            encrypt(ss, s);
//            System.out.println("The 3rd quarter");
// 	   System.out.println("Cipher Q3 with shift "+ s +": " + encrypt(ss, s));
 	    }
 	    
 	  else if(curr>=19 && curr<=23 || curr == 0 )
 	    {
 	        s = numby.get(3);
            encrypt(ss, s);
//            System.out.println("The 4th quarter");
// 	   System.out.println("Cipher Q4 with shift "+ s +": " + encrypt(ss, s));
 	    }
		
	}

	public static void main(String[] args) throws IOException {

	//System.out.println(dwitht);  // This is null, guess have to try to keep it running in 1 file for
		
		Scanner fileScanner = new Scanner(System.in);
		outer:
		while (fileScanner.hasNextLine()) {
		  String line = fileScanner.nextLine();

		  Scanner lineScanner = new Scanner(line);
		  
		  while (lineScanner.hasNext()) {
		    String token = lineScanner.next();
		    // do whatever needs to be done with token
		    ss += token;
		    if (token.equals("~")) {
		    	break outer;
		    	
            }
		  }
		  lineScanner.close();
		  // you're at the end of the line here. Do what you have to do.
		}
		fileScanner.close();
		
	
		CCB();
		
	}

}
