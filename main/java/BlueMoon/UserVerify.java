package BlueMoon;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

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
				response.sendRedirect("BasePage.jsp");
			}
			else io.println("<html><body  style='background-image:linear-gradient(45deg,#02aabd,#00cdac);'><center><img width=100px height=100px alter=FAILED title=ISSUE src=image/failed.png /><br /><br /> SORRY..! MAY BE YOU MADE A MISTAKE SO YOU CAN  <a href=LogInPage.jsp >TRY AGAIN ...!</a></center></body></html>"); 
			
		}catch(Exception e){e.printStackTrace();}
	}
}
