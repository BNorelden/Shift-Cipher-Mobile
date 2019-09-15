package mainCCB;

import android.content.Context;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class JavaSerialize {

   public static void main(String [] args) {
      DandT e = new DandT();
     // imma just replace employee and refactor



      try {

         FileOutputStream fileOut =
         new FileOutputStream("/Users/Bilal/Desktop/test3.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in /Users/Bilal/Desktop/test3.ser");
      } catch (IOException i) {
         i.printStackTrace();
      }
   }
}
