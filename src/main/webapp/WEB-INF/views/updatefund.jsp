<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>  <%@page import="com.bean.*"%> <%@page import="com.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<link rel="icon" type="../resources/complain/image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/complain/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/complain/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/complain/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/complain/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/complain/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/complain/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/complain/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resources/complain/css/util.css">
	<link rel="stylesheet" type="text/css" href="../resources/complain/css/main.css">
<!--===============================================================================================-->
  <!-- Bootstrap CSS-->
  <link rel="stylesheet" type="text/css" href="../resources/home/css/bootstrap.min.css">

  <!-- Font-Awesome -->
  <link rel="stylesheet" type="text/css" href="../resources/home/css/font-awesome.css">

  <!-- Icomoon -->
  <link rel="stylesheet" type="text/css" href="../resources/home/css/icomoon.css">

  <!-- Slider -->
  <link rel="stylesheet" type="text/css" href="../resources/home/css/swiper.min.css">
  <link rel="stylesheet" type="text/css" href="../resources/home/css/rev-settings.css">

  <!-- Animate.css -->
  <link rel="stylesheet" href="../resources/home/css/animate.css">

  <!-- Color Switcher -->
  <link rel="stylesheet" type="text/css" href="../resources/home/css/switcher.css">

  <!-- Owl Carousel  -->
  <link rel="stylesheet" href="../resources/home/css/owl.carousel.css">

  <!-- Main Styles -->
  <link rel="stylesheet" type="text/css" href="../resources/home/css/default.css">
  <link rel="stylesheet" type="text/css" href="../resources/home/css/styles.css" id="colors">

  <!-- Fonts Google -->
  <link href="https://fonts.googleapis.com/css?family=Fira+Sans:100,200,300,400,500,600,700,800,900" rel="stylesheet">
  
<!-- Navbar END -->
</head>
<body >
<jsp:include page="adminSessionCheck.jsp"></jsp:include>
<!-- Navbar START -->
<header  style="background-color: #D7CFCD">
  <nav id="navigation4" class="container navigation" style="background-color: #D7CFCD">
    <div class="nav-header"  style="background-color: #D7CFCD">
      <a class="nav-brand" href="index-2.html">
  <!--       <img src="img/CHS.png" alt="logo"  class="main-logo" id="light_logo">
        <img src="img/CHS.png" alt="logo" class="main-logo" id="main_logo"> -->
      </a>
      <div class="nav-toggle"></div>
    </div>
    <div class="nav-menus-wrapper">
     <ul class="nav-menu align-to-right">
                <li><a href="adminhome">Home</a>
        </li>
        
		 <li><a>Features</a>
          <ul class="nav-dropdown">
        <li><a href="requests">Requests</a></li>
        <li><a href="adminnotice">Notice</a></li>
		<li><a href="AdminComplain">Complains<span class="menu-tag">NEW</span></a></li>
        <li><a href="showfunds">Funds<span class="menu-tag">NEW</span></a></li>
        <li><a href="vendorAdminList">Vendors<span class="menu-tag">NEW</span></a></li>
        
        </ul></li>
		<li><a href="logout">Logout</a></li>
		
        <li><a href="#">Contact Us</a>  
         </li></ul>    
    </div>
  </nav>
</header>
<%
    
	//int id=Integer.parseInt(request.getParameter(("id").toString());
	int id=Integer.parseInt(request.getAttribute("id").toString());
	System.out.print(id);
	
	FundDao fd= (FundDao)request.getAttribute("fundDao");
	
	FundBean fb = fd.getFundById(id);
	
