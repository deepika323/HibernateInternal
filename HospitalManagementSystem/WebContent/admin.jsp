
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sapient HealthCare</title>
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

<c:if test="${empty sessionScope.admin}">
		<c:redirect url="/LogOutController" />
	</c:if>
</head>
<body>
<!--start-home-->
		<!--header-top-->
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
										<li class="menu__item menu__item--current"><a href="" class="menu__link"><span class="menu__helper">Home</span></a></li>

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
						<p>Welcome to <span class="s-p">Medicinal</span>!</p>	
					</div>

				</div>
			</div>
			<div class="slide bg-2">
				<div class="slide-container">
					<div class="slide-content">
						<p>Welcom to <span class="s-p">Medicinal</span>! </p>	

					</div>
				</div>				
			</div>
			<div class="slide bg-3">
				<div class="slide-container">
					<div class="slide-content">
						<p>Welcome to <span class="s-p">Medicinal</span>!</p>	

					</div>
				</div>				
			</div>
			<div class="slide bg-4">
				<div class="slide-container">
					<div class="slide-content">
					<p> Welcome to<span class="s-p">Medicinal</span>! </p>		

					</div>
				</div>				
			</div>
			<div class="slide bg-5">
				<div class="slide-container">
					<div class="slide-content">
					<p>Welcome to <span class="s-p">Medicinal</span>!</p>	

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
						<h3 class="tittle two">ADMIN <span>PORTAL</span></h3>
					</div>
					<div class="medicinal-w3-grids one">
						<div class="col-md-6 medicinal-w3-grid">
							<div class="col-md-8 medicinal-w3-left">
								<h4>APPOINTMENTS</h4>
								<p>&diams;Make Appointments &nbsp;&nbsp;&nbsp;&nbsp;<br>&diams;Remove Appointments  <br>&diams;Update Appointments &nbsp;</p>
							</div>
							<div class="col-md-4 medicinal-w3-right">
								<div class="hi-icon-wrap hi-icon-effect-7 hi-icon-effect-7b">
									<a id="app" class="hi-icon icon1"></a>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="col-md-6 medicinal-w3-grid">
							<div class="col-md-4 medicinal-w3-right">
								<div class="hi-icon-wrap hi-icon-effect-7 hi-icon-effect-7b">
									<a id="app3"  class="hi-icon icon2"></a>
								</div>
							</div>
							<div class="col-md-8 medicinal-w3-left1">
								<h4>DISCHARGE SUMMARY</h4>
								<p>&diams;Create Discharge Summary &nbsp;&nbsp;&nbsp;&nbsp;<br>&diams;Remove Discharge Summary <br>&diams;View Discharge Summary &nbsp;</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="medicinal-w3-grids">
						<div class="col-md-6 medicinal-w3-grid">
							<div class="col-md-8 medicinal-w3-left">
								<h4>MEDICAL REPORT</h4>
								<p></p>
							</div>
							<div class="col-md-4 medicinal-w3-right">
								<div class="hi-icon-wrap hi-icon-effect-7 hi-icon-effect-7b">
									<a id="app2" class="hi-icon icon3"></a>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="col-md-6 medicinal-w3-grid">
							<div class="col-md-4 medicinal-w3-right">
								<div class="hi-icon-wrap hi-icon-effect-7 hi-icon-effect-7b">
									<a  id="app4" class="hi-icon icon4"></a>
								</div>
							</div>
							<div class="col-md-8 medicinal-w3-left1">
								<h4>BILLS</h4>
								<p></p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="medicinal-w3-grids">
						<div class="col-md-6 medicinal-w3-grid">
							<div class="col-md-8 medicinal-w3-left">
								<h4>DEPARTMENT</h4>
								<p>&diams;Create Department &nbsp;&nbsp;&nbsp;&nbsp;<br>&diams;Remove Department &nbsp;</p>
							</div>
							<div class="col-md-4 medicinal-w3-right">
								<div class="hi-icon-wrap hi-icon-effect-7 hi-icon-effect-7b">
									<a   id="app5" class="hi-icon icon1"></a>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="col-md-6 medicinal-w3-grid">
							<div class="col-md-4 medicinal-w3-right">
								<div class="hi-icon-wrap hi-icon-effect-7 hi-icon-effect-7b">
									<a  id="app6" class="hi-icon icon2"></a>
								</div>
							</div>
							<div class="col-md-8 medicinal-w3-left1">
								<h4>DOCTOR</h4>
								<p>&diams;Add Doctor &nbsp;&nbsp;&nbsp;&nbsp;<br>&diams;Remove Doctor <br>&diams;Doctor Details &nbsp;</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="medicinal-w3-grids">
						<div class="col-md-6 medicinal-w3-grid">
							<div class="col-md-8 medicinal-w3-left">
								<h4>STAFF</h4>
								<p></p>
							</div>
							<div class="col-md-4 medicinal-w3-right">
								<div class="hi-icon-wrap hi-icon-effect-7 hi-icon-effect-7b">
									<a id="app7" class="hi-icon icon3"></a>
								</div>
							</div>
							<div class="clearfix"></div>
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
					$("#tender7").hide();
					$("#app").click(function(){
						
						$("#tender").show();
						$("#tender2").hide();	
						$("#tender3").hide();
						$("#tender4").hide();

						$("#tender5").hide();
						$("#tender6").hide();
						$("#tender7").hide();
						$('html, body').animate({
						        scrollTop: $("#tender").offset().top
						    }, 800);
						
													
						});

					

					$("#app5").click(function(){
						
						$("#tender5").show();
						$("#tender").hide();
						$("#tender2").hide();	
						$("#tender3").hide();
						$("#tender4").hide();
						$("#tender7").hide();
						$("#tender6").hide();
						$('html, body').animate({
						        scrollTop: $("#tender5").offset().top
						    }, 800);
						
													
						});

					$("#app6").click(function(){
						
						$("#tender6").show();
						$("#tender5").hide();
						$("#tender").hide();
						$("#tender2").hide();	
						$("#tender3").hide();
						$("#tender4").hide();
						$("#tender7").hide();
						$('html, body').animate({
						        scrollTop: $("#tender6").offset().top
						    }, 800);
						
													
						});
						
					$("#app3").click(function(){
						
						$("#tender3").show();
						$("#tender").hide();	
						$("#tender2").hide();
						$("#tender4").hide();

						$("#tender5").hide();
						$("#tender6").hide();
						$("#tender7").hide();
						$('html, body').animate({
						        scrollTop: $("#tender3").offset().top
						    }, 800);
						
													
						});
					$("#app2").click(function(){
						
						$("#tender2").show();
						$("#tender").hide();
						$("#tender3").hide();
						$("#tender4").hide();

						$("#tender5").hide();
						$("#tender6").hide();	
						$("#tender7").hide();
						$('html, body').animate({
						        scrollTop: $("#tender2").offset().top
						    }, 800);
						
													
						});

						$("#app7").click(function(){
						
						$("#tender7").show();
						$("#tender").hide();
						$("#tender3").hide();
						$("#tender4").hide();

						$("#tender5").hide();
						$("#tender6").hide();
						$("#tender2").hide();	
						$('html, body').animate({
						        scrollTop: $("#tender7").offset().top
						    }, 800);
						
													
						});
					
					$("#app4").click(function(){
						
						$("#tender2").hide();
						$("#tender4").show();
						$("#tender").hide();
						$("#tender3").hide();

						$("#tender5").hide();
						$("#tender6").hide();	
						$("#tender7").hide();
						$('html, body').animate({
						        scrollTop: $("#tender4").offset().top
						    }, 800);
						
													
						});
					
				});
				</script>
				
			<!-- appointment -->
			<div class="grid_2" id="tender">
   	 <div class="container">
	       <div class="sub-hd">
						<h3 class="tittle">SELECT <span>FUNCTIONALITY</span></h3>
					</div>
   	  <div class="box_1 one">
   	 	<div class="col-md-6">
   	 	       <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="./AddAppointment"><img src="images/n1.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>CREATE APPOINTMENT</h3>
				   	  <p></p>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>CREATE APPOINTMENT</h4>
				   <p class="p1">abcd</p>
 				</div>
				<div class="clearfix"></div>
		</div>
   	 	<div class="col-md-6">
   	 	      <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a name="find" href="./FindOrRemoveController?selectedValue=Update"><img src="images/n5.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>UPDATE APPOINTMENT</h3>
				   	  <p></p>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>UPDATE APPOINTMENT</h4>
				   <p class="p1">abcd</p>
 				</div>
				<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
   	  </div>
   	  <div class="box_2">
   	 	<div class="col-md-6">
   	 	       <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a name="find"  href="./FindOrRemoveController?selectedValue=Remove"><img src="images/n3.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>REMOVE APPOINTMENT</h3>
				   	 
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>REMOVE APPOINTMENT</h4>
				   <p class="p1">abcd</p>
 				</div>
				<div class="clearfix"></div>
		</div>
   	 	<div class="col-md-6">
   	 	      <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a name="find"  href="./FindOrRemoveController?selectedValue=Find"><img src="images/n4.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>VIEW APPOINTMENT</h3>
				   	  <p></p>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>VIEW APPOINTMENT</h4>
				   <p class="p1">abcd</p>
 				</div>
				<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
   	  </div>
   	 </div>
   </div>
   
