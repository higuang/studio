<s:if test="#request.user_type!=null&&#request.user_type=='enterprise'" >
<%@include file="/WEB-INF/views/common/enterprise_common.jsp"%>
</s:if>
<s:else>
<%@include file="/WEB-INF/views/common/personal_common.jsp"%>
</s:else>