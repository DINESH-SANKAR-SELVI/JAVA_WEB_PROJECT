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
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

@WebServlet("/SubContent")
public class SubContent extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		
		PrintWriter io = res.getWriter();
		//res.sendRedirect("QuizNotesInterFace.jsp");
		
		try {
			File file = new File("C:\\Users\\ddpro\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
			if(req.getParameter("dinesh").isEmpty()) io.print("<html><body> work</body></html>");
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse("C:\\Users\\ddpro\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");			
			
			Node subjectid = d.getElementsByTagName("SUBJECTID").item(0);
			
			Element subjid = (Element) subjectid;
			
			subjid.setAttribute("id",req.getParameter("dinesh"));
			
			//io.print("<html><body>"+req.getParameter("dinesh")+"</body></html>");
			
			Writer writer = new FileWriter(file);
		    javax.xml.transform.Transformer transformer = javax.xml.transform.TransformerFactory.newInstance().newTransformer();

		    transformer.transform(new javax.xml.transform.dom.DOMSource(d), new javax.xml.transform.stream.StreamResult(writer));
		    writer.close();

		    res.sendRedirect("QuizNotesInterFace.jsp");
		}
		catch(Exception e) {
			res.sendRedirect("QuizNotes.jsp");
		}
	}
}