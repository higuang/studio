<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
    <title>Sogood</title>
    <script >
        function to_url( base_url,params) {
            window.location.href=base_url+"?fileName="+encodeURIComponent(params);
        }
    </script>
</head>
<body>
<div class="row clearfix">
    <c:forEach items="${list}" var="item">
    <div class="col-md-4 column">
        <p>
                ${item.justTitle}
         </p>
        <p>
            <a class="btn" href="javascript:to_url('${contextPath}/doc/doc.html','${item.title}')">  查看»</a>
        </p>
    </div>
    </c:forEach>
</div>
</body>
</html>
