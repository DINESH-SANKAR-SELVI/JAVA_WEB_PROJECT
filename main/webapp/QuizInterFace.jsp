<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
      <link rel="website icon" type="png" href="image/WebIcon.png" />
      <link rel="stylesheet" type="text/css" href="css/QuizInterFace.css" />
      <link rel="stylesheet" type="text/css" href="css/UserNavFooter.css" />
      <link rel="stylesheet" type="text/css" href="css/UserNavHead.css" /> 
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
                                                <li><a href=QuizNotes.jsp>NOTES</a></li>
                                                <li><a href=Profile.jsp>PROFILE</a></li>
                                                <li><a href=Games.jsp>GAMES</a></li>
                                    </ul>
                              </li>
                              <li><i style="font-weight: 1000;"><span style="color:white;">BLUE</span><span style="color: red;"> MOON</span></i></li>
                              <li><span style="position: relative;;color:white;margin-right: 10px;bottom: 10px;">USER NAME</span><img width="30px" height="30px" style="border-radius:50%;" src="image/lock screen walpaper.jpg" onclick="window.location.href='Profile.jsp'"/></li>
                        </ul>
                  </nav>
            </div>
            <div class=content>
                  <div class="intro-note-quiz">
                        <div class="intro">
                              <div class="quiz-title">
                              <dl>
                                    <dt style="margin-bottom: 8px;color: rgb(117, 24, 223);"><img width="30px" style="border-radius:2px;margin-right:12px;position: relative; top: 7px;" src="image/java-logo.png">JAVA</dt>
                                    <dd style="font-size:large">
                                          Java is a programming language and computing platform first released by Sun Microsystems in 1995.
                                          It has evolved from humble beginnings to power a large share of today’s digital world,
                                          New, innovative products and digital services designed for the future continue to rely on Java, as well. 
                                          by providing the reliable platform upon which many services and applications are built.
                                    </dd> 
                              </dl>
                              </div>
                              <div class="quizDetails">
                                    <div class="total-pointsAndTime">
                                          <h4 >TOTAL POINTS<pre> : 20 </pre></h4>
                                          <h4> TOTAL TIME<pre>   : 1:00 Min</pre></h4>
                                    </div>
                                    <div class="totalQuiz-PerQuizTime">
                                          <h4> NO OF QUIZ<pre> : 10</pre></h4>
                                          <h4> PER QUIZ<pre>   : 0:06 Min</pre></h4>
                                    </div>
                              </div>
                              <div class="entry">
                                    <button onclick="window.location.href='QuizCommit.jsp'" style="padding:0.5%;border-radius: 6px;font-weight: bold;color: rgb(63, 33, 33);background-image: linear-gradient(45deg,#428cd4,#ff9cda);"> START TASK...!</button>
                              </div>
                        </div>
                        <h3 style="margin-left: 6px;color: rgb(206, 53, 53);">TOPIC BASED QUIZS :- </h3>
                        <div class="note-quiz">
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaTutorial</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">ControlStatements</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaObjectClass</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaInheritance</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaPolymorphism</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaAbstraction</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaEncapsulation</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaOOPsMisc</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaString</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaStringMethods</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaArray</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">ExceptionHandling</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaInnerclasses</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaMultithreading</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaI/O</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaNetworking</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaAWT</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaSwing</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaFX</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaApplet</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaReflection</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaDate</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaConversion</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaCollection</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaJDBC</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaNewFeatures</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">RMI</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">Internationalization</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaTpoint</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">JavaRegex</div>
                              <div class="note-quiz-btn" onclick="window.location.href=''">InterviewQuestions</div>
                        </div>
                  </div>     
            </div>

            <div class= footer>
                  <footer>
                                    <div class=footerContent>
                                          <div class=notes>
                                                <h4>NOTES</h4>
                                                      <ul>
                                                            <li><a href=QuizNotes.jsp >JAVA</a></li>
                                                            <li><a href=QuizNotes.jsp >PYTHON</a></li>
                                                            <li>COMING SOON...!</li>
                                                      </ul>
                                          </div>
                                          <div class=quiz>
                                                <h4>PROFILE</h4>
                                                      <ul>
                                                            <li><a href=profile.jsp >RIGION</a></li>
                                                            <li><a href=Profile.jsp >PERSONAL</a></li>
                                                            <li>COMING SOON...!</li>
                                                      </ul>
                                          </div>
                                          <div class=games>
                                                <h4>GAMES</h4>
                                                      <ul>
                                                            <li><a href=Games.jsp >REASONING</a></li>
                                                            <li><a href=Games.jsp >APTITUDE</a></li>
                                                            <li>COMING SOON...!</li>
                                                      </ul>
                                          </div> 
                                          <div class=community>
                                                <h4>CONTACT</h4>
                                                      <ul>
                                                            <li><a href=# ><img width=30px src="image/WhatsappIcon.png" /></a></li>
                                                            <li><a href=# ><img width=30px src="image/InstagramIcon.png" /></a></li>
                                                            <li>COMING SOON...!</li>
                                                      </ul> 
                                          </div>
                                    </div>
                                    <h4 id=cpyrights ><i><img src=image/WebIcon.png /> BLUE <span style="color: red;"> MOON</span> 2022 &copy;</i></h4>
                  </footer>
            </div>	
      </div>	
<script src="js/BaseMenu.js"></script>
</body>
</html>