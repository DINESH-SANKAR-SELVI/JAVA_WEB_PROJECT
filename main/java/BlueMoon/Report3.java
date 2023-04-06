package BlueMoon;


import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;


@WebServlet("/Report3")
public class Report3 extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException {
		doPost(req,res);
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		PrintWriter io = res.getWriter();
		
		try {
			io.print("<html><head><title>dinesh</title></head><body><center>");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
			
			
			String TimeSrt = (String)req.getParameter("Timesrt");
			
			String TimeStp = (String)req.getParameter("TimeStp");
			
			PreparedStatement ps = con.prepareStatement("SELECT UserId,EventName,TopicName,EventAttendDate FROM bluemoon.userhistory where EventAttendDate between ? and ? order by EventAttendDate desc");			
			ps.setString(1, TimeSrt);
			ps.setString(2, TimeStp);
			
			ResultSet rs = ps.executeQuery();
			
			io.print("<h1>"+TimeSrt+" TO "+TimeStp+"</h1><hr />");
			
			io.print("<table style=\"border:1px solid black;padding:6px;text-align:center;\"><tr style=\"color:white;background-color:red; \"><th>UserId</th><th>UserName</th><th>SubjectName</th><th>TopicName</th><th>AttenedTime</th></tr>");
			
			
			while(rs.next()){
				
				io.print("<tr style=\" background-color:green;color:white;\"><td style=\"padding:16px;margin:6px;\">"+rs.getString(1)+"</td>");
				
				PreparedStatement ps2 = con.prepareStatement("Select UserName from bluemoon.UserDetails Where bluemoon.userdetails.UserId =? ");
				ps2.setString(1, rs.getString(1));
				
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next())
					io.print("<td style=\"padding:16px;margin:6px;\" >"+rs2.getString(1)+"</td>");
				
				io.print("<td style=\"padding:16px;margin:6px;\">"+rs.getString(2)+"</td>");
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
