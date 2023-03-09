<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>FEEDBACK OF CURRENT QUIZ</title>
      <link rel="stylesheet" type="text/css" href="CSS/FeedbackQuiz.css" />
      <link rel="website icon" type="png" href="image/WebIcon.png" />
</head>
<body>

      <div class="feedback-window">
            <img width='120px'src="image/Success.png">
            <div class="star">
                  <img width="40px" style="margin:10px;" src="image/star.png" alt="Rating(1)">
                  <img width="40px" style="margin:10px;" src="image/star.png" alt="Rating(2)">
                  <img width="40px" style="margin:10px;" src="image/star.png" alt="Rating(3)">
                  <img width="40px" style="margin:10px;" src="image/star.png" alt="Rating(4)">
                  <img width="40px" style="margin:10px;" src="image/star.png" alt="Rating(5)"><br />
                  
                  <form action=FeedBack method="post" >
                  
                  <center><input style="border-radius:10px;border:2px solid white;background-color:orangered;text-align:center;caret-color:white;color:white;font-size:larger;" type="number" min="1" max="5" name="feedback" />  <input type=submit style="border-radius:10px;border:2px solid white;background-color:green;text-align:center;caret-color:white;color:white;font-size:larger;" onclick="winOrLose()" /></center>
                  
                  </form><br />
                  
                  <p style="color:white;display: inline;position: relative;left:20%;" >Give FeedBack Rating WithIn 5</p>
            </div>
            
            <div class="btn">
                  <button onclick="window.location.href='Profile.jsp'" >PROFILE</button>
                  <button onclick="window.location.href='ReviewQuiz.jsp'">REVIEW</button>
            </div>
      </div>
<script>
	
	function winOrLose(){
	
		alert("ok")
	}

</script>      

</body>
</html>