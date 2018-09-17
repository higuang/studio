<script type="text/javascript">
$(document).ready(function(){
	
	var alert_info="${req_err_info}";
	var return_url="";
	if(alert_info!=null&&alert_info!=""){
		$("#errMsg").text(alert_info);
		$("#errMsg").addClass("custom_error");
		return_url="${param.original_url}";
	}
	var input_url=$("#original_url");
	if(input_url!=null)
	{
		if(return_url==null||return_url=="")
			return_url=window.location.pathname;
		input_url.attr("value",return_url);
	}
});
</script>
<p class="errMsg" id="errMsg" style="color: red;">&nbsp;</p>
<input type="hidden" name="original_url" id="original_url" value="" />