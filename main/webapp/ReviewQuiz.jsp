<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>REVIEW OF CURRENT TASK</title>
      <link rel="stylesheet" type="text/css" href="css/ReviewQuiz.css" />
      <link rel="website icon" type="png" href="image/WebIcon.png" />
</head>
<body >


<% 
 							DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance();
 							DocumentBuilder db = bdf.newDocumentBuilder(); 
 							Document d = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\BACKEND_WORK\\main\\webapp\\xml\\BlueMoon1.xml");
 							Document d1 = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\BACKEND_WORK\\main\\webapp\\xml\\UserNotes.xml");
 							out.println("<div class=pair >");
 							
 							NodeList subject = d.getDocumentElement().getElementsByTagName("SUBJECT");
 							NodeList UserAns = d1.getDocumentElement().getElementsByTagName("QUIZS");
 							
 							String Subject = d1.getDocumentElement().getElementsByTagName("SUBJECTID").item(0).getAttributes().item(0).getTextContent();
 							String Topic = d1.getDocumentElement().getElementsByTagName("TOPICID").item(0).getAttributes().item(0).getTextContent();
 							String BatchQuiz = d1.getDocumentElement().getElementsByTagName("BATCHQUIZID").item(0).getAttributes().item(0).getTextContent();
 							
 							int correct = 0 ,wrong = 0 ,skiped = 0 ,totalquiz = 0;	
 							
 							int counter = 1;
 							char []counterOpt = {'a','b','c','d','e','f'};
 							
 							for(int i=0;i<subject.getLength();i++){
 								
 								/* SUBJECT SELECTION */
 								if(Subject.equalsIgnoreCase(subject.item(i).getAttributes().item(0).getTextContent())){
 									
 									for(int j=1;j<(subject.item(i).getChildNodes().item(5).getChildNodes().getLength());j++){
 										
 										if(!(j%2==0)){
 											/* TOPIC SELECTION IN SELECTED SUBJECT */
 											if(Topic.equalsIgnoreCase(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getAttributes().item(0).getTextContent())){
 										
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
 							out.println("</div>");
 						
 						%>


      <div class="review-window">
            <div class="top-panel">
                  <%@ include file="ReviewNav.jsp" %>
            </div>

            <div class="analysis">

                  <div style="display:flex;justify-content:center;align-items:center;">

      						<div style="background-color:green;border-radius:50%;width:150px;height:150px;display:flex;align-items:center;justify-content:center;" > <h1 style="font-size:100px;"><%= correct %></h1></div>

                  </div>
                  
				  <div style="display:flex;justify-content:center;align-items:center;">

      						<div style="background-color:grey;border-radius:50%;width:150px;height:150px;display:flex;align-items:center;justify-content:center;" > <h1 style="font-size:100px;"> <%= (totalquiz-correct -wrong) %></h1></div>

                  </div>

                  <div style="display:flex;justify-content:center;align-items:center;">

      						<div style="background-color:red;border-radius:50%;width:150px;height:150px;display:flex;align-items:center;justify-content:center;" > <h1 style="font-size:100px;"> <%= wrong %></h1></div>

                  </div>
          </div>

            <div class="quiz-result">

                  <div class="quiz-ans">
                  
 						<%@ page import= "javax.xml.parsers.*" %>
            			<%@ page import= "java.io.*" %>
            			<%@ page import= "java.sql.*" %>
            			<%@ page import= "org.w3c.dom.*" %>
 					
 						<% 
 							//DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance();
 							//DocumentBuilder db = bdf.newDocumentBuilder(); 
 							//Document d = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\ContentQuiz.xml");
 							//Document d1 = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
 							out.println("<div class=pair>");
 							
 							//NodeList subject = d.getDocumentElement().getElementsByTagName("SUBJECT");
 							//NodeList UserAns = d1.getDocumentElement().getElementsByTagName("QUIZS");
 							
 							//String Subject = d1.getDocumentElement().getElementsByTagName("SUBJECTID").item(0).getAttributes().item(0).getTextContent();
 							//String Topic = d1.getDocumentElement().getElementsByTagName("TOPICID").item(0).getAttributes().item(0).getTextContent();
 							//String BatchQuiz = d1.getDocumentElement().getElementsByTagName("BATCHQUIZID").item(0).getAttributes().item(0).getTextContent();
 							
 						//	int correct = 0 ,wrong = 0;
 							
 							//int counter = 1;
 							//char []counterOpt = {'a','b','c','d','e','f'};
 							
 							for(int i=0;i<subject.getLength();i++){
 								
 								/* SUBJECT SELECTION */
 								if(Subject.equalsIgnoreCase(subject.item(i).getAttributes().item(0).getTextContent())){
 									
 									for(int j=1;j<(subject.item(i).getChildNodes().item(5).getChildNodes().getLength());j++){
 										
 										if(!(j%2==0)){
 											/* TOPIC SELECTION IN SELECTED SUBJECT */
 											if(Topic.equalsIgnoreCase(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getAttributes().item(0).getTextContent())){
 										
 												for(int k=3;k<=subject.item(i).getChildNodes().item(5).getChildNodes().getLength();k++){
 													
 													if(!(k%2==0)){
 														
 														/*BATCH QUIZ SELECTION IN SELECTED TOPIC*/																	
 														if(BatchQuiz.equalsIgnoreCase(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getAttributes().item(0).getTextContent())){
 															
 															for(int m=1;m<subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();m++){
 																
 																if(!(m%2==0)){
 																/* maybe need verify to find quiz*/
 																out.println("<div style=\" display:flex;justify-content:space-between;width:99%; \"><h3>"+counter+". "+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(1).getTextContent()+"</h3><h3>"+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getAttributes().item(0).getNodeName()+": "+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getAttributes().item(0).getTextContent()+"</h3></div>");
 																int count1 = 0;
																for(int l=1;l<subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().getLength();l++){
 																	
																	if(!(l%2==0)){
																		
																		out.print("<p ");
																		
																		for(int n=1;n<UserAns.item(0).getChildNodes().getLength();n++){
											 								if(!(n%2==0)){
											 									if(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().item(l).getAttributes().item(1).getTextContent().equalsIgnoreCase(UserAns.item(0).getChildNodes().item(n).getAttributes().item(0).getTextContent())){
											 										
													 								if("1".equalsIgnoreCase(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().item(l).getAttributes().item(0).getTextContent())){
																						out.print("style=\" background-color:green;\" ");
																						correct++;
													 								}
																					else{
																						out.print("style=\" background-color:red;\" ");
																						wrong++;
																					}
											 									}
											 								}
																		}
																		out.print(">"+counterOpt[count1]+") "+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().item(l).getTextContent()+"<p>");
																		
																		count1++;
																		
																		//out.println("<p>"+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().item(l).getAttributes().item(0).getTextContent()+"</p>");
																	}
																}
																out.println("<hr />");
																counter++;
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
 							out.println("</div>");
 						
 						%>	

                  </div>

            </div>

      </div>
      
</body>
</html>