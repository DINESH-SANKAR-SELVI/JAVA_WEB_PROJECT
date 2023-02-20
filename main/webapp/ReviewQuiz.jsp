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

      <div class="review-window">
            <div class="top-panel">
                  <%@ include file="ReviewNav.jsp" %>
            </div>

            <div class="analysis">

                  <pre>





      COMING SOON (PIE CHART)







                  </pre>

                  <pre>





                                    COMING SOON (CHART ANALYSIS)







                  </pre>
            </div>

            <div class="quiz-result">

                  <div class="quiz-ans">
                  
 						<%@ page import= "javax.xml.parsers.*" %>
            			<%@ page import= "java.io.*" %>
            			<%@ page import= "java.sql.*" %>
            			<%@ page import= "org.w3c.dom.*" %>
 					
 						<% 
 							DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance();
 							DocumentBuilder db = bdf.newDocumentBuilder(); 
 							Document d = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\ContentQuiz.xml");
 							out.println("<div class=pair >");
 							
 							NodeList subject = d.getDocumentElement().getElementsByTagName("SUBJECT");
 							for(int i=0;i<subject.getLength();i++){
 								
 								if("PYTH1991230204".equalsIgnoreCase(subject.item(i).getAttributes().item(0).getTextContent())){
 									
 									for(int j=1;j<(subject.item(i).getChildNodes().item(5).getChildNodes().getLength());j++){
 										
 										if(!(j%2==0)){
 										
 											if("PYTHARRA180203".equalsIgnoreCase(subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getAttributes().item(0).getTextContent())){
 										
 												out.println("<p>"+subject.item(i).getChildNodes().item(5).getChildNodes().item(j).getTextContent()+"</p>");
 											}
 										}
 									}
 									
 								//out.println("<p>"+subject.item(i).getTextContent()+"</p>");
 								}
 								
 							}
 								
 							
 							out.println("</div>");
 						
 						%>	
 		<!-- work space -->
                              <div class="pair">
                                    <h3 id="q1" style="@media (max-width:800px) {font-size:1px;}" >1. GIVE THE CORRECT SYNTAX OF PRINT hello World.....! ? <pre>             POINTS:02/02</pre></h3>
                                    <h4 id="a1" >a)System.out.println(hello World.....!)</h4>
                                    <h4 id="b1" >b)System.out.println('hello World.....!')</h4>
                                    <h4 id="c1" >c)System.out.println("hello World.....!")</h4>
                                    <h4 id="d1" >d)system.out.print(hello World.....!)</h4><hr />
                              </div>
                              <div class="pair">
                                    <h3 id="q2" >2. GIVE THE CORRECT SYNTAX OF PRINT hello World.....! ? <pre>             POINTS:01/02</pre></h3>
                                    <h4 id="a2" >a)System.out.println(hello World.....!)</h4>
                                    <h4 id="b2" >b)System.out.println('hello World.....!')</h4>
                                    <h4 id="c2" >c)System.out.println("hello World.....!")</h4>
                                    <h4 id="d2">d)system.out.print(hello World.....!)</h4>
                              </div>


                  </div>

            </div>

      </div>
      
</body>
</html>