<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>GetMemberShip</title>
      <link rel="website icon" type="png" href="image/WebIcon.png" />
      <link rel="stylesheet" type="text/css" href="css/SignInPage.css" />
      <!-- <link rel="stylesheet" type="text/css" href="css/LogSignInTemplate.css" /> 
      <link rel="stylesheet" type="text/css" href="css/SignInPage.css" />
      
      <link rel="stylesheet" type="text/css" href="css/SignInPage1.css" />
      <link rel="stylesheet" type="text/css" href="css/SignInPage2.css" />
      <link rel="stylesheet" type="text/css" href="css/SignInPage3.css" /> -->

</head>
<body >

<center>
      <div class="fullWindow">

            <div class="contentWindow">
                  <div class="imgframe">
                        <img src="image/WebIcon.png "/>
                  </div>
                  <div class="brandName">
                        <h1 ><i><span style="color:white;">BLUE</span><span style="color:red;"> MOON</span></i></h1>
                  </div>
                  <div class="formPage">

                        <form action="AddUser" method="post">
                        
                        <div style="display:flex;justify-content:center;">
                        	<div>
                         	<label for="USERNAME" id="LABEL-NAME" >USER NAME </label><br />
                         	<input type="text" name="UserName" id="USERNAME" maxlength="26" />
                                   <br /><br />
                                    
                                    <label id="LABEL-BHD" >USER BIRTHDAY</label><br />
                                    <input type="date" name="UserBhd" id="USERBHD" /><br /><br />
                                    
                                    <label id="LABEL-GENDER" >USER GENDER</label><br />
                                    <select name="UserGender" id="GENDER" >
                                          <option style="color: red;font-weight: bold;" value="male" >MALE</option>
                                          <option style="color: rgb(230, 54, 84);font-weight: bold;" value="female">FEMALE</option>
                                    </select>
                                    <br /><br />

									<label for="USERNUMBER" id="LABEL-NUMBER" >PHONE NUMBER  </label><br />
                                    <input type="tel" name="UserPh" id="USERNUMBER" maxlength="13" /><br /><br />
                                    
                                    
                                    <label id="LABEL-EMAIL" >EMAIL ADDRESS</label><br />
                                    <input type="email" name="UserEmail" id="USEREMAIL" />
                                    <br /><br />
                                    
                                    <label id="LABEL-QUALI" >USER QULAIFICATION</label><br />
                                    <select name="UserQualifi" id="USERQUALI" >
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="SSLC" >SSLC</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="HSC" >HSC</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="ITI" >ITI</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="UG/PG" >UG/PG</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="OTHERS" >OTHERS</option>
                                    </select>
                                    <br /><br />
                                    
                                    </div>
                                    <div>
                                    
									<label for="USERPINCODE" id="LABEL-PINCODE" >RESIDENTIAL PIN CODE  </label><br />
                                    <input type="text" name="UserPinCode" id="USERPINCODE" maxlength="13" />
                                    <br /> <br />
                                    
                                    <label id="LABEL-CITY" >RESIDENTIAL CITY</label><br>
                                    <input list="USERCITYNAME" name="UserCity" id="USERCITY" />
                                    <datalist  id="USERCITYNAME" >
                                    	<option  value="CHENNAI" />
                                    	<option  value="KOLKATA" />
                                    	<option  value="MUMBAI" />
                                    	<option  value="BANGALORE" />
                                    	<option  value="Others" />
                                    </datalist>
                                    <br /><br />
                                    
                                    <label id="LABEL-AREA" >RESIDENTIAL AREA</label><br /><br />
                                    <input list="USERAREANAME" name="UserArea" id="USERAREA" />
                                    <datalist  id="USERAREANAME" >
                                    	<option  value="AVADI" />
                                    	<option  value="WEST BENGAL" />
                                    	<option  value="WORLI" />
                                    	<option  value="BASAVANAGUDI" />
                                    	<option  value="Others" />
                                    </datalist>
                                    <br><br >
                                    
                                    <label for="USERPASSWORD" id="LABEL-PASSWORD" >PASSWORD  </label><br /> <br />
                                    <input type="password" name="UserPassword" id="USERPASSWORD" maxlength="13" /><br><br>
                                    
                                    <p id="LABEL-PASSHINT" >PASSWORD IS MININUM 6 CHARACTER <br>CAN CONTAINS [A-Z],[a-z],[0-9],[SYMBOLS]   </p>
                                    
                                    <label id="LABEL-FINALPASSWORD" >CONFIRMATION PASSWORD</label><br />
                                    <input type="password" name="USERFINALPASSWORD" id="USERFINALPASSWORD" maxlength="13" />
                                    <br />	<br>
                                    
                                    </div>
                                    
                                    
                                    </div>
                  </div>
                  <p id="LABEL-FINALPASSHINT" >CONFIRMATION PASSWORD IS MUST BE SAME WITH PASSWORD</p>
                                    <button type="submit" id="VERIFY" style="font-weight: 1000;" >NEXT</button><br />
                        </form>                 
            </div>
      </div>

</center>
</body>
</html>