%>

	<div class="container-contact100">

		<div class="wrap-contact100">
		
			<form class="contact100-form validate-form" method="post" action="../update_fund">
				<span class="contact100-form-title">
					Update Fund
				</span>
		  	<input type="hidden" name="id" value=<%=fb.getId() %>>
				<div class="wrap-input100 validate-input" data-validate = "Please enter fund type">
					<select class="input100"style="border: none"  name="type" placeholder="Notice">
					<% String type=fb.getType(); %>
						<option value="maintenance" <% out.print((type.equals("maintenance"))?("selected"):(" "));%>>Maintenance</option>				
						<option value="navratri" <% out.print((type.equals("navratri"))?("selected"):(" "));%>>Navratri</option>
						<option value="havan" <% out.print((type.equals("havan"))?("selected"):(" "));%>>Havan</option>
						<option value="other"<% out.print((type.equals("other"))?("selected"):(" "));%>>Others</option>
						
					</select>
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Please enter Amount">
					<input class="input100" type="number" name="amount" value=<%= fb.getAmount() %>  placeholder="Amounts To Be Paid">
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate = "Please enter information about fund">
					<textarea class="input100" name="info" placeholder="Short Info"><%= fb.getInfo() %></textarea>
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="Please enter Due date">
				
					<span style="color: #8f8fa1;">&ensp;&ensp; &ensp;Select Due Date ..</span>
					<input class="input100" type="date" name="due_date" value=<%= fb.getDate() %> placeholder="Enter Due Date">
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate = "Please select repetition">
					<span hidden="" style="color: #8f8fa1;text-align: center">&ensp;&ensp; Fund Shoud Repeted After ..</span>
					<select hidden="" class="input100"  style="border: none"  name="rep" placeholder="Fund shoud repeted after ..">
						<% int rep=Integer.parseInt(fb.getRep()); %>
						<option value="1" <% out.print((rep==1)?("selected"):(" "));%>>1 Months</option>				
						<option value="2" <% out.print((rep==2)?("selected"):(" "));%>>  2 Months</option>
						<option value="3" <% out.print((rep==3)?("selected"):(" "));%>>  3 Months</option>
						<option value="4" <% out.print((rep==4)?("selected"):(" "));%>>  4 Months</option>
						<option value="5" <% out.print((rep==5)?("selected"):(" "));%>>  5 Months</option>
						<option value="6" <% out.print((rep==6)?("selected"):(" "));%>>  6 Months</option>
						<option value="7" <% out.print((rep==7)?("selected"):(" "));%>>  7 Months</option>
						<option value="8" <% out.print((rep==8)?("selected"):(" "));%>>  8 Months</option>
						<option value="9" <% out.print((rep==9)?("selected"):(" "));%>>  9 Months</option>
						<option value="10" <% out.print((rep==10)?("selected"):(" "));%>>  10 Months</option>
						<option value="11" <% out.print((rep==11)?("selected"):(" "));%>>  11 Months</option>
						<option value="12" <% out.print((rep==12)?("selected"):(" "));%>>  12 Months</option>					
						<option value="0" <% out.print((rep==0)?("selected"):(" "));%>>None</option>
						
					</select>
					<span class="focus-input100"></span>
				</div>
				
				
				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn">
						<span>
							<i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i>
							Update
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>











	<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
	<script src="../resources/complain/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="../resources/complain/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="../resources/complain/vendor/bootstrap/js/popper.js"></script>
	<script src="../resources/complain/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="../resources/complain/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="../resources/complain/vendor/daterangepicker/moment.min.js"></script>
	<script src="../resources/complain/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="../resources/complain/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="../resources/complain/js/main.js"></script>

<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
</script>


 <!--Features Section START-->

