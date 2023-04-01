package BlueMoon;


import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;


@WebServlet("/Report2")
public class Report2 extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException {
		doPost(req,res);
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		PrintWriter io = res.getWriter();
		
		try {
			io.print("<html><head><title>LogIn Details</title></head><body><center>");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
			
			PreparedStatement ps = con.prepareStatement("SELECT bluemoon.dailylog.UserId,UserName,LogInTimeStamp FROM bluemoon.dailylog inner join bluemoon.userdetails on bluemoon.dailylog.UserId = bluemoon.userdetails.UserId order by SerialNumber desc");
			ResultSet rs = ps.executeQuery();
			
			io.print("<h1>LogIn History</h1><hr />");
			
			io.print("<table style=\"border:1px solid black;padding:6px;text-align:center;\"><tr style=\"color:white;background-color:red; \"><th>USERID</th><th>USERNAME</th><th>TIMESTAMP</th></tr>");
			
			
			while(rs.next()){
				
				io.print("<tr style=\" background-color:green;color:white;\"><td style=\"padding:16px;margin:6px;\">"+rs.getString(1)+"</td>");
				io.print("<td style=\"padding:16px;margin:6px;\" >"+rs.getString(2)+"</td>");
				io.print("<td style=\"padding:16px;margin:6px;\">"+rs.getString(3)+"</td></tr>");
			}
			io.print("</table></center></body></html>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
