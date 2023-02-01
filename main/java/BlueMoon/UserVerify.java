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
				
				response.sendRedirect("UserPage.jsp");
			}
			else { io.println("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Document</title></head>");
				   io.println("<body style='position: absolute;top:40%;right:40%;background-color: rgba(255,0,0,0.4);'><h1 style='text-transform:uppercase;'>tryagain......!</h1><pre>      Click here<a style='text-decoration: none;' href='LogInPage.jsp' ><b> to LogIn</b></a></pre></body></html>");
			}
		}catch(Exception e){e.printStackTrace();}
	}

}
