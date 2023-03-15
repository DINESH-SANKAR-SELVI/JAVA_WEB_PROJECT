package BlueMoon;

import java.io.*;
import java.sql.*;

import javax.xml.parsers.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ProfileContent{		
		
	public boolean WriterProfile() throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException, ClassNotFoundException, SQLException {
		
		File file = new File("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document d = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
		
		//String userid = d.getElementsByTagName("USERID").item(0).getAttributes().item(0).getTextContent();
		
		Node avatar = d.getElementsByTagName("USERID").item(0).getChildNodes().item(1);
		Node name = d.getElementsByTagName("USERID").item(0).getChildNodes().item(3);
		Node email = d.getElementsByTagName("USERID").item(0).getChildNodes().item(5);
		String id = d.getElementsByTagName("USERID").item(0).getAttributes().item(0).getTextContent();
		
		Node tot = d.getElementsByTagName("USERDETAIL").item(0).getChildNodes().item(1);
		Node avgcrt1 = d.getElementsByTagName("USERDETAIL").item(0).getChildNodes().item(3);
		Node avgwrg1 = d.getElementsByTagName("USERDETAIL").item(0).getChildNodes().item(5);
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
		
		PreparedStatement ps = con.prepareStatement("SELECT UserAvatar,UserName,UserEmail FROM BlueMoon.UserDetails WHERE UserId=?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			avatar.setTextContent(rs.getString(1));
			name.setTextContent(rs.getString(2));
			email.setTextContent(rs.getString(3));
		}
		
		try {
			
			int totatpt =0;
			float avgcrt =0 ,avgwrg = 0;
			
			PreparedStatement ps4 = con.prepareStatement("select count(*),avg(NumberOfCorrectAnswer),avg(NumberOfWrongAnswer) from bluemoon.userhistory INNER JOIN bluemoon.review ON bluemoon.userhistory.EventQuestionsId = bluemoon.review.EventQuestionsId where UserId = ?");
			
			ps4.setString(1, id);
			
			ResultSet rs4 = ps4.executeQuery();
			if(rs4.next()) {
				
				tot.setTextContent(String.valueOf(rs4.getInt(1)));
				avgcrt1.setTextContent(String.valueOf(rs4.getFloat(2)));
				avgwrg1.setTextContent(String.valueOf(rs4.getFloat(3)));
				
				totatpt = rs4.getInt(1);
				avgcrt = rs4.getFloat(2);
				avgwrg = rs4.getFloat(3);

			}
			
			PreparedStatement ps3 = con.prepareStatement("UPDATE blueMoon.UserPersonallogs set UserAverageCorrect =? ,UserAverageWrong=?,UserTotalAttempt=? where UserId=? ");
			
			ps3.setFloat(1, avgcrt);
			ps3.setFloat(2, avgwrg);
			ps3.setInt(3, totatpt);
			ps3.setString(4, id);

			int rs3 = ps3.executeUpdate();
			
			if(rs3 == 1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Node his = d.getElementsByTagName("History").item(0);
		
		if(his.hasChildNodes()){
		 for (Node child; (child = his.getFirstChild()) != null; his.removeChild(child));
		}
					
			PreparedStatement ps2 = con.prepareStatement("SELECT * FROM bluemoon.userhistory where Userid=? ");
			ps2.setString(1, id);
			
			ResultSet rs2 = ps2.executeQuery();
			
			while(rs2.next()) {
				
				Element usrno1 = d.createElement("UserSerialNumber");
				usrno1.setAttribute("value", rs2.getString(1));
				
				Element evname = d.createElement("EventName");
				evname.setTextContent(rs2.getString(3));
				
				Element evtopic = d.createElement("EventTopic");
				evtopic.setTextContent(rs2.getString(9));
				
				Element evattendate = d.createElement("EventAttendDate");
				evattendate.setTextContent(rs2.getString(4));
				
				Element evpoin = d.createElement("EventPoint");
				evpoin.setTextContent(rs2.getString(6));
				
				Element evquesid = d.createElement("EventQuestionsId");
				evquesid.setTextContent(rs2.getString(5));
				
				Element evskipquiz = d.createElement("SkipedQuiz");
				evskipquiz.setTextContent(rs2.getString(7));
				
				Element evAttenquiz = d.createElement("AttenedQuiz");
				evAttenquiz.setTextContent(rs2.getString(8));
				
				usrno1.appendChild(evname);
				usrno1.appendChild(evtopic);
				usrno1.appendChild(evattendate);
				usrno1.appendChild(evpoin);
				usrno1.appendChild(evquesid);
				usrno1.appendChild(evskipquiz);
				usrno1.appendChild(evAttenquiz);
				
				his.appendChild(usrno1);
				
		}		
		
		Writer writer = new FileWriter(file);
	    javax.xml.transform.Transformer transformer = javax.xml.transform.TransformerFactory.newInstance().newTransformer();

	    transformer.transform(new javax.xml.transform.dom.DOMSource(d), new javax.xml.transform.stream.StreamResult(writer));
	    writer.close();
		
	    return true;
	}
}
