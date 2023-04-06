package BlueMoon;


import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;


@WebServlet("/Report1")
public class Report1 extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException {
		doPost(req,res);
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		PrintWriter io = res.getWriter();
		
		try {
			io.print("<html><head><title>FeedBack Based Report</title><link type=\"png\" href=\"image/WebIcon.png\" rel=\"icon\" /></head><body><center>");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
			PreparedStatement ps = con.prepareStatement("Select bluemoon.feedback.UserId ,bluemoon.feedback.SubjectId, bluemoon.feedback.TopicId,bluemoon.batchquiz.BatchName ,bluemoon.feedback.Rating from bluemoon.feedback inner join bluemoon.batchquiz on bluemoon.feedback.SubjectId = bluemoon.batchquiz.SubjectId AND bluemoon.feedback.TopicId = bluemoon.batchquiz.TopicId AND bluemoon.feedback.QuizSetId = bluemoon.batchquiz.QuizSetId");
			
			ResultSet rs = ps.executeQuery();
			
			io.print("<h1>FeedBack</h1><hr />");
	
			io.print("<table style=\"border:1px solid black;padding:6px;text-align:center;\"><tr style=\"color:white;background-color:red; \"><th>UserId</th><th>UserName</th><th>EventName</th><th>TopicName</th><th>BatchName</th><th>Feedback</th></tr>");
			
			
			while(rs.next()){
				
				io.print("<tr style=\" background-color:green;color:white;\">");
				
				PreparedStatement ps1 = con.prepareStatement("select UserId,UserName from bluemoon.userdetails where UserId =?");
				ps1.setString(1, rs.getString(1));
				
				ResultSet rs1 = ps1.executeQuery();
				
				if(rs1.next()) {				
					io.print("<td style=\"padding:16px;margin:6px;\">"+rs1.getString(1)+"</td>");
					io.print("<td style=\"padding:16px;margin:6px;\">"+rs1.getString(2)+"</td>");
				}
				
				PreparedStatement ps2 = con.prepareStatement("select bluemoon.notes.SubjectName from bluemoon.notes where SubjectId=? ");
				ps2.setString(1, rs.getString(2));
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next())				
					io.print("<td style=\"padding:16px;margin:6px;\" >"+rs2.getString(1)+"</td>");
				
				
				PreparedStatement ps3 = con.prepareStatement("select bluemoon.topics.TopicName from bluemoon.topics where TopicId=? ");
				ps3.setString(1, rs.getString(3));
				
				ResultSet rs3 = ps3.executeQuery();
				
				if(rs3.next())				
					io.print("<td style=\"padding:16px;margin:6px;\">"+rs3.getString(1)+"</td>");
				
				io.print("<td style=\"padding:16px;margin:6px;\" >"+rs.getString(4)+"</td>");
				
				io.print("<td style=\"padding:16px;margin:6px;\" >"+rs.getString(5)+"</td></tr>");
			}
			io.print("</table><hr />");
			
			io.print("<button onclick=\"window.location.href='AdminFile.jsp' \">Back</button>");
					
			io.print("</center></body></html>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
