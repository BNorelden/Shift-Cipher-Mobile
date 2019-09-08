package mainCCB;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class DeserializeDemo {
	
	static String globalS = "";
	static Date dandt;

	
	static void deserialFunc() {
		
		DandT e = null;
	     try {
	         FileInputStream fileIn = new FileInputStream("/Users/Bilal/Desktop/test3.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (DandT) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("DandT class not found");
	         c.printStackTrace();
	         return;
	      }
	      
	      System.out.println("Deserialized DandT...");
	      
	      System.out.print("Last Serialized Date and Time: ");
	      System.out.println(e.date14+"\n"); // yay got it to work since i saved it in employee as a string will check this tomorrow and work on comparing 8/21
	      globalS = e.date14;
	      System.out.println("and global s is "+globalS);

	      dandt = e.date13;
	      MobileCaeserCB.dwitht = dandt;
	      System.out.println("the dandt is " + dandt);
	   

		
	}

   public static void main(String [] args) {
   
	   Date test = new Date();
	      System.out.println(test);
	      
	      
	   
	   
	   deserialFunc();
	   
	   
	   
//      try {
//         FileInputStream fileIn = new FileInputStream("/Users/Bilal/Desktop/test3.ser");
//         ObjectInputStream in = new ObjectInputStream(fileIn);
//         e = (DandT) in.readObject();
//         in.close();
//         fileIn.close();
//      } catch (IOException i) {
//         i.printStackTrace();
//         return;
//      } catch (ClassNotFoundException c) {
//         System.out.println("DandT class not found");
//         c.printStackTrace();
//         return;
//      }
//      
//      System.out.println("Deserialized DandT...");
//      
//      System.out.print("Last Serialized Date and Time: ");
//      System.out.println(e.date14+"\n"); // yay got it to work since i saved it in employee as a string will check this tomorrow and work on comparing 8/21
//      
   }
}