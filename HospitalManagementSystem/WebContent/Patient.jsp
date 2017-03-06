

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sapient HealthCare</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Medicinal Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="applisalonion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />	
<link rel="stylesheet" href="css/slider.css">
<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!--/web-font-->
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
<!--/script-->
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
</script>

<c:if test="${empty sessionScope.personId}">
		<c:redirect url="/LogOutController" />
	</c:if>
<!--  
<script>
		var audio = new Audio('patient.mp3');
		audio.play();
		</script> 
-->
</head>
<body>
<div class="header-top">
			  <div class="container">
					 <nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
					  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					  </button>
						<div class="logo">
							</a><img src="images/logo.png" alt=" " /></h1>
							<h1><a class="navbar-brand" href="index.jsp"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sapient</span>HealthCare&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						  <div class="top-menu">
							<nav class="menu menu--francisco">
									<ul class="nav navbar-nav menu__list">
										<li class="menu__item menu__item--current"><a href="Patient.jsp" class="menu__link"><span class="menu__helper">Patient</span></a></li>
										<li class="menu__item"><a href="./LogOutController" class="menu__link"><span class="menu__helper">Log Out</span></a></li>
										<li class="menu__item"><a href="./HospitalInfo" class="menu__link"><span class="menu__helper">Hospital Info</span></a></li>
									</ul>
								</nav>
							</div>
					</div>
					<!-- /.navbar-collapse -->
				</nav>

			   <div class="clearfix"></div>
			</div>
	</div>
