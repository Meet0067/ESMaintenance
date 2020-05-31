<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.bean.UserBean"%>
    
<!DOCTYPE html>

<html lang="zxx">

  <title>Welcome</title>
  
<!-- Mirrored from www.chsonline.in/ by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 08 Mar 2020 13:51:44 GMT -->
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

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
  

<!-- Navbar START -->
<header id="nav-transparent">
  <nav id="navigation4" class="container navigation">
    <div class="nav-header">
      <a class="nav-brand" href="index-2.html">
       
      </a>
      <div class="nav-toggle"></div>
    </div>
    <div class="nav-menus-wrapper">
      <ul class="nav-menu align-to-right">
        <li><a href="index">Home</a>
        </li>    
        	
         <li><a>Features</a>
          <ul class="nav-dropdown">
        <li><a href="shownoticeuser">Notice</a></li>
        <li><a href="complain">Complain<span class="menu-tag">NEW</span></a></li>
		<li><a href="showfunds_user">Funds<span class="menu-tag">NEW</span></a></li>
        <li><a href="vendorUserList">Facility<span class="menu-tag">NEW</span></a></li>
        
        </ul></li>
		<li><a href="login">Login</a></li>
		<li><a href="signup">Signup</a></li>
		
        <li><a href="#">Contact Us</a>                                         
	  </ul>	  
    </div>
  </nav>
</header>
<!-- Navbar END -->
</head>
<body>

<!-- Start revolution slider -->
<div class="rev_slider_wrapper fs-slider-wrap bg-arrows">
  <div id="rev_slider" class="rev_slider fullscreenbanner">
    <ul>
      <!-- Slide 1 -->
      <li data-delay="5000" data-transition="slidingoverlayleft" data-slotamount="7" data-masterspeed="2500" data-fsmasterspeed="1000">

        <!-- Main image-->
        <img src="resources/home/img/Slider12.jpg" alt="" data-bgposition="right center" data-bgfit="cover" data-bgrepeat="no-repeat" class="rev-slidebg">

        <!-- Layer 1 -->
        <div class="slide-title tp-caption tp-resizeme text-center"
             data-x="['center','center','center','center']" data-hoffset="['0','0','0','0']"
             data-y="['middle','middle','middle','middle']" data-voffset="['-30','-30', '-150', '-350']"
             data-fontsize="['55','55', '50', '115']"
             data-fontweight="700"
             data-lineheight="['80','80', '70', '135']"
             data-width="['1200','991','650']"
             data-height="none"
             data-color="#fff"
             data-whitespace="normal"
             data-transform_idle="o:1;"
             data-transform_in="x:[105%];z:0;rX:45deg;rY:0deg;rZ:90deg;sX:1;sY:1;skX:0;skY:0;s:2000;e:Power2.easeInOut;"
             data-transform_out="y:[100%];s:1000;e:Power2.easeInOut;s:1000;e:Power2.easeInOut;"
             data-mask_in="x:50px;y:0px;s:inherit;e:inherit;"
             data-mask_out="x:inherit;y:inherit;s:inherit;e:inherit;"
             data-frames='[{"delay":700,"speed":2500,"frame":"0","from":"y:bottom;rX:-20deg;rY:-20deg;rZ:0deg;","to":"o:1;","ease":"Power3.easeOut"},{"delay":"wait","speed":1000,"frame":"999","to":"auto:auto;","ease":"Power3.easeInOut"}]'
             data-start="500"
             data-responsive_offset="on"
             data-elementdelay="0.05">Enhance the living experience
        </div>
 </li>
    </ul>
  </div>