<!--Features Section END-->
<!-- Footer START -->
<footer>
  <div class="container">
    <div class="row">
      <!-- Column 1 Start -->
      <div class="col-md-4 col-sm-6 col-12">
        <h3>About Us</h3>
        <div class="mt-25">
          
          <p class="mt-25">E-Maintenance is a cloud based society accounting and management software.</p>
          <div class="footer-social-icons mt-25">
            <ul>
              <li><a href="#"><i class="fa fa-facebook-square"></i></a></li>
              <li><a href="#"><i class="fa fa-instagram"></i></a></li>
              <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
              <li><a href="#"><i class="fa fa-skype"></i></a></li>
              <li><a href="#"><i class="fa fa-youtube"></i></a></li>
            </ul>
          </div>
        </div>
      </div>
      <!-- Column 1 End -->

      <!-- Column 2 Start -->
      <div class="col-md-3 col-sm-6 col-12" style=" margin-left: 100px;">
        <h3>Quick Navigation</h3>
        <ul class="footer-list">
          <li><a href="adminhome">Home</a></li>
          <li><a href="#">Features</a></li>
          <li><a href="login">LogIn</a></li>
          
          <li><a href="signup">Sign Up</a></li>
          <li><a href="#">About Us</a></li>
          <li><a href="#">Privacy And Security</a></li>
          <li><a href="#">Frequently Asked Questions</a></li>
          <li><a href="#">Contact Us </a></li>
        </ul>
      </div>
      <!-- Column 2 End -->

      <!-- Column 3 Start -->
      <div class="col-md-3 col-sm-6 col-12" style=" margin-left: 50px; padding-left: 20px;">
        <h3>Ahmedabad Office:</h3>
        <div class="mt-25">
       <p>B-601 chinmay complex, Navrangpura,Ahmedabad - 380048.<br>Tel: (91) 9898989898 <br>E-mail: support@emaintenance.in
        </div>
    <ul class="footer-list">
          <li><a href="#">Terms of Services</a></li>
          <li><a href="#">Privacy Policy</a></li>
        </ul>
      </div>
      <!-- Column 3 End -->

      <!-- Column 4 Start -->
     
      <!-- Column 4 End -->
    </div>

    <!-- Footer Bar Start -->
   
    <!-- Footer Bar End -->
  </div>
</footer>
<!-- Footer END -->

<!-- Scroll to top button Start -->
<a href="#" class="scroll-to-top"><i class="fa fa-angle-up" aria-hidden="true"></i></a>
<!-- Scroll to top button End -->


<!-- Jquery -->
<script src="../resources/home/js/jquery.min.js"></script>

<!--Popper JS-->
<script src="../resources/home/js/popper.min.js"></script>

<!-- Bootstrap JS-->
<script src="../resources/home/js/bootstrap.min.js"></script>

<!-- Owl Carousel-->
<script src="../resources/home/js/owl.carousel.js"></script>

<!-- Navbar JS -->
<script src="../resources/home/js/navigation.js"></script>
<script src="../resources/home/js/navigation.fixed.js"></script>

<!-- Wow JS -->
<script src="../resources/home/js/wow.min.js"></script>

<!-- Countup -->
<script src="../resources/home/js/jquery.counterup.min.js"></script>
<script src="../resources/home/js/waypoints.min.js"></script>

<!-- Tabs -->
<script src="../resources/home/js/tabs.min.js"></script>

<!-- Yotube Video Player -->
<script src="../resources/home/js/jquery.mb.YTPlayer.min.js"></script>

<!-- Swiper Slider -->
<script src="../resources/home/js/swiper.min.js"></script>

<!-- Isotop -->
<script src="../resources/home/js/isotope.pkgd.min.js"></script>

<!-- Switcher JS -->
<script src="../resources/home/js/switcher.js"></script>

<!-- Modernizr -->
<script src="../resources/home/js/modernizr.js"></script>

<!-- Google Map -->
<script src="../resources/home/js/map.js"></script>

<!-- Chart JS -->
<script src="../resources/home/js/Chart.bundle.js"></script>
<script src="../resources/home/js/utils.js"></script>

<!-- Revolution Slider -->
<script src="../resources/home/js/revolution/jquery.themepunch.tools.min.js"></script>
<script src="../resources/home/js/revolution/jquery.themepunch.revolution.min.js"></script>
<script src="../resources/home/js/revolution/revolution.extension.actions.min.js"></script>
<script src="../resources/home/js/revolution/revolution.extension.carousel.min.js"></script>
<script src="../resources/home/js/revolution/revolution.extension.kenburn.min.js"></script>
<script src="../resources/home/js/revolution/revolution.extension.layeranimation.min.js"></script>
<script src="../resources/home/js/revolution/revolution.extension.migration-2.min.js"></script>
<script src="../resources/home/js/revolution/revolution.extension.parallax.min.js"></script>
<script src="../resources/home/js/revolution/revolution.extension.navigation.min.js"></script>
<script src="../resources/home/js/revolution/revolution.extension.slideanims.min.js"></script>
<script src="../resources/home/js/revolution/revolution.extension.video.min.js"></script>

<!-- Main JS -->
<script src="../resources/home/js/main.js"></script>


</body>
</html>