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
					String q = String.valueOf(i);
					io.println("<h1>"+quiz.item(i).getAttributes().item(1).getTextContent()+" : "+req.getParameter(q)+"</h1>");
				}
			}
			
			res.sendRedirect("FeedbackQuiz.jsp");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		io.println("</body></html>");
		
		
	}
	

}
