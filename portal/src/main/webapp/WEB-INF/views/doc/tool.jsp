<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
    <title>Sogood</title>

</head>
<body>
<div class="row clearfix">
    <div class="col-md-4 column">
        <button style="padding:4px" type="button" href="${contextPath}/doc/reIndex.html" class="btn btn-default btn-block">重建索引</button>
    </div>
    <div class="col-md-4 column">
        <button style="padding:4px" type="button" href="${contextPath}/doc/reCreateDate.html" class="btn btn-default btn-block">重新生成文档</button>
    </div>
</div>
</body>
</html>
