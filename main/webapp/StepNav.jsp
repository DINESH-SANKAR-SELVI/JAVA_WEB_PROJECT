<style>

.options{position: relative;list-style-type:none;top: -200px;
	}
	.options.active{top:0px;}
	
</style>

	<div class=NavStepNav style="display:flex;width:100%;justify-content:space-between;">
	
		<div>
			<div class="bars">
                              <div style="width: 25px;height: 4px;background-color: white;margin-top: 3px;border-radius: 2px;" class="bar"></div>
                              <div style="width: 25px;height: 4px;background-color: white;margin-top: 3px;border-radius: 2px;" class="bar"></div>
                              <div style="width: 25px;height: 4px;background-color: white;margin-top: 3px;border-radius: 2px;" class="bar"></div>
            </div>                                   
	                 <ul class="options" id="options" >
	                     <li><a style="text-decoration:none;color:white;" href=QuizNotes.jsp>NOTES</a></li>
	                     <li><a style="text-decoration:none;color:white;" href=Profile.jsp>PROFILE</a></li>
	                     <li><a style="text-decoration:none;color:white;" href=Games.jsp>GAMES</a></li>
          			 </ul>
		</div>
		
		<div><i style="font-weight: 1000;"><span style="color:white;">BLUE</span><span style="color: red;"> MOON</span></i></div>
<%@page import="javax.xml.parsers.*" %>
<%@page import="javax.xml.transform.*" %>
<%@page import="org.w3c.dom.*" %>
<%@page import="org.xml.sax.*" %>
<%@page import="java.io.*" %>
<%
File file = new File("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\MemberDetails.xml");
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document document = builder.parse(file); 
%>
		<div><span style="position: relative;;color:white;margin-right: 10px;bottom: 10px;"><%= document.getElementsByTagName("UserName").item(0).getTextContent() %></span><img onclick="window.location.href='Profile.jsp'" width="30px" height="30px" style="border-radius:50%;" src="image/BACKGROUND.JPG" /></div>
	
	
	</div>
<script>
let bar = document.querySelector('.bars'),
values = document.querySelector('.options');

bar.addEventListener('click', ()=> {
      values.classList.toggle('active');
})</script>
