package BlueMoon;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.xml.parsers.*;
import org.w3c.dom.*;

@WebServlet("/UserOnSite")
public class UserOnSite extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter io = response.getWriter();
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			File profile = new File("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
			Document doc  = db.parse(profile);
			doc.getDocumentElement().normalize();
			
			NodeList nodelist = doc.getElementsByTagName("PersonalDetails");
			
			for(int i=0 ; i<nodelist.getLength();++i) {
				Node node = nodelist.item(i);
				
				if(node.getNodeType() == node.ELEMENT_NODE) { Element telement = (Element) node; 
				
				io.print("<html><body>"+doc.getDocumentElement().getNodeName()+" "+node.getNodeName()+" "+telement.getElementsByTagName("UserId").item(0).getTextContent()+"</body></html>");
				}
	
			}
					
		}catch(Exception e) {io.print("<html><body>ERROR...!</body></html"); e.printStackTrace();}
	}
}