<!-- Discharge Summary -->
			<div class="grid_2" id="tender3">
   	 <div class="container">
	       <div class="sub-hd">
						<h3 class="tittle">SELECT <span>FUNCTIONALITY</span></h3>
					</div>
   	  <div class="box_1 one">
   	 	<div class="col-md-6">
   	 	       <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="addDischargeSummary.jsp"><img src="images/n1.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>CREATE DISCHARGE SUMMARY</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>CREATE DISCHARGE SUMMARY</h4>
				   <p class="p1">abcd</p>
 				</div>
				<div class="clearfix"></div>
		</div>
   	 	<div class="col-md-6">
   	 	      <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="./FindorRemoveDischargeSummaryController?selectedValue=Find"><img src="images/n5.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>VIEW DISCHARGE SUMMARY</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>VIEW DISCHARGE SUMMARY</h4>
				   <p class="p1">qwerty</p>
 				</div>
				<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
   	  </div>
   	  <div class="box_2">
   	 	<div class="col-md-6">
   	 	      <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="./FindorRemoveDischargeSummaryController?selectedValue=Remove"><img src="images/n4.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>REMOVE DISCHARGE SUMMARY</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>REMOVE DISCHARGE SUMMARY</h4>
				   <p class="p1">abcd</p>
 				</div>
				<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
   	  </div>
   	 </div>
   </div>
