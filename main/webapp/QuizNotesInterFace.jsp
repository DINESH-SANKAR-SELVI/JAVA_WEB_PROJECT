<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Test The Self</title>
      <link rel="website icon" type="png" href="image/WebIcon.png" />
      <link rel="stylesheet" type="text/css" href="css/BaseFooter.css" />
      
<style type="text/css">

.intro{
      position: relative;
      
      justify-content: space-around;
      background-image: linear-gradient(-45deg,#d3dd18,#0191b4);
      width: 90%;
      border-radius: 20px;
      left: 5%;
      height: 300px;
}
</style>
<!-- display: flex;
      flex-direction: column; -->

</head>
<body style="background-image: linear-gradient(to right,#dac11f,#fe7a15);" >

		<%@ page import= "java.io.*"%>
		<%@ page import= "java.sql.*" %>
		<%@ page import= "javax.xml.parsers.*" %>
		<%@ page import= "org.w3c.dom.*" %>

      <div class=window >
            <div class="nav">
                  <%@ include file="StepNav.jsp" %>
            </div>
            <div class=content>
                  <div class="intro-note-quiz">
                        <div class="intro">
                        
                        
                        <%	try{
                        		/*	DOCUMENT CREATER AND READER */	
									DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
									DocumentBuilder db = dbf.newDocumentBuilder();
									File f = new File("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\ContentQuiz.xml");
									Document fd = db.parse(f);		
									File s = new File("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
									Document sd = db.parse(s);
								/*-------------------------------------------*/
								
								/* DECLARE VARIABLE TO COMPARE AND SELECT SUBJECT */
									String needSub = null;
									String tempCheck = null;
								/*-------------------------------------------------*/
								
								/* GET THE NODE AND VALUE TO PROCESS */
									
									NodeList d2 = fd.getElementsByTagName("SUBJECT");
									needSub = new String(sd.getElementsByTagName("SUBJECTID").item(0).getAttributes().item(0).getTextContent());
									
								/* ---------------------------------------------*/			
									
								/* CHECKING PROCESS FOR SELECT TO PRINT THE DATAS */
									for(int i=0;i<d2.getLength();i++){
											tempCheck =(String)d2.item(i).getAttributes().item(0).getTextContent();	
										if(needSub.equals(tempCheck)){
											
											out.println("<h1>"+d2.item(i).getChildNodes().item(1).getTextContent()+"</h1>");
											
											out.println("<h3>"+d2.item(i).getChildNodes().item(3).getTextContent()+"</h3>");
											
											for(int j=0;j<=(d2.item(i).getChildNodes().item(5).getChildNodes().getLength())-2;j++) out.println("<div onclick=\" window.location.href='QuizCommit.jsp'\" style=\"margin:10px;background-color:red;width:10%;color:white;\" ><center><p>"+d2.item(i).getChildNodes().item(5).getChildNodes().item(j+1).getTextContent()+"</p></center></div>");
											
											
										}										
										else{
											continue;
										}
									}
													
								/*----------------------------------------------------*/
								}catch(Exception e){ e.printStackTrace(); out.println("<p>"+e+"</p>");}	%>
                                                                                               
                        </div>

                  </div>     
            </div>

            <div class= footer>
                  <%@ include file="FooterNav.jsp" %>
            </div>	
      </div>	
<script src="js/BaseMenu.js"></script>
</body>
</html>