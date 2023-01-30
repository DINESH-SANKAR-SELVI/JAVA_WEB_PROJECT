<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= "welcome to bluemoon".toUpperCase() %></title>
<link rel=icon type=png href=image/WebIcon.png />
<link rel=stylesheet type=text/css href=css\BasePage.css />
<link rel=stylesheet type=text/css href=css\BaseNav.css />
<link rel=stylesheet type=text/css href=css\BaseFooter.css />
</head>
<body>
	<div class=window>
	
		<div class=header >
			<%@ include file="BaseNav.jsp" %>
		</div>
		
		<div class=content >
			
			<pre>






			</pre>	
			
		</div>
		
		<div class=footer>
			<%@ include file="FooterNav.jsp" %>
		</div>
		
		<div id=footer></div>
	</div>	
	
</body>
</html>