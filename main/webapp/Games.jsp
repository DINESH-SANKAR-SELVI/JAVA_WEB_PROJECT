<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>IQ+ Trainer</title>
      <link rel="website icon" type="png" href="image/WebIcon.png" />
      <link rel="stylesheet" type="text/css" href="css/Games.css" />
      <link rel="stylesheet" type="text/css" href="css/BaseFooter.css" />
      <!-- <link rel="stylesheet" type="text/css" href="css/UserNavFooter.css" />
      <link rel="stylesheet" type="text/css" href="css/UserNavHead.css" /> -->
</head>
<body>

	<%@ page import="BlueMoon.MemberAccess" %>
	
	<%	
		MemberAccess key = new MemberAccess();
		
		if(!(key.isMember())) response.sendRedirect("LogInPage.jsp");
			
	%>


      <div class=window style="display:flex;flex-direction:column;justify-content:center;align-items:center;" >
      
			<%@ include file="StepNav.jsp" %>
                      
            <div class=content>
                                    <div class="game">

                                          <div class="game1"><h3>APTITUDE</h3></div>
                                          <div class="game1"><h3>REASONING</h3></div>
                                          <div class="game1"><h3>COMING SOON..!</h3></div>
                                      
                                    </div>
            </div>

            <div class= footer style="width:100%;" >
                <%@ include file="FooterNav.jsp" %>
            </div>	
      </div>	
<script src="js/BaseMenu.js"></script>


      
</body>
</html>