<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Signup</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="resources/signup/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/signup/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/signup/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/signup/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/signup/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/signup/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/signup/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/signup/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/signup/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/signup/css/util.css">
	<link rel="stylesheet" type="text/css" href="resources/signup/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100" style="width: 40%;">
				<s:form class="login100-form validate-form" action="saveuser" method="post" commandName="userbean" >
					<span class="login100-form-title p-b-26" style="margin-top: -45px;">
						SIGN UP
					</span>
					<span class="login100-form-title p-b-48">
						<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQn1YHF3YyGT7Y1qtDa5SLZ8W1ABJCz8ckgw-w5tF-lVWeM0KLi" alt="logo!!" style="
    height: 70px;
">
					</span>
					
					
				
					
					<div class="wrap-input101 validate-input" data-validate = "Enter First Name">
					
						<s:input class="input100" path="fname" style="width: 140px;" />
						<span class="focus-input100" data-placeholder="First Name "></span>
					</div>
					
					<div class="wrap-input102 validate-input" data-validate = "Enter Middle Name">
						<s:input class="input100"  path="mname" style="width: 140px;" />
						
						<span class="focus-input100" data-placeholder="Middle Name "></span>
					</div>
					
					<div class="wrap-input103 validate-input" data-validate = "Enter Last Name">
						<s:input class="input100"  path="lname" style="width: 140px;"/>
						<span class="focus-input100" data-placeholder="Last Name "></span>
					</div>
						
						
					<div class="wrap-input100 validate-input" data-validate = "Enter 10 digit number">
						<s:input class="input100"  path="phone_No" />
						<span class="focus-input100" data-placeholder="Contact Number "></span>
					</div>
						
							<div class="wrap-input100 validate-input" data-validate = "Enter Flat number">
						<s:input class="input100" path="flate_no" />
						<span class="focus-input100" data-placeholder="flat no. ex:-A301 "></span>
					</div>
					<div >	
					<span class="txt1" >TYPE:</span>
					<s:radiobutton   path="type" value="Member" style="margin-left:10px;position:relative;" /><span class="txt1">Member</span>   
					<s:radiobutton  path="type" value="Tenant" style="margin-left:10px;position:relative;" /><span class="txt1">Tenant</span></br></br>
									
					</div>


					<div class="wrap-input100 validate-input" data-validate = "Valid email is: a@b.c">
						<s:input class="input100"  path="email" />
						<span class="focus-input100" data-placeholder="Email"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<s:input class="input100" type="password" path="password" />
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button  type="submit" class="login100-form-btn" >
								Signup
							</button>
						</div>
					</div>

					
						<span class="txt1" style="padding-top: 15px;padding-left:125px;">
							Already have an account? 
						</span>

						<a class="txt2" href="login">
							Log in
						</a>
					
				</s:form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="resources/signup/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/signup/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/signup/vendor/bootstrap/js/popper.js"></script>
	<script src="resources/signup/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/signup/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/signup/vendor/daterangepicker/moment.min.js"></script>
	<script src="resources/signup/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="resources/signup/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="resources/signup/js/main.js"></script>

</body>
</html>