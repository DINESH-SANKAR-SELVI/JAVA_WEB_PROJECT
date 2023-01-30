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
      <!-- <link rel="stylesheet" type="text/css" href="css/LogSignInTemplate.css" /> -->
      <!-- <link rel="stylesheet" type="text/css" href="css/SignInPage.css" /> -->
      <!-- <link rel="stylesheet" type="text/css" href="css/SignInPage.css" />
      <link rel="stylesheet" type="text/css" href="css/SignInPage1.css" />
      <link rel="stylesheet" type="text/css" href="css/SignInPage2.css" />
      <link rel="stylesheet" type="text/css" href="css/SignInPage3.css" /> -->

</head>
<body bgcolor="grey">

      <div class="fullWindow">

            <div class="contentWindow">
                  <div class="imgframe">
                        <img src="image/WebIcon.png "/>
                  </div>
                  <div class="brandName">
                        <h1 ><i><span style="color:white;">BLUE</span><span style="color:red;"> MOON</span></i></h1>
                  </div>
                  <div class="formPage">

                        <form action="#" method="post">
                                    <input type="text" name="USERNAME" id="USERNAME" maxlength="26" />
                                    <label for="USERNAME" id="LABEL-NAME" >USER NAME </label><br /><br />
                                    
                                    <input type="date" name="USERBHD" id="USERBHD" />
                                    <label id="LABEL-BHD" >USER BIRTHDAY</label>
                                    
                                    <select name="gender" id="USERGENDER" >
                                          <option style="color: red;font-weight: bold;" value="male" >MALE</option>
                                          <option style="color: rgb(230, 54, 84);font-weight: bold;" value="female">FEMALE</option>
                                    </select>

                                    <label id="LABEL-GENDER" >USER GENDER</label>



                                    <input type="tel" name="USERNUMBER" id="USERNUMBER" maxlength="13" />
                                    <label for="USERNUMBER" id="LABEL-NUMBER" >PHONE NUMBER  </label><br /> <br />
                                    
                                    <input type="email" name="USEREMAIL" id="USEREMAIL" />
                                    <label id="LABEL-EMAIL" >EMAIL ADDRESS</label>
                                    
                                    <select name="qualification" id="USERQUALI" >
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="SSLC" >SSLC</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="HSC" >HSC</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="ITI" >ITI</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="UG/PG" >UG/PG</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="OTHERS" >OTHERS</option>
                                    </select>
                                    <label id="LABEL-QUALI" >USER QULAIFICATION</label>




                                    <input type="text" name="USERPINCODE" id="USERPINCODE" maxlength="13" />
                                    <label for="USERPINCODE" id="LABEL-PINCODE" >RESIDENTIAL PIN CODE  </label><br /> <br />
                                    
                                    <select name="CITY" id="USERCITY" >
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="CHENNAI" >CHENNAI</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="KOLKATA" >KOLKATA</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="MUMBAI" >MUMBAI</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="BANGALORE" >BANGALORE</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="OTHERS" >OTHERS</option>
                                    </select>
                                    <label id="LABEL-CITY" >RESIDENTIAL CITY</label>
                                    
                                    <select name="AREA" id="USERAREA" >
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="AVADI" >AVADI</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="WEST BENGAL" >WEST BENGAL</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="WORLI" >WORLI</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="BASAVANAGUDI" >BASAVANAGUDI</option>
                                          <option style="color: rgb(25, 123, 209);font-weight: bold;" value="OTHERS" >OTHERS</option>
                                    </select>
                                    <label id="LABEL-AREA" >RESIDENTIAL AREA</label>



                                    
                                    <input type="password" name="USERPASSWORD" id="USERPASSWORD" maxlength="13" />
                                    <label for="USERPASSWORD" id="LABEL-PASSWORD" >PASSWORD  </label><br /> <br />
                                    <p id="LABEL-PASSHINT" >PASSWORD IS MININUM 6 CHARACTER CAN CONTAINS [A-Z],[a-z],[0-9],[SYMBOLS]   </p>
                                    
                                    <input type="password" name="USERFINALPASSWORD" id="USERFINALPASSWORD" maxlength="13" />
                                    <label id="LABEL-FINALPASSWORD" >CONFIRMATION PASSWORD</label>
                                    <p id="LABEL-FINALPASSHINT" >CONFIRMATION PASSWORD IS MUST BE SAME WITH PASSWORD</p>
                                    
                  </div>
                                    <button type="submit" id="VERIFY" style="font-weight: 1000;" >NEXT</button><br />
                        </form>                 
            </div>
      </div>
</body>
</html>