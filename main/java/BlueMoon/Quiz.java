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
			Document d = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\ContentQuiz.xml");
			Document d1 = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
			
			
			NodeList quiz = d1.getElementsByTagName("QUIZS").item(0).getChildNodes();
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
			io.println("<html><body>");

			IdGenerator key = new IdGenerator();
			

				io.println("<div class=pair >");
				
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
				
				int correct = 0 ,wrong = 0 ,skiped = 0 ,totalquiz = 0 ,attenedQuiz = 0 ,totpoints = 0;
				
				int counter = 1;
				char []counterOpt = {'a','b','c','d','e','f'};
				
				for(int i=0;i<subject.getLength();i++){
					
					/* SUBJECT SELECTION */
					if(Subject.equalsIgnoreCase(subject.item(i).getAttributes().item(0).getTextContent())){
						
						SubjectName = subject.item(i).getChildNodes().item(1).getTextContent();
						
						for(int j=1;j<(subject.item(i).getChildNodes().item(5).getChildNodes().getLength());j++){
							
							if(!(j%2==0)){
								/* TOPIC SELECTION IN SELECTED SUBJECT */
								if(Topic.equalsIgnoreCase(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getAttributes().item(0).getTextContent())){
									
									TopicName = subject.item(i).getChildNodes().item(5).getChildNodes().item(1).getChildNodes().item(1).getTextContent();
									
									for(int k=3;k<=subject.item(i).getChildNodes().item(5).getChildNodes().getLength();k++){
										
										if(!(k%2==0)){
											
											/*BATCH QUIZ SELECTION IN SELECTED TOPIC*/																	
											if(BatchQuiz.equalsIgnoreCase(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getAttributes().item(0).getTextContent())){
												
												for(int m=1;m<subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();m++){
													
													if(!(m%2==0)){
													/* maybe need verify to find quiz*/
						//							out.println("<div style=\" display:flex;justify-content:space-between;width:99%; \"><h3>"+counter+". "+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(1).getTextContent()+"</h3><h3>"+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getAttributes().item(0).getNodeName()+": "+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getAttributes().item(0).getTextContent()+"</h3></div>");
													int count1 = 0;
													totalquiz++;
													totpoints = totpoints+ Integer.parseInt(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getAttributes().item(0).getTextContent());
													
												for(int l=1;l<subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().getLength();l++){
														
													if(!(l%2==0)){
														
				//										out.print("<p ");
														
														for(int n=1;n<UserAns.item(0).getChildNodes().getLength();n++){
							 								if(!(n%2==0)){
							 									if(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().item(l).getAttributes().item(1).getTextContent().equalsIgnoreCase(UserAns.item(0).getChildNodes().item(n).getAttributes().item(0).getTextContent())){

									 								if("1".equalsIgnoreCase(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().item(l).getAttributes().item(0).getTextContent())){
																//		out.print("style=\" background-color:green;\" ");
									 									correct++;
									 								}
									 								
																	else{
															//			out.print("style=\" background-color:red;\" ");
																		wrong++;
																	}
							 									}
							 								}
														}
														//out.print(">"+counterOpt[count1]+") "+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().item(l).getTextContent()+"<p>");
														
														//count1++;
														
														//out.println("<p>"+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().item(l).getAttributes().item(0).getTextContent()+"</p>");
													}
												}
												//out.println("<hr />");
												//counter++;
												}
											}
										}
									}
								}
							}
						}
					}
						
					//out.println("<p>"+subject.item(i).getTextContent()+"</p>");
					}
					
				}
				io.println("</div>");
			
				attenedQuiz = (correct + wrong);
				
				skiped = (totalquiz-correct -wrong);

			io.print("<div style=\"border:3px solid black;display:flex;align-items:center;justify-content:center;margin:3px;\" />");
			
			io.print("<h4> correct :"+correct+ " : wrong : " +wrong+" : attenedQuiz : "+attenedQuiz+ " : skiped : " +skiped +" : subjectName :"+SubjectName+" : Topic Name : "+TopicName+" : usrId : "+UsrId+" : timeStamp : "+now1+ " : TotalPoints : "+totpoints+"</h4>");
			
			io.print("</div>");
			
			
			String UsrName = d1.getElementsByTagName("USERID").item(0).getChildNodes().item(3).getTextContent();
			//String SubjectName = d1.getElementsByTagName("SUBJECTID").item(0).getTextContent();
			
			String EventQuizId = "";
			String SubjectId = d1.getDocumentElement().getElementsByTagName("SUBJECTID").item(0).getAttributes().item(0).getTextContent();
			String TopicId = d1.getDocumentElement().getElementsByTagName("TOPICID").item(0).getAttributes().item(0).getTextContent();
			String QuizSetId = d1.getDocumentElement().getElementsByTagName("BATCHQUIZID").item(0).getAttributes().item(0).getTextContent();
			String QuizId = "" ;
			String UserOptionId = "";
			
		
			EventQuizId = key.BatchQuizId(UsrName ,SubjectName , now1);
			
			io.println("<div style=\"display:flex;flex-direction:column;border:3px solid black;justify-content:center;align-items:center;\" >");
			
			for(int i=1;i<quiz.getLength();i++) {
				if(!(i%2==0)) {
					String q = String.valueOf(i);
					
					QuizId = quiz.item(i).getAttributes().item(1).getTextContent();
					UserOptionId = req.getParameter(q);
					
					PreparedStatement ps = con.prepareStatement("INSERT INTO reviewQuestionAnswer values(?,?,?,?,?,?)");
					
					ps.setString(1, EventQuizId);
					ps.setString(2, SubjectId);
					ps.setString(3, TopicId);
					ps.setString(4, QuizSetId);
					ps.setString(5, QuizId);
					ps.setString(6, UserOptionId);
					
					io.println("<h3>"+EventQuizId + " : " +SubjectId +" : "+TopicId + " : " + QuizSetId +" : " +QuizId + " : "+ UserOptionId +"</h3>");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//res.sendRedirect("FeedbackQuiz.jsp");
		io.println("</div>");
		io.println("</body></html>");
	}
}
