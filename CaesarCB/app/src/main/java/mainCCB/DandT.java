package mainCCB;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DandT implements java.io.Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = -5939917944208896972L;
	   SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   
	   Date date13 = new Date(System.currentTimeMillis());
	   String date14 = formatter.format(date13);
	   

	  
//	   public void DnT() {
//		   System.out.println("Today's Date and Time: " + formatter.format(date13));
//	   }
	}
