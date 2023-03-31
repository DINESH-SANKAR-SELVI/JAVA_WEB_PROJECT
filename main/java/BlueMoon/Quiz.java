package BlueMoon;

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
import java.util.Date;


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
			Document d = db.parse("C:\\Users\\ddpro\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\ContentQuiz.xml");
			Document d1 = db.parse("C:\\Users\\ddpro\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
			
			File file = new File("C:\\Users\\ddpro\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
								
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
			io.println("<html><body>");

			IdGenerator key = new IdGenerator();
			

		//		io.println("<div class=pair >");
				
				NodeList subject = d.getDocumentElement().getElementsByTagName("SUBJECT");
				NodeList UserAns = d1.getDocumentElement().getElementsByTagName("QUIZS");
				
				String Subject = d1.getDocumentElement().getElementsByTagName("SUBJECTID").item(0).getAttributes().item(0).getTextContent();
				String Topic = d1.getDocumentElement().getElementsByTagName("TOPICID").item(0).getAttributes().item(0).getTextContent();
				String BatchQuiz = d1.getDocumentElement().getElementsByTagName("BATCHQUIZID").item(0).getAttributes().item(0).getTextContent();
				
				String SubjectName = "";//d1.getElementsByTagName("SUBJECTID").item(0).getTextContent();
				String TopicName = "";
				String UsrId = d1.getElementsByTagName("USERID").item(0).getAttributes().item(0).getTextContent();
												
				Date now = new Date();
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				String now1 = format1.format(now);
				
				int correct = 0 ,wrong = 0 ,skiped = 0 ,totalquiz = 0 ,attenedQuiz = 0 ,totpoints = 0 ;
				boolean work = true;
				
				int counter = 1;
				char []counterOpt = {'a','b','c','d','e','f'};
				
				String[] UserOptionId = new String[UserAns.item(0).getChildNodes().getLength()];
				for(int i=0;i<UserAns.item(0).getChildNodes().getLength();i++) {
					String q = String.valueOf(i+1);
				//	String UserOptionId1 =String.valueOf(req.getParameter(q));
					UserOptionId[i] = String.valueOf(req.getParameter(q));
					Element quizids = (Element)UserAns.item(0).getChildNodes().item(i);
					quizids.setAttribute("optid", UserOptionId[i]);
							
							Writer writer = new FileWriter(file);
						    javax.xml.transform.Transformer transformer = javax.xml.transform.TransformerFactory.newInstance().newTransformer();

						    transformer.transform(new javax.xml.transform.dom.DOMSource(d1), new javax.xml.transform.stream.StreamResult(writer));
						    writer.close();
					}
				
				
				
				for(int i=0;i<subject.getLength();i++){
					
					// SUBJECT SELECTION 
					if(Subject.equalsIgnoreCase(subject.item(i).getAttributes().item(0).getTextContent())){
						
						SubjectName = subject.item(i).getChildNodes().item(0).getTextContent();
						
						io.print("<h1>"+SubjectName+"</h1>");
						
						for(int j=0;j<subject.item(i).getChildNodes().item(2).getChildNodes().getLength();j++){
							
								// TOPIC SELECTION IN SELECTED SUBJECT 
								if(Topic.equalsIgnoreCase(subject.item(i).getChildNodes().item(2).getChildNodes().item(j).getAttributes().item(0).getTextContent())){
									
									TopicName = subject.item(i).getChildNodes().item(2).getChildNodes().item(j).getChildNodes().item(0).getTextContent();
									
									io.print("<h1>"+TopicName+"</h1>");
									for(int k=1;k<subject.item(i).getChildNodes().item(2).getChildNodes().getLength();k++){
										

											//BATCH QUIZ SELECTION IN SELECTED TOPIC																	
											if(BatchQuiz.equalsIgnoreCase(subject.item(i).getChildNodes().item(2).getChildNodes().item(j).getChildNodes().item(k).getAttributes().item(0).getTextContent())){

												io.print("<h1>"+BatchQuiz+"</h1>");
												for(int m=0;m<subject.item(i).getChildNodes().item(2).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();m++){
													int count1 = 0;
													totalquiz++;
													totpoints = totpoints+ Integer.parseInt(subject.item(i).getChildNodes().item(2).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getAttributes().item(0).getTextContent());
													
														for(int l=0;l<subject.item(i).getChildNodes().item(2).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(1).getChildNodes().getLength();l++){
																
															io.print("<h1>"+subject.item(i).getChildNodes().item(2).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(1).getChildNodes().item(l).getTextContent() +"</h1>");
															
																	for(int n=0;n<UserAns.item(0).getChildNodes().getLength();n++){
										 									if(subject.item(i).getChildNodes().item(2).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(1).getChildNodes().item(l).getAttributes().item(1).getTextContent().equalsIgnoreCase(UserAns.item(0).getChildNodes().item(n).getAttributes().item(0).getTextContent())){
			
												 								if("1".equalsIgnoreCase(subject.item(i).getChildNodes().item(2).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(1).getChildNodes().item(l).getAttributes().item(0).getTextContent())){
												 									correct++;
												 									io.print("<h1>correct :"+correct+"</h1>");
												 								}
												 									
																				else{
																					wrong++;
																					io.print("<h1> wrong : "+wrong+"</h1>");
																				}
										 									}
																	}
														}
												}
										}	
									}
								}
						}
						

					}
					
				}
		
			
				attenedQuiz = (correct + wrong);
				
				skiped = (totalquiz-(correct +wrong));
				
				io.print("<h1>"+skiped+" "+attenedQuiz+" "+correct+" "+wrong+"</h1>");
				
				String UsrName = d1.getElementsByTagName("USERID").item(0).getChildNodes().item(3).getTextContent();
				//SubjectName = d1.getElementsByTagName("SUBJECTID").item(0).getTextContent();

				String EventQuizId = "";
				String SubjectId = d1.getDocumentElement().getElementsByTagName("SUBJECTID").item(0).getAttributes().item(0).getTextContent();
				String TopicId = d1.getDocumentElement().getElementsByTagName("TOPICID").item(0).getAttributes().item(0).getTextContent();
				String QuizSetId = d1.getDocumentElement().getElementsByTagName("BATCHQUIZID").item(0).getAttributes().item(0).getTextContent();
				String QuizId = "" ;
				//String UserOptionId = "";
				
				EventQuizId = key.BatchQuizId(UsrName ,SubjectName , now1);
				
				io.print("<h1>"+skiped+" "+attenedQuiz+" "+correct+" "+wrong+" "+UsrName+""+EventQuizId +"</h1>");
				
				Statement stmt = con.createStatement();
				ResultSet usrsno = stmt.executeQuery("select count(bluemoon.userhistory.EventQuestionsId) from bluemoon.userhistory where UserId ='"+UsrId+"'");
				int sno = 0;
				if(usrsno.next())sno= (usrsno.getInt(1))+1;
				
				PreparedStatement ps1 = con.prepareStatement("INSERT INTO bluemoon.UserHistory VALUE(?,?,?,?,?,?,?,?,?)");
				
				ps1.setInt(1, sno);
				ps1.setString(2, UsrId);
				ps1.setString(3, SubjectName);
				ps1.setString(4,TopicName);
				ps1.setString(5, now1);
				ps1.setString(6, EventQuizId);
				ps1.setInt(7, totpoints);
				ps1.setInt(8, skiped);
				ps1.setInt(9,attenedQuiz);
				
				
				work = ps1.execute();
				
				if(!(work)) {
					io.print("<div style=\"border:3px solid black;display:flex;align-items:center;justify-content:center;margin:3px;\" />");
						io.print("<h4>DONE ....!</h4>");	
					io.print("</div>");
				}
				work = true;

				PreparedStatement ps2 = con.prepareStatement("INSERT INTO bluemoon.review VALUES(?,?,?,?,?,?)");
				
				ps2.setString(1, EventQuizId);
				ps2.setInt(2, correct);
				ps2.setInt(3, wrong);
				ps2.setString(4, SubjectId);
				ps2.setString(5, TopicId);
				ps2.setString(6, QuizSetId);
				
				work = ps2.execute();
				
				if(!(work)) {
					
				io.print("<div style=\"border:3px solid black;display:flex;align-items:center;justify-content:center;margin:3px;\" />");
					
					io.print("<h4>DONE ....!</h4>");	
				io.print("</div>");
					
				}		
			
			
			io.println("<div style=\"display:flex;flex-direction:column;border:3px solid black;justify-content:center;align-items:center;\" >");
			
			for(int i=0;i<UserAns.item(0).getChildNodes().getLength();i++) {
				
					String q = String.valueOf(i+1);
					
					QuizId = UserAns.item(0).getChildNodes().item(i).getAttributes().item(1).getTextContent();
					//UserOptionId =String.valueOf(req.getParameter(q));
					
					if(!(UserOptionId.equals(""))) {
						
					PreparedStatement ps = con.prepareStatement("INSERT INTO reviewQuestionAnswer values(?,?,?,?,?,?)");
					
					ps.setString(1, EventQuizId);
					ps.setString(2, SubjectId);
					ps.setString(3, TopicId);
					ps.setString(4, QuizSetId);
					ps.setString(5, QuizId);
					ps.setString(6, UserOptionId[i]);
										
						work = ps.execute();
					}
					
					if(!(work)) {
						io.println("<h3>DONE ...!</h3>");
					}
					work = true;
				}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		res.sendRedirect("FeedbackQuiz.jsp");
		io.println("</div>");
		io.println("</body></html>");
	}
}