<br><br>
<!--//header-top-->
 <!-- //Line Slider -->
	 <div class="top_banner">
		<!-- SVG Arrows -->
		<div class="svg-wrap">
			<svg width="64" height="64" viewBox="0 0 64 64">
				<path id="arrow-left" d="M46.077 55.738c0.858 0.867 0.858 2.266 0 3.133s-2.243 0.867-3.101 0l-25.056-25.302c-0.858-0.867-0.858-2.269 0-3.133l25.056-25.306c0.858-0.867 2.243-0.867 3.101 0s0.858 2.266 0 3.133l-22.848 23.738 22.848 23.738z" />
			</svg>
			<svg width="64" height="64" viewBox="0 0 64 64">
				<path id="arrow-right" d="M17.919 55.738c-0.858 0.867-0.858 2.266 0 3.133s2.243 0.867 3.101 0l25.056-25.302c0.858-0.867 0.858-2.269 0-3.133l-25.056-25.306c-0.858-0.867-2.243-0.867-3.101 0s-0.858 2.266 0 3.133l22.848 23.738-22.848 23.738z" />
			</svg>
		</div>
		
		<div class="sleekslider">
			<!-- Slider Pages -->
			<div class="slide active bg-1">
				<div class="slide-container">
					<div class="slide-content">
						<p>Welcome to <span class="s-p">Our Hospital</span>!</p>	
					</div>

				</div>
			</div>
			<div class="slide bg-2">
				<div class="slide-container">
					<div class="slide-content">
						<p>Welcome to <span class="s-p">Our Hospital</span>! </p>	

					</div>
				</div>				
			</div>
			<div class="slide bg-3">
				<div class="slide-container">
					<div class="slide-content">
						<p>Welcome to <span class="s-p">Our Hospital</span>!</p>	

					</div>
				</div>				
			</div>
			<div class="slide bg-4">
				<div class="slide-container">
					<div class="slide-content">
					<p> Welcome to<span class="s-p">Our Hospital</span>! </p>		

					</div>
				</div>				
			</div>
			<div class="slide bg-5">
				<div class="slide-container">
					<div class="slide-content">
					<p>Welcome to <span class="s-p">Our Hospital</span>!</p>	

					</div>
				</div>				
			</div>

			<!-- Navigation Arrows with Thumbnails -->
			<nav class="nav-split">
				<a class="prev" href="">
					<span class="icon-wrap"><svg class="icon" width="22" height="22" viewBox="0 0 64 64"><use xlink:href="#arrow-left" /></svg></span>
					<div>
						<h3>test</h3>
						<img alt="Previous thumb"/>
					</div>
				</a>
				<a class="next" href="">
					<span class="icon-wrap"><svg class="icon" width="22" height="22" viewBox="0 0 64 64"><use xlink:href="#arrow-right" /></svg></span>
					<div>
						<h3>test</h3>
						<img alt="Next thumb"/>
					</div>
				</a>
			</nav>

			<!-- Pagination -->
			<nav class="pagination">
				<span class="current"></span>
				<span></span>
				<span></span>
				<span></span>
				<span></span>
			</nav>

			<!-- Navigation Tabs -->
			<nav class="tabs">
				<div class="tab-container">
					  <ul>
						<li class="current"><a href="#"><span>01</span> Slide</a></li>
						<li><a href="#"><span>02</span> Slide</a></li>
						<li><a href="#"><span>03</span> Slide</a></li>
						<li><a href="#"><span>04</span> Slide</a></li>
						<li><a href="#"><span>05</span> Slide</a></li>
					</ul>
				</div>
			</nav>
		</div>

		<!-- JavaScripts -->
		<script type="text/javascript" src="js/sleekslider.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
      <!--welcome-->
 </div>

        <!-- /Line Slider -->
	</div>
    <!--footer-->
	
		<!-- Services -->
				<!-- //Services -->
		<!--medicinal-->
			<div class="medicinal-w3">
				<div class="container">
				    <div class="sub-hd">
						<h3 class="tittle two">PATIENT <span>SERVICES</span></h3>
					</div>
					<div class="medicinal-w3-grids one">
						<div class="col-md-6 medicinal-w3-grid">
							<div class="col-md-8 medicinal-w3-left">
								<h4>LIST APPOINTMENTS</h4>
								<p></p>
							</div>
							<div class="col-md-4 medicinal-w3-right">
								<div class="hi-icon-wrap hi-icon-effect-7 hi-icon-effect-7b">
								<c:set var="personId" scope="session" value="${personId}"/><%--MANAGE VALUES --%>
									<a id="app" class="hi-icon icon1" href="./AppointmentServlet"></a>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="col-md-6 medicinal-w3-grid">
							<div class="col-md-4 medicinal-w3-right">
								<div class="hi-icon-wrap hi-icon-effect-7 hi-icon-effect-7b">
								<c:set var="personId" scope="session" value="${personId}"/><%--MANAGE VALUES --%>
									<a id="app3"  class="hi-icon icon2" href="./MedicalReport" ></a>
								</div>
							</div>
							<div class="col-md-8 medicinal-w3-left1">
								<h4>VIEW MEDICAL REPORT</h4>
								<p></p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="medicinal-w3-grids">
						<div class="col-md-6 medicinal-w3-grid">
							<div class="col-md-8 medicinal-w3-left">
								<h4>VIEW DISCHARGE SUMMARY</h4>
								<p></p>
							</div>
							<div class="col-md-4 medicinal-w3-right">
								<div class="hi-icon-wrap hi-icon-effect-7 hi-icon-effect-7b" >
									<c:set var="personId" scope="session" value="${personId}"/><%--MANAGE VALUES --%>
									<a id="app2" class="hi-icon icon3" href="./DischargeSummary" ></a>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="col-md-6 medicinal-w3-grid">
							<div class="col-md-4 medicinal-w3-right">
								<div class="hi-icon-wrap hi-icon-effect-7 hi-icon-effect-7b">
								<c:set var="personId" scope="session" value="${personId}"/><%--MANAGE VALUES --%>
									<a  id="app4" class="hi-icon icon4" href="./Bill"></a>
								</div>
							</div>
							<div class="col-md-8 medicinal-w3-left1">
								<h4>VIEW BILLS</h4>
								<p></p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="medicinal-w3-grids">
						<div class="col-md-6 medicinal-w3-grid">
							<div class="col-md-8 medicinal-w3-left">
								<h4>VIEW MEDICINES</h4>
								<p></p>
							</div>
							<div class="col-md-4 medicinal-w3-right">
								<div class="hi-icon-wrap hi-icon-effect-7 hi-icon-effect-7b">
								<c:set var="personId" scope="session" value="${personId}"/><%--MANAGE VALUES --%>
									<a   id="app5" class="hi-icon icon1" href="./Medicine"></a>
								</div>
							</div>
							
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			</div>
			
			
			
			
			
			
			<!--medicinal-->
			
			<script type="text/javascript">					
				$(document).ready(function(){

					$("#tender").hide();
					$("#tender2").hide();
					$("#tender3").hide();
					$("#tender4").hide();
					$("#tender5").hide();
					$("#tender6").hide();
					$("#app").click(function(){
						
						$("#tender").show();
						$("#tender2").hide();	
						$("#tender3").hide();
						$("#tender4").hide();

						$("#tender5").hide();
						$("#tender6").hide();
						$('html, body').animate({
						        scrollTop: $("#tender").offset().top
						    }, 1000);
						
													
						});

					

					$("#app5").click(function(){
						
						$("#tender5").show();
						$("#tender").hide();
						$("#tender2").hide();	
						$("#tender3").hide();
						$("#tender4").hide();

						$("#tender6").hide();
						$('html, body').animate({
						        scrollTop: $("#tender5").offset().top
						    }, 1000);
						
													
						});

					$("#app6").click(function(){
						
						$("#tender6").show();
						$("#tender5").hide();
						$("#tender").hide();
						$("#tender2").hide();	
						$("#tender3").hide();
						$("#tender4").hide();
						$('html, body').animate({
						        scrollTop: $("#tender6").offset().top
						    }, 1000);
						
													
						});
						
					$("#app3").click(function(){
						
						$("#tender3").show();
						$("#tender").hide();	
						$("#tender2").hide();
						$("#tender4").hide();

						$("#tender5").hide();
						$("#tender6").hide();
						$('html, body').animate({
						        scrollTop: $("#tender3").offset().top
						    }, 1000);
						
													
						});
					$("#app2").click(function(){
						
						$("#tender2").show();
						$("#tender").hide();
						$("#tender3").hide();
						$("#tender4").hide();

						$("#tender5").hide();
						$("#tender6").hide();	
						$('html, body').animate({
						        scrollTop: $("#tender2").offset().top
						    }, 1000);
						
													
						});
					$("#app4").click(function(){
						
						$("#tender2").hide();
						$("#tender4").show();
						$("#tender").hide();
						$("#tender3").hide();

						$("#tender5").hide();
						$("#tender6").hide();	
						$('html, body').animate({
						        scrollTop: $("#tender4").offset().top
						    }, 1000);
						
													
						});
					
				});
				</script>
				
			
   

   
		
	<!--/start-footer-section-->
			<div class="footer-section">
				<div class="container">
					<div class="footer-grids wow bounceIn animated" data-wow-delay="0.4s">
						<div class="col-md-3 footer-grid">
						<h4>About <span>Medicinal</span></h4>
						<div class="border2"></div>
						  <p class="sub">Sapient Healthcare Limited is a leading integrated healthcare delivery service provider in India. The healthcare verticals of the company primarily comprise hospitals, diagnostics and day care specialty facilities. Currently, the company operates its healthcare delivery services in India, Dubai, Mauritius and Sri Lanka with 45 healthcare facilities (including projects under development), approximately 10,000 potential beds and 314 diagnostic centres.</p>
						</div>
						<div class="col-md-3 footer-grid tags">
								<h4><span>Contact </span>Us</h4>
								<div class="border2"></div>
							<p class="sub">Unitech Infospace,<br>
							 				Tower A Building 2,<br>
							 				Sector 21 Old Delhi,<br>
							 				Gurgaon Road Dundahera,<br>
							 				Gurugram, Haryana 122016<br>
							 				Phone: 0124 499 6000</p>
						</div>
						<div class="col-md-3 footer-grid tweet">
								<h4>Latest <span>Tweets</span></h4>
								<div class="border2"></div>
								<div class="icon-3-square">
										<a href="#"><i class="square-3"></i></a>
									</div>
							<div class="icon-text">
								<p>I feel very lucky!!! #SapientHealthCare<a href="#"> @SamuelLJackson </a></p>
								<h5>15 mins ago</h5>
							</div>
								<div class="clearfix"></div>
								<div class="icon-3-square">
										<a href="#"><i class="square-3"></i></a>
								</div>
								<div class="icon-text">
								    <p>I feel blessed!!! #SapientHealthCare<a href="#"> @JasonStatham </a> </p>
									<h5>15 mins ago</h5>
								</div>
								<div class="clearfix"></div>
						</div>
						<div class="col-md-3 footer-grid flickr">
								<h4>Flickr <span>Feed </span></h4>
								<div class="border2"></div>
								<div class="flickr-grids">
										<div class="flickr-grid">
											<a href="#"><img src="images/t1.jpg" alt=" " title="Senior Surgeon(Cardiology)" /></a>
										</div>
										<div class="flickr-grid">
											<a href="#"><img src="images/t2.jpg" alt=" " title="Surgeon(Cardiology)" /></a>
										</div>
										<div class="flickr-grid">
											<a href="#"><img src="images/t3.jpg" alt=" " title="Junior Surgeon(Cardiology)" /></a>
										</div>
										<div class="clearfix"> </div>
										
										<div class="flickr-grid">
											<a href="#"><img src="images/t2.jpg" alt=" " title="Senior Surgeon(Neurology)" /></a>
										</div>
										<div class="flickr-grid">
											<a href="#"><img src="images/t3.jpg" alt=" " title="Surgeon(Neurology)" /></a>
										</div>
										<div class="flickr-grid">
											<a href="#"><img src="images/t1.jpg" alt=" " title="Junior Surgeon(Neurology)" /></a>
										</div>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
			</div>
		</div>
	<!--//end-footer-section-->
	<!--//footer-->
	<div class="footer-bottom">
		<div class="container">
			<p>© 2017 Sapient Hospital. All rights reserved | Design by <a href="http://sapient.com">Deepika,  Chinmay,  Debanjan & Tushar</a></p>
		</div>
	</div>
		<!--start-smooth-scrolling-->
						<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
								<!--end-smooth-scrolling-->
		<a href="#house" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	<script src="js/bootstrap.js"></script>


</body>
</html>