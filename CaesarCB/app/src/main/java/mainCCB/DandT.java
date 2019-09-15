package mainCCB;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static mainCCB.MobileCaeserCB.numbers;
public class DandT implements java.io.Serializable {
	   /**
	 * 
	 */
	static ArrayList<Integer> numbers = MobileCaeserCB.numbers;
	public static final long serialVersionUID = -5939917944208896972L;
	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   
	public Date date13 = new Date(System.currentTimeMillis());
	public String date14 = formatter.format(date13);
	   

	  
//	   public void DnT() {
//		   System.out.println("Today's Date and Time: " + formatter.format(date13));
//	   }
	}
