<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://www.ylinkpay.org/tags/cfn" prefix="cfn" %>
<%-- 设置一个上下文路径变量来指定 /demo
  -    这个名字会随着webapp应用的名字改变动态改变.
  -
  -    修改后的值为/ness 因此再引用其它路径时要多加个/, 如
  -             ${ contextPath }/js/jquery/jquery.1.4.4.js.
  -    用的时候可以${ pageContext.request.contextPath } 这是最通用的引用上下文路径的写法.
  -       但是过于冗长.
  -    可以${ contextPath }, 效果一样.
  --%>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />