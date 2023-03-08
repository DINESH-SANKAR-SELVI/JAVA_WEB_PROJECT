package BlueMoon;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@WebServlet("/Quiz")
public class Quiz extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
		
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		
		PrintWriter io = res.getWriter();
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\BACKEND_WORK\\main\\webapp\\xml\\UserNotes.xml");
			
			NodeList quiz = d.getElementsByTagName("QUIZS").item(0).getChildNodes();
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
			io.println("<html><body>");

			IdGenerator key = new IdGenerator();
			
			
			String UsrName = d.getElementsByTagName("USERID").item(0).getChildNodes().item(3).getTextContent();
			String SubjectName = d.getElementsByTagName("SUBJECTID").item(0).getTextContent();
			
			String EventQuizId = "";
			String SubjectId = d.getDocumentElement().getElementsByTagName("SUBJECTID").item(0).getAttributes().item(0).getTextContent();
			String TopicId = d.getDocumentElement().getElementsByTagName("TOPICID").item(0).getAttributes().item(0).getTextContent();
			String QuizSetId = d.getDocumentElement().getElementsByTagName("BATCHQUIZID").item(0).getAttributes().item(0).getTextContent();
			String QuizId = "" ;
			String UserOptionId = "";
			
			Date now = new Date();
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS"); 
			String now1 = format1.format(now);
		
			EventQuizId = key.BatchQuizId(UsrName ,SubjectName , now1);
			
			for(int i=1;i<quiz.getLength();i++) {
				if(!(i%2==0)) {
					String q = String.valueOf(i);
					
					QuizId = quiz.item(i).getAttributes().item(1).getTextContent();
					UserOptionId = req.getParameter(q);
					
					PreparedStatement ps = con.prepareStatement("INSERT INTO reviewQuestionAnswer values(?,?,?,?,?,?)");
					
					ps.setString(1, EventQuizId);
					ps.setString(2, SubjectId);
					ps.setString(3, TopicId);
					ps.setString(4, QuizSetId);
					ps.setString(5, QuizId);
					ps.setString(6, UserOptionId);
					
					
					io.println("<h3>"+EventQuizId + " : " +SubjectId +" : "+TopicId + " : " + QuizSetId +" : " +QuizId + " : "+ UserOptionId +"</h3>");
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//res.sendRedirect("FeedbackQuiz.jsp");
		
		io.println("</body></html>");
		
		
	}
	

}
