<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>About</title>
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
						<li><a href="${contextPath}/main/index.html">Home</a></li>
					</ul>
				</div>
				<div class="header-right" style="width: 80%" >
					<div class="search2">
					  <form action="${contextPath}/doc/list.html">
						 <input type="text" value="" name="keyword" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}"/>
						 <input type="submit" value="">
					  </form>
					</div>
				</div>
					<div class="clearfix"> </div>
			</div>
		</div> 				
	</div> 		

<!-- header -->
<!-- about -->
	<div class="main">
		<div class="container">
			<div class="col-md-10">
					<iframe scrolling="no" width="100%" name="aa" frameborder="0" src="http://localhost:8080/portal/doc/doc.html?id=65627171-b705-11e8-a6fd-bc307de2ca4c" onload="this.height=0;var fdh=(this.Document?this.Document.body.scrollHeight:this.contentDocument.body.offsetHeight);this.height=(fdh>1200?fdh:1200)"></iframe>
			</div>
			<div class="col-md-2">
			</div>
				<div class="clearfix"> </div>
		</div>
	</div>
<!-- about -->
</body>
</html>