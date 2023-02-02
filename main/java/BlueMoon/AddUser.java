package BlueMoon;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		doPost(req,response);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter io = response.getWriter();
		
		try {

			String UserId 		= "";
			String UserAvatar 	= "BACKGROUND3.jpg".toUpperCase();
			String UserName 	= req.getParameter("UserName").toUpperCase();
			Date UserBhd 		= Date.valueOf(req.getParameter("UserBhd"));
			String UserGender 	= req.getParameter("UserGender").toUpperCase();
			long UserPh 		= Long.parseLong(req.getParameter("UserPh"));
			String UserEmail 	= req.getParameter("UserEmail");
			String UserQualifi 	= req.getParameter("UserQualifi").toUpperCase();
			int UserPinCode 	= Integer.parseInt(req.getParameter("UserPinCode"));
			String UserCity 	= req.getParameter("UserCity").toUpperCase();
			String UserArea 	= req.getParameter("UserArea").toUpperCase();
			String UserPassword = null;
			Date UserJoinDate 	= Date.valueOf(java.time.LocalDate.now());
			
			if(req.getParameter("UserPassword").equals(req.getParameter("USERFINALPASSWORD"))) UserPassword = req.getParameter("UserPassword");
			IdGenerator id = new IdGenerator();
			UserId = id.UserId(UserName,UserPinCode,UserPh,UserBhd,UserJoinDate);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
			PreparedStatement ps1 = con.prepareStatement("INSERT INTO userdetails VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			ps1.setString(1, UserId);
			ps1.setString(2, UserAvatar);
			ps1.setString(3, UserName);
			ps1.setDate(4, UserBhd);
			ps1.setString(5, UserGender);
			ps1.setLong(6, UserPh);
			ps1.setString(7, UserEmail);
			ps1.setString(8, UserQualifi);
			ps1.setInt(9, UserPinCode);
			ps1.setString(10, UserCity);
			ps1.setString(11, UserArea);
			ps1.setString(12, UserPassword);
			ps1.setDate(13, UserJoinDate);
			
			int rs = ps1.executeUpdate();

			if(rs == 1) io.println("<html><title>"+UserId+"</title><body style='background-image:linear-gradient(to top,#ADF7F2,#15AAFF);' ><center><img width=100px height=100px alt=successfull...! title=VERIFYED src=image/Success.png /><br /><h4>YOU ARE NOW A MEMBER OF BLUE MOON NOW YOU CAN  <a href=LogInPage.jsp style='color:red;'>LOGIN..!</a></h4></center></body></html>");
			
			/*<table border=3px> <tr><th>"+UserName+"</th><th>"+UserBhd+"</th><th>"+UserGender+"</th><th>"+UserPh+"</th><th>"+UserEmail+"</th><th>"+UserQualifi+"</th><th>"+UserPinCode+"</th><th>"+UserCity+"</th><th>"+UserArea+"</th><th>"+UserPassword+"</th> <th>"+ UserJoinDate+" </tr> </table> */
			
		}catch(Exception e) { io.println("<html><body  style='background-image:linear-gradient(45deg,#02aabd,#00cdac);'><center><img width=100px height=100px alter=FAILED title=ISSUE src=image/failed.png /><br /><br /> SORRY..! MAY BE YOU MADE A MISTAKE SO YOU CAN  <a href=SignInPage.jsp >TRY AGAIN ...!</a></center></body></html>"); e.printStackTrace(); }
		
		
	}

}
