package BlueMoon;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;

import javax.xml.parsers.*;
import org.w3c.dom.*;


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
			Document d = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
			
			NodeList quiz = d.getElementsByTagName("QUIZS").item(0).getChildNodes();
			
			io.println("<html><body>");
			
			for(int i=1;i<quiz.getLength();i++) {
				if(!(i%2==0)) { 
					io.println("<h1>"+quiz.item(i).getAttributes().item(0).getTextContent()+"</h1>");
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		io.println("<h1>"+req.getParameter("1")+"</h1>");
		io.println("<h1>"+req.getParameter("3")+"</h1>");
		io.println("<h1>"+req.getParameter("5")+"</h1>");
		
		io.println("</body></html>");
		
		
	}
	

}
