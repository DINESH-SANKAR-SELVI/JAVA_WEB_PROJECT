package BlueMoon;

import java.io.*;
import java.sql.*;

import javax.xml.parsers.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class MemberAccess {
	
	public boolean isMember() throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, SQLException {
		

        		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document d = db.parse("../eclipse-workspace/JAVA_WEB_PROJECT/main/webapp/xml/MemberDetails.xml");			
				
				String User = d.getElementsByTagName("USERID").item(0).getAttributes().item(0).getTextContent();	
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
				
				PreparedStatement ps = con.prepareStatement("select * from bluemoon.userdetails where bluemoon.userdetails.userid=?");
				ps.setString(1, User);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					return true;
				}
				else {
					return false;
				}
	}
}
