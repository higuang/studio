<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Registration</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="${contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Oil&Gas Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,300,700,800' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${contextPath}/css/flexslider.css" type="text/css" media="screen" />
<script src="${contextPath}/js/jquery.min.js"></script>
</head>
<body>
<!-- header -->
	<div class="header">
  	    <div class="container">
			<div class="header-top">
				<div class="header-left">
					<ul>
						<li class="active"><a href="registration.registration.jsp">Registration</a></li>
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
								<li><a href="news.news.jsp">news</a></li>
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
<!-- registration -->
	<div class="main-1">
		<div class="container">
			<div class="register">
		  	  <form> 
				 <div class="register-top-grid">
					<h3>PERSONAL INFORMATION</h3>
					 <div class="wow fadeInLeft" data-wow-delay="0.4s">
						<span>First Name<label>*</label></span>
						<input type="text"> 
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>Last Name<label>*</label></span>
						<input type="text"> 
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						 <span>Email Address<label>*</label></span>
						 <input type="text"> 
					 </div>
					 <div class="clearfix"> </div>
					   <a class="news-letter" href="#">
						 <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>Sign Up for Newsletter</label>
					   </a>
					 </div>
				     <div class="register-bottom-grid">
						    <h3>LOGIN INFORMATION</h3>
							 <div class="wow fadeInLeft" data-wow-delay="0.4s">
								<span>Password<label>*</label></span>
								<input type="text">
							 </div>
							 <div class="wow fadeInRight" data-wow-delay="0.4s">
								<span>Confirm Password<label>*</label></span>
								<input type="text">
							 </div>
					 </div>
				</form>
				<div class="clearfix"> </div>
				<div class="register-but">
				   <form>
					   <input type="submit" value="submit">
					   <div class="clearfix"> </div>
				   </form>
				</div>
		   </div>
		 </div>
	</div>
<!-- registration -->
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