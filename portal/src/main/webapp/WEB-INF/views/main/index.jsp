<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
  <title>首页</title>
  <link href="${contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
  <link href="${contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="keywords" content="Doc Search" />
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
          <li><a href="registration.registration.jsp">注册</a></li>
          <li class="active"><a href="login.login.jsp">登录</a></li>
          <li><a href="account.account.jsp">我的账户</a></li>
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
      <a href="index.html"><img src="${contextPath}/images/logo.png" class="img-responsive" alt="" /></a>
    </div>
    <div class="head-nav">
      <span class="menu"> </span>
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="about.html">about</a></li>
        <li><a href="news.html">news</a></li>
        <li><a href="services.html">services</a></li>
        <li><a href="${contextPath}/doc/list.html">doc</a></li>
        <li><a href="contact.html">mail us</a></li>
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
<!-- login -->
<div class="main-1">
  <div class="container">
    <div class="login-page">
      <div class="account_grid">
        <div class="col-md-6 login-left wow fadeInLeft" data-wow-delay="0.4s">
          <h3>NEW CUSTOMERS</h3>
          <p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
          <a class="acount-btn" href="register.html">Create an Account</a>
        </div>
        <div class="col-md-6 login-right wow fadeInRight" data-wow-delay="0.4s">
          <h3>REGISTERED CUSTOMERS</h3>
          <p>If you have an account with us, please log in.</p>
          <form>
            <div>
              <span>Email Address<label>*</label></span>
              <input type="text">
            </div>
            <div>
              <span>Password<label>*</label></span>
              <input type="text">
            </div>
            <a class="forgot" href="#">Forgot Your Password?</a>
            <input type="submit" value="Login">
          </form>
        </div>
        <div class="clearfix"> </div>
      </div>
    </div>
  </div>
</div>
<!-- login -->
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
        <a href="index.html"><img src="${contextPath}/images/logo1.png" class="img-responsive" alt="" /></a>
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