<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>News</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="${contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Oil&Gas Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,300,700,800' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<link href="${contextPath}/css/camera.css" rel="stylesheet" type="text/css" media="all" />
<script src="${contextPath}/js/jquery.min.js"></script>
<script type='text/javascript' src='${contextPath}/js/camera.min.js'></script>
    <script>
		jQuery(function(){
			
			jQuery('#camera_wrap_1').camera({
				thumbnails: true
			});

			jQuery('#camera_wrap_2').camera({
				height: '400px',
				loader: 'bar',
				pagination: false,
				thumbnails: true
			});
		});
	</script>

</head>
<body>
<!-- header -->
	<div class="header">
  	    <div class="container">
			<div class="header-top">
				<div class="header-left">
					<ul>
						<li><a href="registration.registration.jsp">Registration</a></li>
						<li><a href="login.login.jsp">Login</a></li>
						<li><a href="account.account.jsp">My Account</a></li>
					</ul>
				</div>
				<div class="header-right">
					<div class="search2">
					  <form>
						 <input type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}"/>
						 <input type="submit" value="">
					  </form>
					</div>
				</div>
					<div class="clearfix"> </div>
			</div>
		</div> 				
	</div> 		
			<div class="header-bottom">
				<div class="container">
					<div class="logo">
						<a href="index.html"><img src="images/logo.png" class="img-responsive" alt="" /></a>
					</div>
					<div class="head-nav">
						<span class="menu"> </span>
							<ul>
								<li><a href="index.html">Home</a></li>
								<li><a href="about.about.jsp">about</a></li>
								<li class="active"><a href="news.news.jsp">news</a></li>
								<li><a href="services.services.jsp">services</a></li>
								<li><a href="404.html">blog</a></li>
								<li><a href="contact.contact.jsp">mail us</a></li>
								<div class="clearfix"> </div>
						</ul>
					</div>
						<div class="clearfix"> </div>
						<!-- script-for-nav -->
					<script>
						$( "span.menu" ).click(function() {
						  $( ".head-nav ul" ).slideToggle(300, function() {
							// Animation complete.
						  });
						});
					</script>
				<!-- script-for-nav -->
				</div> 
			</div> 	
	<div class="banner-1">
		<div class="container">
		</div>
	</div>
<!-- header -->
<!-- news -->
	<div class="main">
		<div class="container">
		<!-- news -->
		<div class="news">
			<h3>LATEST NEWS</h3>
			<!-- container -->
			<div class="container">
				<div class="news-grids">
					<div class="col-md-4 news-grid">
						<div class="news-grid-text">
							<h4>LOREM IPSUM DOLOR SIT</h4>
							<span>10.00 - 12.00 | sep 24,2014</span>
						</div>
						<img src="images/img2.jpg" class="img-responsive" alt="" />
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat.</p>
						<div class="read-more blue">
							<a href="#">Read More &gt;&gt;</a>
						</div>
					</div>
					<div class="col-md-4 news-grid">
						<div class="news-grid-text">
							<h4>LOREM IPSUM DOLOR SIT</h4>
							<span>8.00 - 10.00 | JUN 09,2014</span>
						</div>
						<img src="images/img5.jpg" class="img-responsive" alt="" />
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat.</p>
						<div class="read-more blue">
							<a href="#">Read More &gt;&gt;</a>
						</div>
					</div>
					<div class="col-md-4 news-grid">
						<div class="news-grid-text">
							<h4>LOREM IPSUM DOLOR SIT</h4>
							<span>9.00 - 10.00 | FEB 15,2014</span>
						</div>
						<img src="images/img8.jpg" class="img-responsive" alt="" />
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat.</p>
						<div class="read-more blue">
							<a href="#">Read More &gt;&gt;</a>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<!-- //container -->
			<div class="latest-events">
				<!-- container -->
				<div class="container">
					<div class="news-grids">
					<div class="col-md-4 news-grid">
						<div class="news-grid-text">
							<span>10.00 - 12.00 | sep 24,2014</span>
						</div>
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat.</p>
						<div class="read-more blue">
							<a href="#">Read More &gt;&gt;</a>
						</div>
					</div>
					<div class="col-md-4 news-grid">
						<div class="news-grid-text">
							<span>8.00 - 10.00 | JUN 09,2014</span>
						</div>
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat.</p>
						<div class="read-more blue">
							<a href="#">Read More &gt;&gt;</a>
						</div>
					</div>
					<div class="col-md-4 news-grid">
						<div class="news-grid-text">
							<span>9.00 - 10.00 | FEB 15,2014</span>
						</div>
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat.</p>
						<div class="read-more blue">
							<a href="#">Read More &gt;&gt;</a>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
				</div>
				<!-- //container -->
			</div>
		</div>
		<!-- //news -->
		 </div>
	</div>
  <!-- news -->
<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="col-md-5 footer-left">
				<h4>Stay in touch</h4>
				<div class="stay">
					<div class="stay-left">
						<form>
							<input type="text" placeholder="" required="">
						</form>
					</div>
					<div class="button">
						<form>
							<input type="submit" value="Sign up">
						</form>
					</div>
						<div class="clearfix"> </div>
				</div>
			</div>
			<div class="col-md-3 footer-middle">
				<h4>Address</h4>
				<div class="addr">
					<div class="icon">
						<i class="top"> </i>
					</div>
					<div class="data">
						<p>10-765 mg-Road,
							Washington, DC, United States,
							ud-19832-6578.</p>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="addr-1">
					<div class="icon">
						<i class="mob"> </i>
					</div>
					<div class="data">
						<p>+(123) 456-789-1234</p>
						<h6>E-mail : <a href="mailto:info@company.com">example@mail.com</a></h6>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="col-md-4 footer-right">
					<div class="logo-1">
						<a href="index.html"><img src="images/logo1.png" class="img-responsive" alt="" /></a>
					</div>
					<div class="social">
						<ul>
							<li><a href="#"><i class="facebok"> </i></a></li>
							<li><a href="#"><i class="twiter"> </i></a></li>
							<li><a href="#"><i class="drible"> </i></a></li>
							<li><a href="#"><i class="in"> </i></a></li>
								<div class="clearfix"></div>	
						</ul>
					</div>
			</div>
				<div class="clearfix"> </div>
		</div>
	</div>
<!-- footer -->
<!-- footer-bottom -->
	<div class="footer-bottom">
		<div class="container">
			<p>Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
		</div>
	</div>
<!-- footer-bottom -->

</body>
</html>