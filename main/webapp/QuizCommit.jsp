<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COMMIT YOUR ANSWER</title>
<link rel="website icon" type="png" href="image/WebIcon.png" />
<style>

.btn{
 
 	background-color:rgba(255,0,0,0.5);
 	height: 35px;
 	width:10%;
 	border-radius:10px;
 	font-weight:bold;
 	font-style:italic;
 	color:white;
 }

</style>
</head>
<body style="background-image:linear-gradient(260deg,#416a8a,#2d6977);">

		<%@ include file="StepNav.jsp" %>

<%

	DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db = bdf.newDocumentBuilder(); 
	Document d1 = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\BACKEND_WORK\\main\\webapp\\xml\\UserNotes.xml");
	Document d = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\BACKEND_WORK\\main\\webapp\\xml\\BlueMoon1.xml");

	out.println("<form action=Quiz method=post >");
	out.println("<div class=pair >");
								
	NodeList subject = d.getDocumentElement().getElementsByTagName("SUBJECT");
	NodeList UserAns = d1.getDocumentElement().getElementsByTagName("QUIZS");
	
	String Subject = d1.getDocumentElement().getElementsByTagName("SUBJECTID").item(0).getAttributes().item(0).getTextContent();
	String Topic = d1.getDocumentElement().getElementsByTagName("TOPICID").item(0).getAttributes().item(0).getTextContent();
	String BatchQuiz = d1.getDocumentElement().getElementsByTagName("BATCHQUIZID").item(0).getAttributes().item(0).getTextContent();
	
	String SubjectName =" ",TopicName=" ";
	
	int totpoints=0;
	
	for(int i=0;i<subject.getLength();i++){
		
			if(Subject.equalsIgnoreCase(subject.item(i).getAttributes().item(0).getTextContent())){
				
				SubjectName = subject.item(i).getChildNodes().item(1).getTextContent();
				
					for(int j=1;j<(subject.item(i).getChildNodes().item(5).getChildNodes().getLength());j++){
						
							if(!(j%2==0)){
								
								if(Topic.equalsIgnoreCase(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getAttributes().item(0).getTextContent())){
									
									TopicName = subject.item(i).getChildNodes().item(5).getChildNodes().item(1).getChildNodes().item(1).getTextContent();
									
									for(int k=3;k<=subject.item(i).getChildNodes().item(5).getChildNodes().getLength();k++){
											
											if(!(k%2==0)){
												
												/*BATCH QUIZ SELECTION IN SELECTED TOPIC*/																	
												if(BatchQuiz.equalsIgnoreCase(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getAttributes().item(0).getTextContent())){
													
													for(int m=1;m<subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();m++){
														
														if(!(m%2==0)){
															
														totpoints = totpoints+ Integer.parseInt(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getAttributes().item(0).getTextContent());
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
		
	
%>
		<p id="top"></p>
		
		<div class="tot-time-points" style="display:flex;justify-content:space-between;">
                        <h4>SUBJECT : <span style="color:white;" ><%= SubjectName %></span></h4>
                        <h4>TOTAL POINTS     : <span style="color:white;" > <%= totpoints %> </span></h4>
                        <h4>TOPICS : <span style="color:white;" > <%= TopicName %></span></h4>
    </div>
		
	<div>
		<%@ page import="javax.xml.parsers.*" %>
		<%@ page import="org.w3c.dom.*" %>
		
		<%
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
 																	
 																	out.println("<div style='display:flex;flex-direction:column;align-items:center;'>");
 	 																out.println("<div style='background-color:rgba(255,255,255,0.4);border-radius:20px;padding:10px;width:90%;' >");
 	 																
 	 																
 																/* maybe need verify to find quiz*/
 																
 																out.println("<div style=\"font-size:larger;display:flex;justify-content:space-between;width:99%; \"><h3 name=q"+m+" value=dinesh >"+counter+". "+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(1).getTextContent()+"</h3><h3>"+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getAttributes().item(0).getNodeName()+": "+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getAttributes().item(0).getTextContent()+"</h3></div>");
 																int count1 = 0;
 																
 																out.println("<div style='display:flex;flex-direction:column;width:100%;align-items:center;' >");
																for(int l=1;l<subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().getLength();l++){
																	
																	if(!(l%2==0)){
																		
																		out.println("<label style=\"font-size:larger;border:1px solid black;border-radius:20px;width:50%;padding:4px; \" for="+m+l+" >");
																		out.print("<input type=radio name="+m+" id="+m+l+" value="+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().item(l).getAttributes().item(1).getTextContent()+">"+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().item(l).getTextContent());
																		out.println("</label><br />");
																		count1++;
																		
																		//out.println("<p>"+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(m).getChildNodes().item(3).getChildNodes().item(l).getAttributes().item(0).getTextContent()+"</p>");
																	}
																}
																out.println("</div>");
																out.println("</div>");
																out.println("</div>");
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
             <div class="submit-property" style="display:flex;justify-content: space-evenly;">
	
					<input type="button" class="btn" onclick="window.location.href='#top'" value="<%="go_top".toUpperCase() %>" />
	                <input type="submit" class="btn" value="<%= "finalize".toUpperCase() %>" />
	                <input type="button" class="btn" onclick="window.location.href='QuizNotes.jsp'" value="<%="cancel".toUpperCase() %>" />
	        </div>
	        <% out.println("</form>"); %>
	   </div>
		
		
</body>
</html>