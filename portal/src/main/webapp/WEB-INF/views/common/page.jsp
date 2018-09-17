<%@ page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/taglibs.jsp"%>
 <div class="m-pages">
 <c:if test="${page.total>0}">
	<c:if test="${page.pageNumber>1}"><a href="javascript:void(0)" onclick="gotoPage('1')">首页</a><a href="javascript:void(0)" onclick="gotoPage('${page.pageNumber-1}')">上一页</a></c:if>
	<c:forEach items="${page.numList}" var="num">
	<a href="javascript:void(0)"  onclick="gotoPage('${num}')" <c:if test="${page.pageNumber==num}">class="active"</c:if>>${num}</a>
	</c:forEach>
	<c:if test="${page.pageSum-page.pageNumber>0}">
	<a href="javascript:void(0)" onclick="gotoPage('${page.pageNumber+1}')">下一页</a>
	<a href="javascript:void(0)" onclick="gotoPage('${page.pageSum}')">尾页</a>
	</c:if>
	共${page.pageSum}页${page.total}条
	</c:if>
</div>
