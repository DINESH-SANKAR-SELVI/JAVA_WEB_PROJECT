package BlueMoon;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
//import java.sql.Date;
//import java.time.Instant;
import java.time.*;

@WebServlet("/UserVerify")
public class UserVerify extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter io = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM userdetails WHERE UserEmail = ? AND UserPassword = ?");
			
			ps.setString(1,request.getParameter("UserName"));
			ps.setString(2,request.getParameter("UserPassword"));
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String id = rs.getString(1);
				Timestamp now = Timestamp.from(Instant.now());
				
					PreparedStatement ps1 = con.prepareStatement("INSERT INTO dailylog(UserId,LogInTimeStamp) VALUES(?,?)");
					ps1.setString(1, id);
					ps1.setTimestamp(2, now);
					
					Boolean rs1 = ps1.execute();
					
					if(!(rs1)) {
						
						
					/* Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
					*/
						try {
							
							int totatpt =0;
							float avgcrt =0 ,avgwrg = 0;
							
							PreparedStatement ps4 = con.prepareStatement("select count(*),avg(NumberOfCorrectAnswer),avg(NumberOfWrongAnswer) from bluemoon.userhistory INNER JOIN bluemoon.review ON bluemoon.userhistory.EventQuestionsId = bluemoon.review.EventQuestionsId where UserId = ?;");
							
							ps4.setString(1, id);
							
							ResultSet rs4 = ps4.executeQuery();
							if(rs4.next()) {
								
								totatpt = rs4.getInt(1);
								avgcrt = rs4.getFloat(2);
								avgwrg = rs4.getFloat(3);
							}
							
							io.print("<h1> update</h1>");
							PreparedStatement ps3 = con.prepareStatement("UPDATE blueMoon.UserPersonallogs set UserAverageCorrect =? ,UserAverageWrong=?,UserTotalAttempt=? where UserId=? ");
							
							ps3.setFloat(1, avgcrt);
							ps3.setFloat(2, avgwrg);
							ps3.setInt(3, totatpt);
							ps3.setString(4, id);

							int rs3 = ps3.executeUpdate();
							
							if(rs3 == 1) response.sendRedirect("BasePage.jsp");
							
							else {
								PreparedStatement ps2 = con.prepareStatement("insert into bluemoon.userpersonallogs values(?,?,?,?)");
								
								ps2.setString(1, id);
								ps2.setFloat(2, avgcrt);
								ps2.setFloat(3, avgwrg);
								ps2.setInt(4, totatpt);
								
								boolean rs2 = ps2.execute();
								
								if(!(rs2)) {					
									io.println("<html><body> WORK</body></html>");
									response.sendRedirect("BasePage.jsp");
								}
								else { io.println("<html><body> didn't insert </body></html>"); }
							}
								io.print("<h1> insert </h1>");
							}catch(Exception e) {
								e.printStackTrace();
							}
						//response.sendRedirect("BasePage.jsp");					
					}
					else {
						response.sendRedirect("LogInPage.jsp");
					}
				/* will replace the code to access xml to write */
				
			}
			else io.println("<html><body  style='background-image:linear-gradient(45deg,#02aabd,#00cdac);'><center><img width=100px height=100px alter=FAILED title=ISSUE src=image/failed.png /><br /><br /> SORRY..! MAY BE YOU MADE A MISTAKE SO YOU CAN  <a href=LogInPage.jsp >TRY AGAIN ...!</a></center></body></html>"); 
			
		}catch(Exception e){e.printStackTrace();}
	}
}
