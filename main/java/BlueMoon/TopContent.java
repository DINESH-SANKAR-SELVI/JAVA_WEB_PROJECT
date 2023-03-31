package BlueMoon;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.xml.parsers.*;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

@WebServlet("/TopContent")
public class TopContent extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		
		PrintWriter io = res.getWriter();
		//res.sendRedirect("QuizNotesInterFace.jsp");
		
		try {
			File file = new File("C:\\Users\\ddpro\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
			if(req.getParameter("dinesh1").isEmpty()) io.print("<html><body> work</body></html>");
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse("C:\\Users\\ddpro\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");			
			
			Node topicid = d.getElementsByTagName("TOPICID").item(0);
			Element topid = (Element) topicid;
			
			topid.setAttribute("id",req.getParameter("dinesh1"));
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
			
			String subid = d.getElementsByTagName("SUBJECTID").item(0).getAttributes().item(0).getTextContent();
			String topcid = d.getElementsByTagName("TOPICID").item(0).getAttributes().item(0).getTextContent();
			Node bachquizNode = d.getElementsByTagName("BATCHQUIZID").item(0);
			Element bachquizEle = (Element) bachquizNode;
			
			/*				DATA HAS SELECT IN DATABASE					*/
			PreparedStatement ps = con.prepareStatement("SELECT QuizSetId FROM BlueMoon.BatchQuiz WHERE SubjectId=? and TopicId=?");
			ps.setString(1, subid);
			ps.setString(2, topcid);
			ResultSet rs = ps.executeQuery();
			/*--------------------------------------------------------------*/
			
			List<String> givenList = new ArrayList<String>();
			
			io.print("<html><body>");
			while(rs.next()) {
				givenList.add(rs.getString(1));
			}
			
		    Random rand = new Random();
		    String BatchQuizid = givenList.get(rand.nextInt(givenList.size()));
		    
		    bachquizEle.setAttribute("id", BatchQuizid);
		    
		    //io.print(subid +" "+ topcid +" "+BatchQuizid+"</html></body>");
		    
			Writer writer = new FileWriter(file);
		    javax.xml.transform.Transformer transformer = javax.xml.transform.TransformerFactory.newInstance().newTransformer();

		    transformer.transform(new javax.xml.transform.dom.DOMSource(d), new javax.xml.transform.stream.StreamResult(writer));
		    writer.close();
		    res.sendRedirect("QuizCommit.jsp");
			//req.getParameter("dinesh1");
		}
		catch(Exception e) {
			res.sendRedirect("QuizNotesInterFace.jsp");
		}
	}
}