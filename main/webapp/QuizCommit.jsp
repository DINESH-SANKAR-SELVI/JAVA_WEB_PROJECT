<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>COMMIT YOUR ANSWER</title>
      <link rel="website icon" type="png" href="image/WebIcon.png" />
 
 <style>
 .quiz-nav{
 	color:white;
 	height: 50px;
    width: 50px;
    margin: 10px;
    background-color: brown;
    display:flex;
    justify-content:center;
    align-items:center;
    border-radius:10px;
 }
.btn{
 
 	background-color:rgba(255,0,0,0.5);
 	height: 35px;
 	width:10%;
 	border-radius:10px;
 }

 
 </style>
</head>
<body style="background-image:linear-gradient(260deg,#416a8a,#2d6977);">

      <div class=window >
            <div class="nav">
				<%@ include file="StepNav.jsp" %>                 
            </div>


	<div class="tot-time-points" style="display:flex;justify-content:space-between;">
                        <h4>TOTAL TIME : 01:00 </h4>
                        <h4>POINTS     : 02    </h4>
                        <h4>TIME HAVE : 00:06 </h4>
    </div> 
            
      		<div class=content style="display:flex;justify-content:space-between;">
                  
	                  <div class="window-quiz" style="width:80%;background-color:rgba(255,255,255,0.2);border-radius:10px;">
	                     
	                        <div class="client" >
	                        
	                              <div class="quiz-base" style="display:flex;justify-content:space-between;width:100%;">
	
	                                    <h3 style="font-size: medium;margin: 1%; ">1. GIVE THE CORRECT SYNTAX OF PRINT hello World.....! ?</h3>
	                                    <h3 style="font-size: medium;margin: 1%;">QUIZ : 01/10 </h3>
	                              </div>
	                              <div class="opt-submit" style="display:flex;align-items:center;justify-content:center;">
	                                    <form action="#" method="post" style="display:flex;flex-direction:column;width:70%;align-items:center;">
	                                          <label style="width:80%;left:100px;font-size:small;padding:3px;margin:2px;font-size:larger;"><input type="checkbox" class="opt-1" >System.out.println(hello World.....!)</label>
	                                          <label style="width:80%;left:100px;font-size:small;padding:3px;margin:2px;font-size:larger;"><input type="checkbox" class="opt-1" >System.out.println('hello World.....!')</label> 
	                                          <label style="width:80%;left:100px;font-size:small;padding:3px;margin:2px;font-size:larger;"><input type="checkbox" class="opt-1" >System.out.println("hello World.....!")</label>
	                                          <label style="width:80%;left:100px;font-size:small;padding:3px;margin:2px;font-size:larger;"><input type="checkbox" class="opt-1" >system.out.print(hello World.....!)</label>
	                                    </form>
	                              </div>
	                              <br >
	                              <div class="submit-property" style="display:flex;justify-content: space-evenly;">
	
	                                    <button type="button" class="btn" >back</button>
	                                    <button type="button" class="btn" onclick="window.location.href='FeedbackQuiz.jsp'" >send report</button>
	                                    <button class="btn" type="button">next</button>
	                              </div>
	                              <br >
	                        </div>
	                        
	                  </div>
                  
		            <div class="quiz-index" style=" display: grid;grid-template-columns: auto auto auto;background-color:rgba(255,255,255,0.5);border-radius:10px;align-items:center;" >
		
		                  <div class="quiz-nav">1</div>
		                  <div class="quiz-nav">2</div>
		                  <div class="quiz-nav">3</div>
		                  <div class="quiz-nav">4</div>
		                  <div class="quiz-nav">5</div>
		                  <div class="quiz-nav">6</div>
		                  		                  
		            </div>
            
            </div>
      </div>	
<script src="js/QuizNotes.js"></script>
</body>
</html>

