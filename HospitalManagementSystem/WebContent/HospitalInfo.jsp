
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet" href="css/swipebox.css">
<link href="css/style.css" rel='stylesheet' type='text/css' />	
<link rel="stylesheet" href="css/slider.css">
<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
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
<script>
		var audio = new Audio('abc.mp3');
		audio.play();
		</script>


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
										<li class="menu__item menu__item--current"><a href="" class="menu__link"><span class="menu__helper">Hospital Info</span></a></li>
										<li class="menu__item"><a href="" onclick="history.go(-1);" class="menu__link"><span class="menu__helper">Back</span></a></li>
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
		<div class="top_banner two">
			<div class="container">
			       <div class="sub-hd-inner">
						<h3 class="tittle">OUR <span>DEPARTMENTS</span></h3>
					</div>
			</div>
		</div>
		
		
		<script>
angular.module('myApp', []).controller('namesCtrl', function($scope) {
	$scope.doctor = [];

	
	 <c:forEach var="element" items="${doctorList}" varStatus="status">
     $scope.doctor.push({name: '${element.doctorName}',id: '${element.doctorId}'});   
 </c:forEach>


	$scope.department = [];

	
	 <c:forEach var="element" items="${departmentList}" varStatus="status">
    $scope.department.push({name: '${element.departmentName}',id: '${element.departmentId}'});   
</c:forEach>
	 
});
</script>
		
<div ng-app="myApp" ng-controller="namesCtrl">

<!-- <p>Looping with objects:</p>
<ul>
  <li ng-repeat="x in doctor">
    {{x.name +','+x.id}}
  </li>
</ul>
<ul>
  <li ng-repeat="x in department | filter:test">
    {{x.name +','+x.id}}
  </li>
</ul>-->
		
			<!--/gallery-->	
<div id="gallery" class="gallery">
	<div class="container">
		<div class="gallery_gds w3l">
			<ul class="simplefilter wow zoomIn" data-wow-duration="1.5s" data-wow-delay="0.1s">
                
                <li id="1" data-filter="1">DEPARTMENTS</li>
                <li id="2" data-filter="2">DOCTORS</li>

            </ul>

            


            <div class="filtr-container wow zoomIn" data-wow-duration="1.5s" data-wow-delay="0.1s">
                       	<script>
	$(document).ready(function(){

		$("#test").hide();
		$("#test2").hide();

		$("#1").click(function(){
			$("#test").show();
			$('.doctor').hide();
			$('.department').show();
			$("#test2").hide();
			});
		$("#2").click(function(){
			$("#test2").show();
			$('.doctor').show();
			$('.department').hide();
			$("#test").hide();
			});
		$("#0").click(function(){
			$("#test2").hide();
			$("#test").hide();
			});

		});



	</script>
     <p><input id="test" type="text" placeholder="Search Department " ng-model="test"></p>       
     <div  class="department" ng-repeat="x in department | filter:test" id={{x.id}}>
                <div class=" col-md-4 filtr-item" data-category="1" data-sort="Busy streets">
     
					<a href="./DisplayDepartment?deptId={{x.id}}" >
						<div class="item item-type-double">
							<div class="item-hover">
								<div class="item-info">
									<div class="date">{{x.name}}</div>			
									<div class="line"></div>			
									<div class="headline">{{x.name}}</div>
									<div class="line"></div>
								</div>
								<div class="mask"></div>
							</div>
							<div class="item-img"><img src="images/g1.jpg"  height="280" width="280" alt=" " /></div>
						</div>
					</a>
					<label>{{x.name}}</label>
                </div>
                </div>
					                
     <p><input id="test2" type="text" placeholder="Search Doctor " ng-model="test2"></p> 					                
     <div  class="doctor" ng-repeat="x in doctor | filter:test2" id={{x.id}}>
                <div class=" col-md-4 filtr-item" data-category="2" data-sort="Busy streets">
     
					<a href="./DisplayDoctor?docId={{x.id}}">
						<div class="item item-type-double">
							<div class="item-hover">
								<div class="item-info">
									<div class="date">{{x.name}}</div>			
									<div class="line"></div>			
									<div class="headline">{{x.name}}</div>
									<div class="line"></div>
								</div>
								<div class="mask"></div>
							</div>
							<div class="item-img"><img src="images/{{x.id}}.gif" height="280" width="280" alt=" " /></div>
						</div>
					</a>
					<label>{{x.name}}</label>
                </div>
                </div>
					                
</div>

               <div class="clearfix"> </div>
            </div>
		</div>
	</div>
	</div>
	<br>
	<br>
	<br>
	<!-- swipe box js -->
	<!--test  -->
	
	<div id="list">
	<ul class="simplefilter wow zoomIn" data-wow-duration="1.5s" data-wow-delay="0.1s">
                <li class="active" data-filter="all">ALL</li>
                <li data-filter="a">DEPARTMENT</li>
                <li data-filter="b">DOCTOR</li>
                <li data-filter="c">STAFF</li>
                <li data-filter="d">PATIENTS</li>
            </ul>
            </div>
	
				<script src="js/jquery.swipebox.min.js"></script> 
					<script type="text/javascript">
						jQuery(function($) {
							$(".swipebox").swipebox();
						});
				</script>
				<script type="text/javascript">					
				$(document).ready(function(){

					$("#list").hide();
					$("#im").click(function(){
						
						$("#list").show();		
						});
					
				});
				</script>
			<!-- //swipe box js -->

	<!--//gallery-->
	 <!-- Include jQuery & Filterizr -->
    
    <script src="js/jquery.filterizr.js"></script>
    <script src="js/controls.js"></script>

    <!-- Kick off Filterizr -->
    <script type="text/javascript">
        $(function() {
            //Initialize filterizr with default options
            $('.filtr-container').filterizr();
        });
    </script>
	<!--//gallery-->

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