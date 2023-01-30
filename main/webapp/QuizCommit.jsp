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
      <link rel="stylesheet" type="text/css" href="css/QuizCommit.css" />
</head>
<body>

      <div class=window >
            <div class="nav">
                  <nav>
                        <div class="bars">
                              <div class="bar"></div>
                              <div class="bar"></div>
                              <div class="bar"></div>
                        </div>     
                        <ul>
                              <li>                                   
                                    <ul class="options">
                                                <li><a onclick="quizCommit()">NOTES</a></li>
                                                <li><a onclick="quizCommit()">PROFILE</a></li>
                                                <li><a onclick="quizCommit()">GAMES</a></li>
                                    </ul>
                              </li>
                              <li><i style="font-weight: 1000;"><span style="color:white;">BLUE</span><span style="color: red;"> MOON</span></i></li>
                              <li><span style="position: relative;;color:white;margin-right: 10px;bottom: 10px;">USER NAME</span><img width="30px" height="30px" style="border-radius:50%;" onclick="quizCommit()" src="image/lock screen walpaper.jpg"/></li>
                        </ul>
                  </nav>
                  </div>

                  <div class="tot-time-points">
                        <h4>TOTAL TIME<pre> : 01:00 </pre></h4>
                        <h4>POINTS    <pre> : 02    </pre></h4>
                        <h4>TIME HAVE <pre> : 00:06 </pre></h4>
                  </div>
            <div class=content>
                  <div class="window-quiz">

                      
                        <div class="client">
                              <div class="quiz-base">

                                    <h3 style="font-size: medium;margin: 1%; ">1. GIVE THE CORRECT SYNTAX OF PRINT hello World.....! ?</h3>
                                    <h3 style="font-size: medium;margin: 1%;">QUIZ : 01/10 </h3>
                              </div>
                              <div class="opt-submit">
                                    <form action="#" method="post" >
                                          <label style="width:80%;left:100px;font-size:small;"><input type="checkbox" class="opt-1" >System.out.println(hello World.....!)</label>
                                          <label style="width:80%;left:100px;font-size:small;"><input type="checkbox" class="opt-1" >System.out.println('hello World.....!')</label> 
                                          <label style="width:80%;left:100px;font-size:small;"><input type="checkbox" class="opt-1" >System.out.println("hello World.....!")</label>
                                          <label style="width:80%;left:100px;font-size:small;"><input type="checkbox" class="opt-1" >system.out.print(hello World.....!)</label>
                                    </form>
                              </div>
                              <div class="submit-property">

                                    <button type="button">back</button>
                                    <button type="button">clear</button>
                                    <button onclick="window.location.href='FeedbackQuiz.jsp'" type="button">next</button>
                              </div>
                              <button id="submit-tot" onclick="" >send report</button>
                        </div>
                  </div>
            <div class="quiz-index" >

                  <div class="quiz-nav">1</div>
                  <div class="quiz-nav">2</div>
                  <div class="quiz-nav">3</div>
                  <div class="quiz-nav">4</div>
                  <div class="quiz-nav">5</div>
                  <div class="quiz-nav">6</div>
                  <div class="quiz-nav">7</div>
                  <div class="quiz-nav">8</div>
                  <div class="quiz-nav">9</div>
                  <div class="quiz-nav">10</div>
                  <div class="quiz-nav">11</div>
                  <div class="quiz-nav">12</div>
                  <div class="quiz-nav">13</div>
                  <div class="quiz-nav">14</div>
                  <div class="quiz-nav">15</div>
            </div>
            
            </div>
      </div>	
<script src="js/QuizNotes.js"></script>
</body>
</html>

