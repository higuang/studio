<script src="${ctx}/js/jquery/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="${ctx}/js/common/common.js" data="${ctx}" id="commonjs" type="text/javascript" charset="UTF-8"></script>
<link rel="stylesheet" href="${ctx}/css/enterprise.css" type="text/css" />
<script type="text/javascript">
$(document).ready(function(){
	var menu="${menu}";
	
	if(menu!=null ||menu!="")
	{
		$("#"+menu).addClass("zHSonnavLink");
	}
});
</script>