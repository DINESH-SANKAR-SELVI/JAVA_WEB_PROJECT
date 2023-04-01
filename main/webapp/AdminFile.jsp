<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN OF BLUEMOON</title>
<link type="png" href="image/WebIcon.png" rel="icon" />
</head>
<body>

<style>

#report{

	display:flex;
	background-color:hotpink;
	justify-content: space-evenly;
	height:400px;
}

</style>

	<center><h1>Reports For Admin</h1></center><hr />
	<div id="report">
	
		<div style="display:flex;flex-direction:column;justify-content:space-evenly;">
			<fieldset name="Subject" >
				<legend>Subject</legend>
				<form method="post" action="Report" ><input type="text" placeholder="ex:JAVA" name="SubName" /><button type=submit >sent</button></form>
			</fieldset>
		
			<fieldset name="Time">
				<legend>Time</legend>
				<form method="post" action="Report3" style="display:flex;flex-direction:column;align-items:center;" ><input type=text name="Timesrt" placeholder="ex: 2023-03-03 18:29:36" /><br /><br /><input type=text name="TimeStp" placeholder="ex: 2023-03-03 20:00:36" /><br /><br /><button type=submit style=\" width:30px;\">sent</button></form>
			</fieldset>
			
		</div>
		<div style="display:flex;flex-direction:column;justify-content:space-evenly;">	
			<fieldset name="Feedback" style="display:flex;justify-content:center;">
				<legend>FeedBack</legend>
				<form method="post" action="Report1" ><button type=submit >sent</button></form>
			</fieldset>
			
			<fieldset name="Log" style="display:flex;justify-content:center;">
				<legend>Log</legend>
				<form method="post" action="Report2" ><button type=submit >sent</button></form>
			</fieldset>
		</div>
	</div>
</body>
</html>