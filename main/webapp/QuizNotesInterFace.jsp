<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Test The Self</title>
      <link rel="website icon" type="png" href="image/WebIcon.png" />
      <link rel="stylesheet" type="text/css" href="css/QuizNotesInterFace.css" />
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
                              <h2>JAVA</h2>
                              <ul id="topics">
                                    <li>JavaTutorial</li>
                                    <li>ControlStatements</li>
                                    <li>JavaObjectClass</li>
                                    <li>JavaInheritance</li>
                                    <li>JavaPolymorphism</li>
                                    <li>JavaAbstraction</li>
                                    <li>JavaEncapsulation</li>
                                    <li>JavaOOPsMisc</li>
                                    <li>JavaString</li>
                                    <li>JavaStringMethods</li>
                                    <li>JavaArray</li>
                                    <li>ExceptionHandling</li>
                                    <li>JavaInnerclasses</li>
                                    <li>JavaMultithreading</li>
                                    <li>JavaI/O</li>
                                    <li>JavaNetworking</li>
                                    <li>JavaAWT</li>
                                    <li>JavaSwing</li>
                                    <li>JavaFX</li>
                                    <li>JavaApplet</li>
                                    <li>JavaReflection</li>
                                    <li>JavaDate</li>
                                    <li>JavaConversion</li>
                                    <li>JavaCollection</li>
                                    <li>JavaJDBC</li>
                                    <li>JavaNewFeatures</li>
                                    <li>RMI</li>
                                    <li>Internationalization</li>
                                    <li>InterviewQuestions</li>
                                    <li>JavaTpoint</li>
                                    <li>JavaRegex</li>
                              </ul>
                              <p>
                                    Java is a programming language and computing platform first released by Sun Microsystems in 1995.
                                    It has evolved from humble beginnings to power a large share of today’s digital world,
                                    New, innovative products and digital services designed for the future continue to rely on Java, as well. 
                                    by providing the reliable platform upon which many services and applications are built.
                              </p>
                                          
                        </div>
                        <div class="note-quiz">

                              <div class="note-quiz-btn" onclick="window.open('documents/Java.pdf')">NOTES</div>
                              <div class="note-quiz-btn" onclick="window.location.href='QuizInterFace.jsp'">QUIZ</div>

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