<!-- Doctor -->
			<div class="grid_2" id="tender6">
   	 <div class="container">
	       <div class="sub-hd">
						<h3 class="tittle">SELECT <span>FUNCTIONALITY</span></h3>
					</div>
   	  <div class="box_1 one">
   	 	<div class="col-md-6">
   	 	       <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="./AddDoctor"><img src="images/n1.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>CREATE DOCTOR</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>CREATE DOCTOR</h4>
				   <p class="p1">abcd</p>
 				</div>
				<div class="clearfix"></div>
		</div>
   	 	<div class="col-md-6">
   	 	      <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="removeDoctor.jsp"><img src="images/n5.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>REMOVE DOCTOR</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>REMOVE DOCTOR</h4>
				   <p class="p1">qwerty</p>
 				</div>
				<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
   	  </div>
   	  
   	 </div>
   </div>
      
<!-- Department -->
			<div class="grid_2" id="tender5">
   	 <div class="container">
	       <div class="sub-hd">
						<h3 class="tittle">SELECT <span>FUNCTIONALITY</span></h3>
					</div>
   	  <div class="box_1 one">
   	 	<div class="col-md-6">
   	 	       <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="./AddDepartment"><img src="images/n1.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>CREATE DEPARTMENT</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>CREATE DEPARTMENT</h4>
				   <p class="p1">abcd</p>
 				</div>
				<div class="clearfix"></div>
		</div>
   	 	<div class="col-md-6">
   	 	      <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="removeDepartment.jsp"><img src="images/n5.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>REMOVE DEPARTMENT</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>REMOVE DEPARTMENT</h4>
				   <p class="p1">qwerty</p>
 				</div>
				<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
   	  </div>
   	  
   	 </div>
   </div>
   
