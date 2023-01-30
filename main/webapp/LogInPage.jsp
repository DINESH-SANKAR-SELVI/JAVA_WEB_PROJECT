<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>MemberShip</title>
      <link rel="website icon" type="png" href="image/WebIcon.png" />
      <link rel="stylesheet" type="text/css" href="css/LogSignInTemplate.css" />
      <link rel="stylesheet" type="text/css" href="css/LogInPage.css" />
</head>
<body>
<%=java.util.Calendar.getInstance().getTime() %>
      <div class="fullWindow">

            <div class="contentWindow">
                  <div class="imgframe">
                        <img src="image/WebIcon.png "/>
                  </div>
                  <div class="brandName">
                        <h1 ><i><span style="color:white;">BLUE</span><span style="color:red;"> MOON</span></i></h1>
                  </div>
                  <div class="formPage">

                        <form action="UserVerify" method="post">
                                    <input type="text" name="UserName" id="USERNAME" maxlength="26" />
                                    <label for="USERNAME" id="LABEL-NAME" >USER NAME (as Email) </label><br /> <br />
                                    
                                    <input type="password" name="UserPassword" id="USERPASSWORD" maxlength="26" />
                                    <label id="LABEL-PASSWORD" >USER PASSWORD</label>
                                    <p id="LABEL-FORGOT" ><a href="#" >Forgot Password...!</a></p>
                                    
                                    <button type="submit" id="VERIFY" style="font-weight: 1000;" >NEXT</button><br />
                                    <p id="LABEL-SIGN" >I don't have a account?<a href="SignInPage.jsp" > SignIn</a></p>
                        </form>
                  </div>
                 
            </div>
      </div>     
</body>
</html>
