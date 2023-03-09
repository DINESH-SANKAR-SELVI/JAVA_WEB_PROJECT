<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>WELCOME TO BLUE MOON</title>
      <link rel='website icon' type=png href=image/WebIcon.png />
      <link rel='stylesheet' href='CSS/BaseFooter.css' />
      <link rel='stylesheet' href='CSS/BaseNav.css' />

      
</head>
<body style="background-image:linear-gradient(to right,#33539e,#2d82b5);color:white;	">

		<%@ page import= "java.io.*"%>
		<%@ page import= "java.sql.*" %>
		<%@ page import= "javax.xml.parsers.*" %>
		<%@ page import= "org.w3c.dom.*" %>

      <div class=window >
            <div class="nav">
				<%@ include file="StepNav.jsp" %>
            </div>
            <div class=content>
                  <div class="menuList" >
                  <%	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
						DocumentBuilder db = dbf.newDocumentBuilder();
						Document d = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\BACKEND_WORK\\main\\webapp\\xml\\BlueMoon1.xml");			
						out.println("<div style=\"display:flex;flex-wrap:wrap;\">");
					try{
						 NodeList nl = d.getElementsByTagName("SUBJECT");
						 
						 for(int i=0;i<nl.getLength();i++){
							 out.println("<div onclick=\"window1()\" name=\"dinesh\" value= "+nl.item(i).getAttributes().item(0).getTextContent()+"><h4 style=\"font-size:19px;background-image: linear-gradient(to right,#207fb6de,#4e86a8e1); border-radius: 40px;margin-right:6px;padding:10px; \">"+nl.item(i).getChildNodes().item(1).getTextContent()+"</h4></div>");
						}
						
						 out.println("<h4 style=\"font-size:19px;background-image: linear-gradient(to right,#207fb6de,#4e86a8e1); border-radius: 40px;margin-right:6px;padding:10px;\" >COMMING SOON...!</h4></div>");
				
					}catch(Exception e){	out.println(e); }
		%>
                  </div>
                  <div class="title">
                        <h2><i>RECOMMENDED :</i></h2>
                  </div>
                  <div class="selectionList" style="margin-left:10%;">
                			
                	<%
                		 NodeList nl1 = d.getElementsByTagName("SUBJECT");
                	
                		for(int i=0;i<nl1.getLength();i++){
                			
                			
                			Node n = nl1.item(i);
                			
                			if(n.getNodeType() == n.ELEMENT_NODE){
                				
                				Element e = (Element) n;
                				
                			
                				
                				out.println("<div onclick=\"window.location.href='QuizNotesInterFace.jsp'\" style=\"width:80%;height:120px;\" ><h2 style=\" background-image:linear-gradient(to right,#083557c5,#004e9a);border-radius:10px;height:100%;padding:6px;margin-top:30px; \">"+e.getElementsByTagName("SUBJECT_NAME").item(0).getTextContent()+"<br /><br /><p style=\"font-size:19px;display:inline;\">"+e.getElementsByTagName("SUBJECT_ABOUT").item(0).getTextContent()+"</p></h2></div>");
                			}
                		}
                		out.println("<h2 style=\" background-image:linear-gradient(to right,#083557c5,#004e9a); width:80%;border-radius:10px; \">COMMING SOON...!</h4></div>");
                	
                	%>
				 </div>
            </div>
            <div class= footer>
					<%@ include file="FooterNav.jsp" %>
            </div>	
      </div>	
<script>
function window1(){
	
	window.location.href="QuizNotesInterFace.jsp"
}</script>


</body>
</html>