<!-- Bill -->
			<div class="grid_2" id="tender4">
   	 <div class="container">
	       <div class="sub-hd">
						<h3 class="tittle">SELECT <span>FUNCTIONALITY</span></h3>
					</div>
   	  <div class="box_1 one">
   	 	<div class="col-md-6">
   	 	       <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="./AddBillPID.jsp"><img src="images/n1.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>CREATE BILLS</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>CREATE BILLS</h4>
				   <p class="p1">abcd</p>
 				</div>
				<div class="clearfix"></div>
		</div>
   	 	<div class="col-md-6">
   	 	      <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="./FindOrRemoveBillController?selectedValue=Find"><img src="images/n5.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>VIEW BILLS</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>VIEW BILLS</h4>
				   <p class="p1">qwerty</p>
 				</div>
				<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
   	  </div>
   	  <div class="box_2">
   	 	<div class="col-md-6">
   	 	       <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="./FindOrRemoveBillController?selectedValue=Update"><img src="images/n3.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>UPDATE BILLS</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>UPDATE BILLS</h4>
				   <p class="p1">abcd</p>
 				</div>
				<div class="clearfix"></div>
		</div>
   	 	<div class="col-md-6">
   	 	      <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="./FindOrRemoveBillController?selectedValue=Remove"><img src="images/n4.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>REMOVE BILLS</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>REMOVE BILLS</h4>
				   <p class="p1">abcd</p>
 				</div>
				<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
   	  </div>
   	 </div>
   </div>
   
   
<!-- Medical Report -->
			<div class="grid_2" id="tender2">
   	 <div class="container">
	       <div class="sub-hd">
						<h3 class="tittle">SELECT <span>FUNCTIONALITY</span></h3>
					</div>
   	  <div class="box_1 one">
   	 	<div class="col-md-6">
   	 	       <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="findMR.jsp"><img src="images/n1.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>VIEW MEDICAL REPORT</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>VIEW MEDICAL REPORT</h4>
				   <p class="p1">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim venia.</p>
 				</div>
				<div class="clearfix"></div>
		</div>
   	 	
		
   	  </div>
   	 </div>
   </div>
   
   <!-- Staff -->
			<div class="grid_2" id="tender7">
   	 <div class="container">
	       <div class="sub-hd">
						<h3 class="tittle">SELECT <span>FUNCTIONALITY</span></h3>
					</div>
   	  <div class="box_1 one">
   	 	<div class="col-md-6">
   	 	       <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="addStaff.jsp"><img src="images/n1.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>ADD STAFF</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>ADD STAFF</h4>
				   <p class="p1">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim venia.</p>
 				</div>
				<div class="clearfix"></div>
		</div>
   	 	<div class="col-md-6">
   	 	      <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="removeStaff.jsp"><img src="images/n5.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>REMOVE STAFF</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>REMOVE STAFF</h4>
				   <p class="p1">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim venia.</p>
 				</div>
				<div class="clearfix"></div>
		</div>
		<div class="col-md-6">
   	 	      <div class="col_1_of_2 span_1_of_2 multi-gd-text">
				   <a href="getStaffId.jsp"><img src="images/n5.jpg" class="img-responsive" alt=""></a>
				   <div class="story_desc">
				   	  <h3>MODIFY STAFF</h3>
				   </div>
 				</div>
				<div class="col_1_of_2 span_1_of_2">
				   <h4>MODIFY STAFF</h4>
				   <p class="p1">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim venia.</p>
 				</div>
				<div class="clearfix"></div>
		</div>
		
   	  </div>
   	 </div>
   </div>
   
   <!--
   <div id="abcd">
   <jsp:include page="ErrorPage.jsp"></jsp:include>
   </div>
   
   
   <script type="text/javascript">
   							
   					$(document).ready(function()
   					{
   						//$("#abcd").hide();
										
										$("listmr").click(function()
												{
													$("abcd").hide();
												});
   					});
										</script>-->
      <!--//news-->
   <!--  <div class="bottom">
		<div class="container">
			<div class="bottom-top">
				<h3>Opening Hours of <span class="opening">Medicinal</span></h3>
				<p>Phasellus tempor erat id erat gravida pulvinar. Aenean est felis, ullamcorper et volutpat sed, cursus at enim. Vestibulum vel finibus neque. In sed magna tellus.</p>
				<div class="opening_hours">
						 <ul class="times">
							<h4>Opening <span class="opening">Hours</span></h4>
							<li><i class="glyphicon glyphicon-time"> </i><span class="week">Monday</span><div class="hours">9:30 am - 3:30 pm</div>  <div class="clearfix"></div></li>
							<li><i class="glyphicon glyphicon-time"> </i><span class="week">Tuesday</span><div class="hours">10:30 am - 5:30 pm</div>  <div class="clearfix"></div></li>
							<li><i class="glyphicon glyphicon-time"> </i><span class="week">Wednesday</span><div class="hours">8:30 am - 1:30 pm</div>  <div class="clearfix"></div></li>
							<li><i class="glyphicon glyphicon-time"> </i><span class="week">Thrusday</span><div class="hours">11:30 am - 2:30 pm</div>  <div class="clearfix"></div></li>
							<li><i class="glyphicon glyphicon-time"> </i><span class="week">Friday</span><div class="hours">10:00 am - 2:00 pm</div>  <div class="clearfix"></div></li>
							<li><i class="glyphicon glyphicon-time"> </i><span class="week">Saturday</span><div class="hours">11:30 am - 2:30 pm</div>  <div class="clearfix"></div></li>
							<li><i class="glyphicon glyphicon-time"> </i><span class="week">Sunday</span><div class="hours">Family Doctor</div>  <div class="clearfix"></div></li>
	
						 </ul>
					</div>
			</div>
		</div>
