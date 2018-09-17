<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Contact</title>
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
								<li><a href="news.news.jsp">news</a></li>
								<li><a href="services.services.jsp">services</a></li>
								<li><a href="404.html">blog</a></li>
								<li class="active"><a href="contact.contact.jsp">mail us</a></li>
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
<!-- contact -->
	<div class="main">
		<div class="container">
<div class="contact">
<div class="section group">				
				<div class="col-md-4 col span_1_of_3">
					<div class="contact_info">
			    	 	<h3>Find Us Here</h3>
			    	 		<div class="map">
					   			<iframe width="100%" height="175" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed"></iframe><br><small><a href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265" style="color: rgba(180, 192, 21, 0.71);;text-align:left;font-size:12px">View Larger Map</a></small>
					   		</div>
      				</div>
      			<div class="company_address">
				     	<h3>Company Information :</h3>
						<p>500 Lorem Ipsum Dolor Sit,</p>
						<p>22-56-2-9 Sit Amet, Lorem,</p>
						<p>USA</p>
				   		<p>Phone:(00) 222 666 444</p>
				   		<p>Fax: (000) 000 00 00 0</p>
				 	 	<p>Email: <span>info(at)mycompany.com</span></p>
				   		<p>Follow on: <span>Facebook</span>, <span>Twitter</span></p>
				   </div>
				</div>				
				<div class="col-md-8 col span_2_of_3">
				  <div class="contact-form">
				  	<h3>Contact Us</h3>
					      <form method="post" action="contact-post.html">
					    	<div>
						    	<span><label>NAME</label></span>
						    	<span><input name="userName" type="text" class="textbox"></span>
						    </div>
						    <div>
						    	<span><label>E-MAIL</label></span>
						    	<span><input name="userEmail" type="text" class="textbox"></span>
						    </div>
						    <div>
						     	<span><label>MOBILE</label></span>
						    	<span><input name="userPhone" type="text" class="textbox"></span>
						    </div>
						    <div>
						    	<span><label>SUBJECT</label></span>
						    	<span><textarea name="userMsg"> </textarea></span>
						    </div>
						   <div>
						   		<span><input type="submit" value="Submit"></span>
						  </div>
					    </form>
				    </div>
  				</div>	
  				<div class="clearfix"> </div>	
		  </div>
</div>
</div>
	</div>
  <!-- contact -->
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
			<p>Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>>
		</div>
	</div>
<!-- footer-bottom -->

</body>
</html>