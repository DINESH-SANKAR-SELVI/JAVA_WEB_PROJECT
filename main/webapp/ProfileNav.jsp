<body bgcolor=grey>
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
		
		<div>
		
			<ul style="display:flex;position:relative;top:-10px;justfy-content:space-evenly;">
			
				<li style="margin-left:20px; list-style-type:none;"><a style="text-decoration:none;color:white;" href="BasePage.jsp#footer" ><%="about".toUpperCase()%></a></li>
				<li style="margin-left:20px; list-style-type:none;"><a style="text-decoration:none;color:white;" href=Games.jsp ><%="games".toUpperCase()%></a></li>
				<li style="margin-left:20px; list-style-type:none;"><a style="text-decoration:none;color:white;" href=QuizNotes.jsp ><%="quiz".toUpperCase()%></a></li>
				<li style="margin-left:20px; list-style-type:none;"><button style="width:100px;height:30px;border:2px solid black;border-radius:20px;background-color:royalblue;color:white;" onclick="window.location.href='LogInPage.jsp'"><%="LogOut".toUpperCase() %></button></li>
				<li style="margin-left:20px; list-style-type:none;"><a style="text-decoration:none;color:white;" href=BasePage.jsp ><img src='image\user.png' title=HomePage alt=Home height=40px width=40px style="position:relative;top:-10px;" /></a></li>				
			</ul>
		<!-- <span style="position: relative;;color:white;margin-right: 10px;bottom: 10px;">USER NAME</span><img onclick="window.location.href='Profile.jsp'" width="30px" height="30px" style="border-radius:50%;" src="image/lock screen walpaper.jpg" /> -->
		
		</div>
	
	
	</div>
<script>
let bar = document.querySelector('.bars'),
values = document.querySelector('.options');

bar.addEventListener('click', ()=> {
      values.classList.toggle('active');
})</script>

</body>