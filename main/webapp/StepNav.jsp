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
		
		<div><span style="position: relative;;color:white;margin-right: 10px;bottom: 10px;">USER NAME</span><img onclick="window.location.href='Profile.jsp'" width="30px" height="30px" style="border-radius:50%;" src="image/lock screen walpaper.jpg" /></div>
	
	
	</div>
<script>
let bar = document.querySelector('.bars'),
values = document.querySelector('.options');

bar.addEventListener('click', ()=> {
      values.classList.toggle('active');
})</script>
