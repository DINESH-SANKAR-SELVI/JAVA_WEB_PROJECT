package BlueMoon;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.util.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

@WebServlet("/Reviewer")
public class Reviewer extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		
		PrintWriter io = res.getWriter();
		
		//res.sendRedirect("ReviewQuiz.jsp");
		
		
		try {
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
			File file = new File("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
			
			Element SubId =(Element) d.getElementsByTagName("SUBJECTID").item(0); 
			Element TopId =(Element) d.getElementsByTagName("TOPICID").item(0);
			Element QSetId =(Element) d.getElementsByTagName("BATCHQUIZID").item(0);
			Node QuizIdNode = d.getElementsByTagName("QUIZS").item(0);
			
			String SubjectId ="" ,TopicId ="" ,QuizSetId ="";
			String[] QuizId = {"","",""} ,UserOptionId = {"","",""};
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
			
			String qsid =req.getParameter("DINESH");
			
			
			PreparedStatement ps1 = con.prepareStatement("select SubjectId,TopicId,QuizSetId from bluemoon.review where EventQuestionsId =?");
			ps1.setString(1, qsid);
			ResultSet rs1 = ps1.executeQuery();

			if(rs1.next()) {
				
				SubId.setAttribute("id", rs1.getString(1));
				TopId.setAttribute("id", rs1.getString(2));
				QSetId.setAttribute("id", rs1.getString(3));
				
				io.print("<html><body><h1>"+rs1.getString(1) +" "+rs1.getString(2) +" "+rs1.getString(3)+"</h1>");
				
				PreparedStatement ps = con.prepareStatement("SELECT QuizId,UserOptionId FROM bluemoon.userhistory inner join bluemoon.reviewquestionanswer on bluemoon.userhistory.EventQuestionsId =bluemoon.reviewquestionanswer.EventQuestionsId where bluemoon.userhistory.EventQuestionsId=?");
				ps.setString(1, qsid);
				ResultSet rs = ps.executeQuery();
				
				int i = 0;
				while(rs.next()) {
					QuizId[i] = rs.getString(1);
					UserOptionId[i] = rs.getString(2);
					
					io.print("<h3>"+QuizId[i]+" : "+UserOptionId[i]+"</h3>");
				i++;	
				}
				for(int j=0;j<=i;i++) {
					
					Element quizidnode =(Element) QuizIdNode.getChildNodes().item(j);
					
					quizidnode.setAttribute("quizid", QuizId[j]);
					quizidnode.setAttribute("optid", UserOptionId[j]);
					
				}
				
				Writer writer = new FileWriter(file);
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.transform(new DOMSource(d), new StreamResult(writer));
				res.sendRedirect("ReviewQuiz.jsp");
			}
			
			io.print("</body></html>");
			
			
		}catch(Exception e) {e.printStackTrace();}
		
		
	}

}
