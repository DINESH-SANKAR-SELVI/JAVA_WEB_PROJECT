package BlueMoon;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.sql.*;


public class BlueMoonSyllabus {
	
	public boolean BlueMoonSyllabus1() {
	try {
	    File file = new File("C:\\Users\\ddpro\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\ContentQuiz.xml");
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.parse(file);
	    
	    Element dineshnode = (Element) document.getElementsByTagName("NOTES").item(0);
	    
	    Node sub = document.getDocumentElement();
	    if(sub.hasChildNodes()){
			 for (Node child; (child = sub.getFirstChild()) != null; sub.removeChild(child));
			}
	   	    
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
	    
	    PreparedStatement ps = con.prepareStatement("SELECT * FROM bluemoon.notes");
	    
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next()) {
	    	System.out.println(rs.getString(1));
	    	
	    	Element subject = (Element) document.createElement("SUBJECT");
	    	subject.setAttribute("id", rs.getString(1));
	    	
	    	Element subjectName = (Element) document.createElement("SUBJECT_NAME");
	    	subjectName.setTextContent(rs.getString(2));
	    	
	    	Element subjectAbout = (Element) document.createElement("SUBJECT_ABOUT");
	    	subjectAbout.setTextContent(rs.getString(3));
	    	
	    	Element subjectTopics = (Element) document.createElement("TOPICS");
	    	
	    	
	    	PreparedStatement ps2 = con.prepareStatement("SELECT * FROM BlueMoon.topics Where BlueMoon.topics.SubjectId=?");
	    	ps2.setString(1, rs.getString(1));
	    	ResultSet rs2 = ps2.executeQuery();
	    	
	    	while(rs2.next()) {
	    		System.out.println(" "+rs2.getString(2));
	    		
	    		Element subjectTopic = (Element) document.createElement("TOPIC");
	    		subjectTopic.setAttribute("id", rs2.getString(2));
	    		
	    		Element subjectTopicName = (Element) document.createElement("TOPIC_NAME");
	    		subjectTopicName.setTextContent(rs2.getString(3));
	    		
	    		subjectTopic.appendChild(subjectTopicName);

	    		PreparedStatement ps3 = con.prepareStatement("SELECT * FROM BlueMoon.BatchQuiz WHERE BlueMoon.batchquiz.SubjectId = ? AND BlueMoon.batchquiz.TopicId =?");
	    		ps3.setString(1, rs.getString(1));
	    		ps3.setString(2, rs2.getString(2));
	    		ResultSet rs3 = ps3.executeQuery();
	    		
	    		while(rs3.next()) {
	    		System.out.println(" "+rs3.getString(3));
	    		
	    		Element subjectTopicBatch = (Element) document.createElement("BATCH");
	    		subjectTopicBatch.setAttribute("id", rs3.getString(3));
	    		
	    		PreparedStatement ps4 = con.prepareStatement("SELECT * FROM BlueMoon.question WHERE BlueMoon.question.SubjectId = ? AND BlueMoon.question.TopicId =? AND BlueMoon.question.QuizSetId=?");
		    		ps4.setString(1, rs.getString(1));
		    		ps4.setString(2, rs2.getString(2));
		    		ps4.setString(3, rs3.getString(3));
		    		ResultSet rs4 = ps4.executeQuery();
		    		
		    		while(rs4.next()) {
		    			System.out.println(" "+rs4.getString(4));
		    			
		    			PreparedStatement ps5 = con.prepareStatement("SELECT * FROM BlueMoon.options WHERE BlueMoon.options.SubjectId = ? AND BlueMoon.options.TopicId = ? AND BlueMoon.options.QuizSetId=? AND bluemoon.options.QuizId =?");
		    			
		    			ps5.setString(1, rs.getString(1));
			    		ps5.setString(2, rs2.getString(2));
			    		ps5.setString(3, rs3.getString(3));
			    		ps5.setString(4, rs4.getString(4));
			    		ResultSet rs5 = ps5.executeQuery();
			    		
			    		Element subjectTopicBatchQuizid = (Element) document.createElement("QUIZ");
			    		subjectTopicBatchQuizid.setAttribute("id", rs4.getString(4));
			    		subjectTopicBatchQuizid.setAttribute("POINTS", rs4.getString(6));
			    		
			    		Element subjectTopicBatchQuizcontent = (Element) document.createElement("QUIZCONTENT");
			    		subjectTopicBatchQuizcontent.setTextContent(rs4.getString(5));
			    		
			    		Element subjectTopicBatchQuizcontentOptions = (Element) document.createElement("OPTIONS");
			    		
			    	while(rs5.next()) {
			    		
			    		Element subjectTopicBatchQuizcontentOption = (Element) document.createElement("OPT");
			    		subjectTopicBatchQuizcontentOption.setAttribute("id", rs5.getString(5));
			    		subjectTopicBatchQuizcontentOption.setAttribute("ans", rs5.getString(7));
			    		subjectTopicBatchQuizcontentOption.setTextContent(rs5.getString(6));
			    			
			    		subjectTopicBatchQuizcontentOptions.appendChild(subjectTopicBatchQuizcontentOption);
			    			
			    			System.out.println(" "+rs5.getString(5));	
			    		}
			    		subjectTopicBatchQuizid.appendChild(subjectTopicBatchQuizcontent);
			    		subjectTopicBatchQuizid.appendChild(subjectTopicBatchQuizcontentOptions);
			    		
			    		subjectTopicBatch.appendChild(subjectTopicBatchQuizid);
		    		}
	    		subjectTopic.appendChild(subjectTopicBatch);
	    		}
	    		subjectTopics.appendChild(subjectTopic);
	    		
	    	}
	    	System.out.println("\n");
	    	subject.appendChild(subjectName);
	    	subject.appendChild(subjectAbout);
	    	subject.appendChild(subjectTopics);
	    	
	    	dineshnode.appendChild(subject);
	    	
	    }
 /*<?xml version="1.0" encoding="UTF-8" ?><NOTES><SUBJECT id="JAVA1995230122"><SUBJECT_NAME>JAVA</SUBJECT_NAME><SUBJECT_ABOUT>Java is a programming language and computing platform first released by Sun Microsystems in 1995.</SUBJECT_ABOUT><TOPICS><TOPIC id="JAVAOOPS132218"><TOPIC_NAME>OOPS</TOPIC_NAME><BATCH id="JAVAOOPSSETFIR" ><QUIZ id="JAOOSETFIRST01" POINTS="02"><QUIZCONTENT>Which of the following Is not oops concept in Java ?</QUIZCONTENT><OPTIONS><OPT id="JAOOSETFIR01O1" ans="0">Inheritance</OPT><OPT id="JAOOSETFIR01O2" ans="1">Encapsulation</OPT><OPT id="JAOOSETFIR01O3" ans="0">Polymorphism</OPT><OPT id="JAOOSETFIR01O4" ans="0">Compilation</OPT></OPTIONS></QUIZ><QUIZ id ="JAOOSETFIRST02" POINTS="02"><QUIZCONTENT>Which of the following is a type of polymorphism in Java?</QUIZCONTENT><OPTIONS><OPT id ="JAOOSETFIR02O1" ans="0">Compile time polymorphism</OPT><OPT id ="JAOOSETFIR02O2" ans="0">Execution time polymorphism</OPT><OPT id ="JAOOSETFIR02O3" ans="0">Multiple polymorphism</OPT><OPT id ="JAOOSETFIR02O4" ans="1">Multilevel polymorphism</OPT></OPTIONS>	</QUIZ><QUIZ id ="JAOOSETFIRST03" POINTS="02"><QUIZCONTENT>When does method overloading is determined?</QUIZCONTENT><OPTIONS><OPT id ="JAOOSETFIR03O1" ans="0">At run time</OPT><OPT id ="JAOOSETFIR03O2" ans="0">At compile time</OPT><OPT id ="JAOOSETFIR03O3" ans="1">At coding time</OPT><OPT id ="JAOOSETFIR03O4" ans="0">At execution time</OPT></OPTIONS></QUIZ></BATCH><BATCH id="JAVAOOPSSETSEC"><QUIZ id ="JAOOSETSECON01" POINTS="02"><QUIZCONTENT>When Overloading does not occur?</QUIZCONTENT><OPTIONS><OPT id ="JAOOSETSEC01O1" ans="0">More than one method with same name but different method signature and different number or type of parameters</OPT><OPT id ="JAOOSETSEC01O2" ans="0">More than one method with same name, same signature but different number of signature</OPT><OPT id ="JAOOSETSEC01O3" ans="1">More than one method with same name, same signature, same number of parameters but different type</OPT><OPT id ="JAOOSETSEC01O4" ans="0">More than one method with same name, same number of parameters and type but different signature</OPT></OPTIONS></QUIZ><QUIZ id ="JAOOSETSECON02" POINTS="02"><QUIZCONTENT>Which concept of Java is a way of converting real world objects in terms of class?</QUIZCONTENT><OPTIONS><OPT id ="JAOOSETSEC02O1" ans="0">Polymorphism</OPT><OPT id ="JAOOSETSEC02O2" ans="0">Encapsulation</OPT><OPT id ="JAOOSETSEC02O3" ans="0">Abstraction</OPT><OPT id ="JAOOSETSEC02O4" ans="1">Inheritance</OPT></OPTIONS></QUIZ><QUIZ id ="JAOOSETSECON03" POINTS="02"><QUIZCONTENT>Which concept of Java is achieved by combining methods and attribute into a class?</QUIZCONTENT><OPTIONS><OPT id ="JAOOSETSEC03O1" ans="1">Encapsulation</OPT><OPT id ="JAOOSETSEC03O2" ans="0">Inheritance</OPT><OPT id ="JAOOSETSEC03O3" ans="0">Polymorphism</OPT><OPT id ="JAOOSETSEC03O4" ans="0">Abstraction</OPT></OPTIONS></QUIZ></BATCH><BATCH id="JAVAOOPSSETTHI"><QUIZ id ="JAOOSETTHIRD01" POINTS="02"><QUIZCONTENT>What is it called if an object has its own lifecycle and there is no owner?</QUIZCONTENT><OPTIONS><OPT id ="JAOOSETTHI01O1" ans="0">Aggregation</OPT><OPT id ="JAOOSETTHI01O2" ans="0">Composition</OPT><OPT id ="JAOOSETTHI01O3" ans="1">Encapsulation</OPT><OPT id ="JAOOSETTHI01O4" ans="0">Association</OPT></OPTIONS></QUIZ><QUIZ id ="JAOOSETTHIRD02" POINTS="01"><QUIZCONTENT>What is it called where child object gets killed if parent object is killed?</QUIZCONTENT><OPTIONS><OPT id ="JAOOSETTHI02O1" ans="0">Aggregation</OPT><OPT id ="JAOOSETTHI02O2" ans="1">Composition</OPT><OPT id ="JAOOSETTHI02O3" ans="0">Encapsulation</OPT><OPT id ="JAOOSETTHI02O4" ans="0">Association</OPT></OPTIONS></QUIZ><QUIZ id ="JAOOSETTHIRD03" POINTS="03"><QUIZCONTENT>What is it called where object has its own lifecycle and child object cannot belong to another parent object?</QUIZCONTENT><OPTIONS><OPT id ="JAOOSETTHI03O1" ans="0">Aggregation</OPT><OPT id ="JAOOSETTHI03O2" ans="0">Composition</OPT><OPT id ="JAOOSETTHI03O3" ans="0">Encapsulation</OPT><OPT id ="JAOOSETTHI03O4" ans="1">Association</OPT></OPTIONS></QUIZ></BATCH></TOPIC><TOPIC id="JAVAARRA180203"><TOPIC_NAME>ARRAY</TOPIC_NAME></TOPIC><TOPIC id="JAVAITER180203"><TOPIC_NAME>ITERATION</TOPIC_NAME></TOPIC></TOPICS></SUBJECT><SUBJECT id="PYTH1991230204"><SUBJECT_NAME>PYTHON</SUBJECT_NAME><SUBJECT_ABOUT>PYTHON IS A HIGH LEVEL LANGUAGE IT IS A PRODURAL AND OOPS AND SCRIPTIVE LANGUAGE</SUBJECT_ABOUT><TOPICS><TOPIC id="PYTHOOPS180203"><TOPIC_NAME>OOPS</TOPIC_NAME></TOPIC><TOPIC id="PYTHARRA180203"><TOPIC_NAME>ARRAY</TOPIC_NAME></TOPIC><TOPIC id="PYTHCONT180203"><TOPIC_NAME>CONTROL STRUCTURE</TOPIC_NAME></TOPIC></TOPICS></SUBJECT><SUBJECT id="JAVA1997230204"><SUBJECT_NAME>JAVASCRIPT</SUBJECT_NAME><SUBJECT_ABOUT>JAVA SCRIPT IS A HIGH LEVEL LANGUAGE IT IS A SCRIPTIVE LANGUAGE</SUBJECT_ABOUT><TOPICS><TOPIC id="JAVAOOPS180204"><TOPIC_NAME>DOM</TOPIC_NAME></TOPIC><TOPIC id="JAVAARRA180204"><TOPIC_NAME>INTERACTION</TOPIC_NAME></TOPIC><TOPIC id="JAVAITER180204"><TOPIC_NAME>CURSOR</TOPIC_NAME></TOPIC></TOPICS></SUBJECT></NOTES>*/
	    
	    Writer writer = new FileWriter(file);
	    javax.xml.transform.Transformer transformer = javax.xml.transform.TransformerFactory.newInstance().newTransformer();
	
	    transformer.transform(new javax.xml.transform.dom.DOMSource(document), new javax.xml.transform.stream.StreamResult(writer));
	    writer.close();
	    return true;
	}catch(Exception e) { e.printStackTrace(); return false;}
  }
}
