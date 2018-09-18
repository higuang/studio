<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
    <title><sitemesh:write property='title'/></title>
    <link href="${contextPath}/css/bootstrap/3.3.7/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script src="${contextPath}/js/jquery/2.1.1/jquery.min.js"></script>
    <script src="${contextPath}/css/bootstrap/3.3.7/bootstrap.min.js"></script>
    <sitemesh:write property='head'/>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                    <a class="navbar-brand" href="${contextPath}/main/index.html">Home</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="${contextPath}/doc/tool.html">工具栏</a>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search" action="${contextPath}/doc/list.html">
                        <div class="form-group">
                            <input type="text" class="form-control" name="keyword" value="${keyword}"/>
                        </div> <button type="submit" class="btn btn-default">Search</button>
                    </form>
                </div>

            </nav>

                <sitemesh:write property ='body'/>

        </div>
    </div>
</div>
</body>
</html>