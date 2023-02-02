package BlueMoon;

import java.sql.Date;
import java.time.LocalDate;

public class IdGenerator {
	
	String UserId = "" ,name="",pincode="",phno="",bhd="",doj="";
	
	public String UserId(String name,int pincode,long phno,Date bhd,Date doj) {
		
		this.name	 = new String(name).trim();
		this.pincode = Integer.toString(pincode).trim();
		this.phno	 = Long.toString(phno).trim();
		this.bhd	 = bhd.toString().trim();
		this.doj	 = doj.toString().trim();
		
		UserId = this.name.substring(0, 2) + this.pincode.substring(this.pincode.length()-2, this.pincode.length()) + this.phno.substring(this.phno.length()-2, this.phno.length()) + this.bhd.substring(this.bhd.length()-2, this.bhd.length()) + this.doj.substring(2,4) + this.doj.substring(5, 7) + this.doj.substring(8, 10);
		
		
		return UserId.toUpperCase();
	}	
}
