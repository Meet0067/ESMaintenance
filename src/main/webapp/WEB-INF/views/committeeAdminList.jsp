<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" errorPage="login.jsp" %>  <%@page import="com.bean.*,com.dao.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Committee</title>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" type="text/css" href="resources/complain/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/complain/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/complain/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/complain/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/complain/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/complain/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/complain/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/complain/css/util.css">
	<link rel="stylesheet" type="text/css" href="resources/complain/css/main.css"><meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="resources/requests/image/png" href="resources/requests/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/requests/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/requests/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/requests/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/requests/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/requests/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/requests/css/util.css">
	<link rel="stylesheet" type="text/css" href="resources/requests/css/main.css">
<!--===============================================================================================-->
<!--===============================================================================================-->
  <!-- Bootstrap CSS-->
  <link rel="stylesheet" type="text/css" href="resources/home/css/bootstrap.min.css">

  <!-- Font-Awesome -->
  <link rel="stylesheet" type="text/css" href="resources/home/css/font-awesome.css">

  <!-- Icomoon -->
  <link rel="stylesheet" type="text/css" href="resources/home/css/icomoon.css">

  <!-- Slider -->
  <link rel="stylesheet" type="text/css" href="resources/home/css/swiper.min.css">
  <link rel="stylesheet" type="text/css" href="resources/home/css/rev-settings.css">

  <!-- Animate.css -->
  <link rel="stylesheet" href="resources/home/css/animate.css">

  <!-- Color Switcher -->
  <link rel="stylesheet" type="text/css" href="resources/home/css/switcher.css">

  <!-- Owl Carousel  -->
  <link rel="stylesheet" href="resources/home/css/owl.carousel.css">

  <!-- Main Styles -->
  <link rel="stylesheet" type="text/css" href="resources/home/css/default.css">
  <link rel="stylesheet" type="text/css" href="resources/home/css/styles.css" id="colors">

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
		CommitteeDao cd= (CommitteeDao)request.getAttribute("committeeDao");
		//System.out.println(Integer.parseInt(request.getSession().getAttribute("userid").toString()));
		System.out.print(cd);
		System.out.print("++");
		ArrayList<CommitteeBean> cb = cd.getCommitteeMembers();
		

%><br><br><br>
		<span class="contact100-form-title">
					List Of Committee Members
				</span>
		<div >
		<table style="width:90%; margin-left:5%; margin-right:15%">
						<thead>
							<tr class="table100-head">
								<th class="column2">Member ID</th>
								<th class="column5">Name</th>
								<th class="column2">Post</th>
								<th class="column5">Contact Number </th>
								<th class="column5">Email</th>
								<th class="column3">House Number</th>
								<th class="column5">Operation</th>
								
							</tr>
						</thead>
						<tbody>
				
						
						<%
						for(CommitteeBean c :cb)
						{
							int id = (c.getMemberId());
						%>
								<tr>
									<td class="column2"><%= c.getMemberId() %></td>
									<td class="column5"><%= c.getName() %></td>
									<td class="column2"><%= c.getPost()%></td>
									<td class="column5"><%= c.getMobileNo() %></td>
									<td class="column5"><%= c.getEmail()%></td>
									<td class="column3"><%= c.getHouseNo()%></td>
									<td class="column7"><%out.print("<a href='deletemember/" + id +" '>"); %>
								
									<button class="contact100-form-btn" style=" min-width: 50px; margin-top: 5px;max-height: 40px;min-height: 25px; max-width: 150px;" value="Delete" >Delete</button>
									<%out.print("<a href='updatefund/" + id +" '>"); %>
									<button class="contact100-form-btn" style=" min-width: 50px;margin-top: 5px;max-height: 40px; min-height: 25px; max-width: 150px;" value="Update" >Update</button></td>		
								</tr>
								
							<%} %>
								
						</tbody>
					</table>
	</div>
<!-- 	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">Complain ID</th>
								<th class="column2">Complain</th>
								<th class="column3">Date</th>
								<th class="column4">Status No</th>
								<th class="column5">Delete</th>
								
							</tr>
						</thead>
						<tbody>
				
						
						
								
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
 <br/> --><br/><br/><br/><br/><br/>
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
<script src="resources/home/js/jquery.min.js"></script>

<!--Popper JS-->
<script src="resources/home/js/popper.min.js"></script>

<!-- Bootstrap JS-->
<script src="resources/home/js/bootstrap.min.js"></script>

<!-- Owl Carousel-->
<script src="resources/home/js/owl.carousel.js"></script>

<!-- Navbar JS -->
<script src="resources/home/js/navigation.js"></script>
<script src="resources/home/js/navigation.fixed.js"></script>

<!-- Wow JS -->
<script src="resources/home/js/wow.min.js"></script>

<!-- Countup -->
<script src="resources/home/js/jquery.counterup.min.js"></script>
<script src="resources/home/js/waypoints.min.js"></script>

<!-- Tabs -->
<script src="resources/home/js/tabs.min.js"></script>

<!-- Yotube Video Player -->
<script src="resources/home/js/jquery.mb.YTPlayer.min.js"></script>

<!-- Swiper Slider -->
<script src="resources/home/js/swiper.min.js"></script>

<!-- Isotop -->
<script src="resources/home/js/isotope.pkgd.min.js"></script>

<!-- Switcher JS -->
<script src="resources/home/js/switcher.js"></script>

<!-- Modernizr -->
<script src="resources/home/js/modernizr.js"></script>

<!-- Google Map -->
<script src="resources/home/js/map.js"></script>

<!-- Chart JS -->
<script src="resources/home/js/Chart.bundle.js"></script>
<script src="resources/home/js/utils.js"></script>

<!-- Revolution Slider -->
<script src="resources/home/js/revolution/jquery.themepunch.tools.min.js"></script>
<script src="resources/home/js/revolution/jquery.themepunch.revolution.min.js"></script>
<script src="resources/home/js/revolution/revolution.extension.actions.min.js"></script>
<script src="resources/home/js/revolution/revolution.extension.carousel.min.js"></script>
<script src="resources/home/js/revolution/revolution.extension.kenburn.min.js"></script>
<script src="resources/home/js/revolution/revolution.extension.layeranimation.min.js"></script>
<script src="resources/home/js/revolution/revolution.extension.migration-2.min.js"></script>
<script src="resources/home/js/revolution/revolution.extension.parallax.min.js"></script>
<script src="resources/home/js/revolution/revolution.extension.navigation.min.js"></script>
<script src="resources/home/js/revolution/revolution.extension.slideanims.min.js"></script>
<script src="resources/home/js/revolution/revolution.extension.video.min.js"></script>

<!-- Main JS -->
<script src="resources/home/js/main.js"></script>

	

</body>
</html>