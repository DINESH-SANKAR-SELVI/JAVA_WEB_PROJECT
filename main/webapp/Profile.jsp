	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Known about you ?</title>
      <link rel="website icon" type="png" href="image/WebIcon.png" />
      <link rel="stylesheet" type="text/css" href="css/BaseFooter.css" />
      
</head>
<body style="background-image: linear-gradient(to right,#4568dc,#b06ab3);color:white;" >

      <div class=window >

					<%@ page import="BlueMoon.ProfileContent"%>      
  					
  					<% 
  						ProfileContent key = new ProfileContent(); 
  						if(!(key.WriterProfile())) response.sendRedirect("SignInPage.jsp");%>
    					
            <div class="nav">
					
						<%@ include file="ProfileNav.jsp" %>
						
                  </div>
            <div class=content>
            		<center>
            		
            		<%@ page import="javax.xml.parsers.*" %>
            		<%@ page import="java.io.*" %>
            		<%@ page import="java.sql.*" %>
            		<%@ page import= "org.w3c.dom.*" %>
            		
            		<%
                    
                    DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = bdf.newDocumentBuilder();                        
                    Document d = db.parse("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml"); %>
            		 
                                    <div class="data">
                                          <div class="profile">           
                                                <%out.print("<div class=\"imgframe\"><img style=\"border-radius:50%;\" src=\"image/"+d.getElementsByTagName("UserAvatar").item(0).getTextContent()+"\" width=\"100px\"  height=\"100px\" /> </div>");%>
                     <%                           
                     	
                        out.println("<h2>");                                               
                                                NodeList Userdn = d.getElementsByTagName("USERID").item(0).getChildNodes();
                                                NodeList Profiledn = d.getElementsByTagName("USERDETAIL").item(0).getChildNodes();
                                                	 	
                                                out.println("<h1>"+Userdn.item(3).getTextContent()+"</h1>");
                                                
                                                out.println("<h6>TOTAL ATTEMPT : "+Profiledn.item(1).getTextContent()+" SETS </h6>");
                             
                                                out.println("</h2>");
                                                
                                                out.println("</div>");
                                                out.println("<div class=\"rankInfo\">");
                                                out.println("<div class=\"ans\">");
                                                out.println("<h4 >AVERAGE CORRECT   : <span style=\"color: rgb(55, 190, 55);\">" +Profiledn.item(3).getTextContent()+ "% </span></h4>");
                                                out.println("<h4> AVERAGE INCORRECT : <span style=\"color: rgb(190, 59, 55);\">"+Profiledn.item(5).getTextContent()+"%</span></h4>");
                                                
                                                out.print("</div>");
                                                /* out.println("<div class=\"rank\">");
 												out.println("<h4>GLOBAL RANK : <span style=\"color: rgb(228, 224, 15);\"> "+Profiledn.item(7).getTextContent()+"</span></h4>");
                                                out.println("<h4 >REGION RANK : <span style=\"color: rgb(57, 78, 92);\">"+Profiledn.item(9).getTextContent()+"</span></h4>"); */
                                                		
                                                out.println("</div>");
                                          out.println("</div>");
                                          
                                          %>
                                          <div class="history" >
                                                <table border="0px" style="text-align: center;background-color: #4568dc;">
                                                      <tr style="background-color: #b956bd;">
                                                            <th>S.NO</th>
                                                            <th>EVENT NAME</th>
                                                            <th>EVENT TOPIC</th>
                                                            <th> EVENT DATE & TIME</th>
                                                            <th>POINTS</th>
                                                            <th>EVENT QUIZ & ANSWER</th>
                                                            <th> SKIPED</th>
                                                            <th>ATTENED QUIZ</th>
                                                      </tr>
                                          <%
                                          
                                          	NodeList his =d.getElementsByTagName("History").item(0).getChildNodes();
                                          
                                          long count = 1; 
                                          	
                                          for(int i=0;i<his.getLength();i++){
                                        	  
                                        	  //if(!((i%2)==0)){
                                        	  
                                        	  out.println("<tr><td>"+count+"</td>");
                                        	  count+=1;
                                        	  for(int j=0;j<his.item(i).getChildNodes().getLength();j++){
                                        		  
                                        		  //if(((j%2)==0)){
                                        			  if(!(j==4)){
                                        				  out.println("<td>"+his.item(i).getChildNodes().item(j).getTextContent()+"</td>");
                                        			  }
                                        			  else{
                                        				  out.println("<td><a style=\" text-decoration:none;color: orengered; \" href='ReviewQuiz.jsp' >"+his.item(i).getChildNodes().item(j).getTextContent()+"</a></td>");
                                        			  }
                                        		 // }
                                        		  
                                        	  }
                                        	  out.println("</tr>");
                                          //}
                                          }
										  %>
                                              </table>
                                          </div>
                                         
                                    </div>
                        </center>
            </div>
            <div class= footer>
                 <%@ include file="FooterNav.jsp" %>
            </div>	
      </div>	
<script src="js/QuizNotes.js"></script>

</body>
</html>