</div>
   <!--/reviews-->
	<!--  <div id="review" class="testimonials-review">
		<div class="container">
		<div class="sub-hd">
						<h3 class="tittle lost">WHAT PATIENTS ARE SAYING <span>ABOUT US</span></h3>
					</div>
				<div class="testimonials">
				  <div class="monials">
				      <!--//screen-gallery-->
						<div class="sreen-gallery-cursual">
							 <!-- required-js-files-->
							<!--  <link href="css/owl.carousel.css" rel="stylesheet">
							    <script src="js/owl.carousel.js"></script>
							        <script>
							    $(document).ready(function() {
							      $("#owl-demo").owlCarousel({
							        items : 1,
							        lazyLoad : true,
							        autoPlay : true,
							        navigation : false,
							        navigationText :  false,
							        pagination : true,
							      });
							    });
							    </script>
								 <!--//required-js-files-->
						       <!--  <div id="owl-demo" class="owl-carousel">
					                   <div class="item-owl">

                                            <p class="speech">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id arcu neque, at convallis est felis.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id arcu neque, at convallis est felis.</p>
                                            <div class="client-info">
                                                <img src="images/t1.jpg" alt=" " />

                                                <h4>John Allen</h4>
                                                <span>Lorem ipsum dolor</span>
                                            </div>
                                        </div><!-- /.item -->
					                     <!--  <div class="item-owl">

                                            <p class="speech">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id arcu neque, at convallis est felis.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id arcu neque, at convallis est felis.</p>
                                            <div class="client-info">
                                                <img src="images/t2.jpg" alt=" " />

                                                <h4>John Doe</h4>
                                                <span>Lorem ipsum dolor</span>
                                            </div>
                                        </div><!-- /.item -->
					                      <!--  <div class="item-owl">
										  <p class="speech">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id arcu neque, at convallis est felis.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque id arcu neque, at convallis est felis.</p>
                                            <div class="client-info">
                                                <img src="images/t3.jpg" alt=" " />

                                                <h4>John Leo</h4>
                                                <span>Lorem ipsum dolor</span>
                                            </div>
                                        </div><!-- /.item -->
				              <!--  </div>-->
						<!--//screen-gallery-->
					<!--  </div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>-->	
	<!--//reviews-->
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