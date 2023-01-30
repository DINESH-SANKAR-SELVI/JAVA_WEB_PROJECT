<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class=nav style="height:30px;">
		<nav id=navBaseNav>
			<h4 style="color:white;"><i><%= "blue".toUpperCase()%><span style="color:red;"> <%="moon".toUpperCase()%></span></i></h4>
			<ul>
				<li><a href="BasePage.jsp#footer" ><%="about".toUpperCase()%></a></li>
				<li><a href=Profile.jsp ><%="profile".toUpperCase()%></a></li>
				<li><a href=Games.jsp ><%="games".toUpperCase()%></a></li>
				<li><a href=QuizNotes.jsp ><%="quiz".toUpperCase()%></a></li>
				<li><a href=LogInPage.jsp ><img src='image\user.png' title=login alt=ToLogIn height=40px width=40px style="position:relative;top:-10px;" /></a></li>
			</ul>
		</nav>
</div>	