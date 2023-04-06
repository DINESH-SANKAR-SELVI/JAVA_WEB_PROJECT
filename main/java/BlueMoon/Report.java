package BlueMoon;


import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;


@WebServlet("/Report")
public class Report extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException {
		doPost(req,res);
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		PrintWriter io = res.getWriter();
		
		try {
			io.print("<html><head><title>SubjectBasedReport</title><link type=\"png\" href=\"image/WebIcon.png\" rel=\"icon\" /></head><body><center>");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
			
			
			String SubName = (String)req.getParameter("SubName").toUpperCase();
			
			PreparedStatement ps = con.prepareStatement("SELECT UserName,EventName,TopicName,EventAttendDate FROM bluemoon.userhistory inner join bluemoon.userdetails on bluemoon.userhistory.UserId = bluemoon.userdetails.UserId WHERE EventName =? ORDER BY EventAttendDate DESC ");
			
			ps.setString(1, SubName);
			
			ResultSet rs = ps.executeQuery();
			
			io.print("<p style=\" font-size:22px;\">"+SubName+"</p><hr />");
			
			io.print("<table style=\"border:1px solid black;padding:6px;text-align:center;\"><tr style=\"color:white;background-color:red; \"><th>UserName</th><th>EventName</th><th>TopicName</th><th>EventAttendDate</th></tr>");
			
			
			while(rs.next()){
				
				io.print("<tr style=\" background-color:green;color:white;\"><td style=\"padding:16px;margin:6px;\">"+rs.getString(1)+"</td>");
				io.print("<td style=\"padding:16px;margin:6px;\" >"+rs.getString(2)+"</td>");
				io.print("<td style=\"padding:16px;margin:6px;\">"+rs.getString(3)+"</td>");
				io.print("<td style=\"padding:16px;margin:6px;\" >"+rs.getString(4)+"</td></tr>");
			}
			
			io.print("</table><hr />");
			
			io.print("<button onclick=\"window.location.href='AdminFile.jsp' \">Back</button>");
					
			io.print("</center></body></html>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