</div>
<!-- Feature Boxes Start -->
    <div class="section-block-grey">
  <div class="container">
    <div class="section-heading center-holder">
      <span>Key features</span>
      <h3>All the Tools You Need</h3>
      <div class="section-heading-line"></div>
    <p>To manage Cooperative Housing Society and Resident Welfare Association professionally.</p>
    </div>
    <div class="row mt-50">
      
       <div class="col-md-3 col-sm-6 col-8">
       <div class="feature-box">
          <i class="icon-smartphone-1"></i>
          <h4>Notice</h4>
        </div>
    </div>
      
       <div class="col-md-3 col-sm-6 col-8">
       	     	
        <div class="feature-box">
          <i class="icon-note2"></i>
          <h4>Complain</h4>
        </div>
      </div>
         
      <div class="col-md-3 col-sm-6 col-8">
      
        <div class="feature-box">
          <i class="icon-agreement2"></i>
          <h4>Complain Status</h4>
        </div>
      </div>
          
    <div class="col-md-3 col-sm-6 col-8">
     <div class="feature-box">
          <i class="icon-team2"></i>
          <h4>Committee</h4>
        </div>
      </div>
      
         <div class="col-md-3 col-sm-6 col-8">
	 
           <div class="feature-box">
          <i class="icon-bar-graph-12"></i>
          <h4>Funds</h4>
        </div>
      </div>


      <div class="col-md-3 col-sm-6 col-8">
        <div class="feature-box">
          <i class="icon-wallet2"></i>
          <h4>Your Payments</h4>
        </div>
      
      </div>
     
      <div class="col-md-3 col-sm-6 col-8">
        <div class="feature-box">
          <i class="icon-building"></i>
          <h4>Accounting</h4>
        </div>
      </div>

      
      <div class="col-md-3 col-sm-6 col-8">
        <div class="feature-box">
          <i class=" icon-network"></i>
          <h4>Facility</h4>
        </div>
    </div>
    
    </div>
    
     <div class="section-heading center-holder">
      <br><br><br>
      <h3>Coming Soon..</h3>
      <div class="section-heading-line"></div>
		<br><br>
    </div>	
    <div class ="row mt-50">
 
    
   
      <div class="col-md-3 col-sm-6 col-8">
        <div class="feature-box">
          <i class=" icon-wallet2"></i>
          <h4>Payment Gateway</h4>
        </div>
      </div>

      <div class="col-md-3 col-sm-6 col-8">
        <div class="feature-box">
          <i class="icon-stationery"></i>
          <h4>Mobile Apps</h4>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 col-8">
        <div class="feature-box">
          <i class="icon-man2"></i>
          <h4>Tenant</h4>
        </div>
      </div>

      <div class="col-md-3 col-sm-6 col-8">
        <div class="feature-box">
          <i class="icon-delivery-truck2"></i>
          <h4>Vehicle</h4>
        </div>
      </div>

      <div class="col-md-3 col-sm-6 col-8">
        <div class="feature-box">
          <i class="icon-id-card2"></i>
          <h4>Membership</h4>
        </div>
      </div>

      <div class="col-md-3 col-sm-6 col-8">
        <div class="feature-box">
          <i class="icon-search-2"></i>
          <h4>Vendor</h4>
        </div>
    </div>
      <div class="col-md-3 col-sm-6 col-8">
        <div class="feature-box">
          <i class="icon-piggy-bank2"></i>
          <h4>Investments</h4>
        </div>
      </div>
   

      <div class="col-md-3 col-sm-6 col-8">
        <div class="feature-box">
          <i class="icon-building"></i>
          <h4>Property Management</h4>
        </div>
    
    </div>
 		   
    </div>
  </div>
<!-- Feature Boxes End -->
 <!--Features Section START-->
  <div class="container">
    <div class="section-heading center-holder"><br><br>
    <span>Housing Societies</span>
                <div class="section-heading-line"></div>
      <h3>Everything you need to run your society</h3>
      <p>It's time to make society administration rewarding.</p>
    </div>
  </div>
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
          <li><a href="home">Home</a></li>
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

<!-- Mirrored from www.chsonline.in/ by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 08 Mar 2020 13:52:22 GMT -->
</html>