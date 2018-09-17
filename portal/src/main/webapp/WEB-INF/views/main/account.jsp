<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Account</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="${contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Oil&Gas Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,300,700,800' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script src="${contextPath}/js/jquery.min.js"></script>
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
						<li class="active"><a href="account.account.jsp">My Account</a></li>
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
<!-- account -->
	<div class="main-1">
		<div class="container">
<div class="account">
          <div class="container">
				<div class="col_1_of_account span_1_of_account">
					<h4 class="title">New Customers</h4>
					<h5 class="sub_title">Register Account</h5>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan</p>
					<div class="button1">
					   <a href="register.html"><input type="submit" name="Submit" value="Continue"></a>
					 </div>
					 <div class="clearfix"> </div>
				</div>
				<div class="col_1_of_account span_1_of_account">
				  <div class="account-title">
	           		<h4 class="title">Registered Customers</h4>
					 <div class="comments-area">
						<form>
							<p>
								<label>Name</label>
								<span>*</span>
								<input type="text" value="">
							</p>
							<p>
								<label>Password</label>
								<span>*</span>
								<input type="password" value="">
							</p>
							 <p id="account-form-remember">
								<label><a href="#">Forget Your Password ? </a></label>
							 </p>
							 <p>
								<input type="submit" value="Login">
							</p>
						</form>
					</div>
			      </div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		 </div>
	</div>
<!-- account -->
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