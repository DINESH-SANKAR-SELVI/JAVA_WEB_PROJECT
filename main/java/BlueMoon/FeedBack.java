package BlueMoon;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

import javax.xml.parsers.*;
import org.w3c.dom.*;

@WebServlet("/FeedBack")
public class FeedBack extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		
		PrintWriter io = res.getWriter();
		try {
		DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = bdf.newDocumentBuilder();
		Document d1 = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\BACKEND_WORK\\main\\webapp\\xml\\UserNotes.xml");
		
		String id = d1.getDocumentElement().getElementsByTagName("USERID").item(0).getAttributes().item(0).getTextContent();
		String Subject = d1.getDocumentElement().getElementsByTagName("SUBJECTID").item(0).getAttributes().item(0).getTextContent();
		String Topic = d1.getDocumentElement().getElementsByTagName("TOPICID").item(0).getAttributes().item(0).getTextContent();
		String BatchQuiz = d1.getDocumentElement().getElementsByTagName("BATCHQUIZID").item(0).getAttributes().item(0).getTextContent();
		String s = req.getParameter("feedback");
		
		if(!(s.equals(""))) {
		
			int rate = Integer.parseInt(req.getParameter("feedback"));
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
				
				PreparedStatement ps1 = con.prepareStatement("UPDATE feedback set Rating = ? WHERE UserId= ? AND SubjectId= ? AND TopicId= ? AND QuizSetId =?");
				
				ps1.setInt(1, rate);
				ps1.setString(2, id);
				ps1.setString(3, Subject);
				ps1.setString(4, Topic);
				ps1.setString(5, BatchQuiz);
				
				int rs = ps1.executeUpdate();
		
				if(rs == 1) res.sendRedirect("profile.jsp");
				
				else res.sendRedirect("FeedbackQuiz.jsp");
				
				}catch(Exception e) {
				
					e.printStackTrace();
				}
		}
		else		
			res.sendRedirect("FeedbackQuiz.jsp");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
}
