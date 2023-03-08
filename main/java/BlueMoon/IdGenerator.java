package BlueMoon;

import java.sql.*;
import java.time.*;

public class IdGenerator {
	
	String UserId = "" ,name="",pincode="",phno="",bhd="",doj="";
	
	String UserName = "", SubjectName = "" ,time = "";
	
	public String UserId(String name,int pincode,long phno,Date bhd,Date doj) {
		
		this.name	 = new String(name).trim();
		this.pincode = Integer.toString(pincode).trim();
		this.phno	 = Long.toString(phno).trim();
		this.bhd	 = bhd.toString().trim();
		this.doj	 = doj.toString().trim();
		
		UserId = this.name.substring(0, 2) + this.pincode.substring(this.pincode.length()-2, this.pincode.length()) + this.phno.substring(this.phno.length()-2, this.phno.length()) + this.bhd.substring(this.bhd.length()-2, this.bhd.length()) + this.doj.substring(2,4) + this.doj.substring(5, 7) + this.doj.substring(8, 10);
		
		
		return UserId.toUpperCase();
	}	
	
	public String BatchQuizId(String UsrName ,String SubName ,String curTimeStamp ) {
		
		this.UserName = UsrName.trim().substring(0,2);
		this.SubjectName = SubName.trim().substring(0,2);
		this.time = curTimeStamp.trim().substring(2,4).concat(curTimeStamp.substring(5,7)).concat(curTimeStamp.substring(8,10)).concat(curTimeStamp.substring(11,13)).concat(curTimeStamp.substring(14,16)).concat(curTimeStamp.substring(17,19));
		
		return this.UserName.concat(this.SubjectName).concat(this.time);
	}
}
