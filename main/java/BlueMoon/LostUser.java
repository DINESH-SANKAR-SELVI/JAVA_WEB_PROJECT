package BlueMoon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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




@WebServlet("/LostUser")
public class LostUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, TransformerFactoryConfigurationError {
		
			doPost(req,res);
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
	try {
		DELETE key1 = new DELETE();
		for(int i=0;i<=2;i++)
			key1.DeletePage();
	
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		File file = new File("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
		Document d1 = db.parse(file);
		
		Element subid = (Element)d1.getElementsByTagName("SUBJECTID").item(0);
		Element topid = (Element)d1.getElementsByTagName("TOPICID").item(0);
		Element batchid = (Element)d1.getElementsByTagName("BATCHQUIZID").item(0);
		Element userid =(Element) d1.getElementsByTagName("USERID").item(0);
		Node username =d1.getElementsByTagName("UserName").item(0);
		Node userava =d1.getElementsByTagName("UserAvatar").item(0);
		Node useremai =d1.getElementsByTagName("UserEmail").item(0);
		
		subid.setAttribute("id", "");
		topid.setAttribute("id", "");
		batchid.setAttribute("id", "");
		userid.setAttribute("id", "");
		username.setTextContent("UserName");
		userava.setTextContent(" ");
		useremai.setTextContent(" ");
			
			
			Writer writer = new FileWriter(file);
		    javax.xml.transform.Transformer transformer = javax.xml.transform.TransformerFactory.newInstance().newTransformer();

		    transformer.transform(new javax.xml.transform.dom.DOMSource(d1), new javax.xml.transform.stream.StreamResult(writer));
		    writer.close();
			
			
			res.sendRedirect("LogInPage.jsp");
		} catch (ParserConfigurationException | SAXException | IOException | TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}
	}	
}
