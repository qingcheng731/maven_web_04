<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${request.contextPath}/static/css/validform.css"/>
		<script src="${request.contextPath}/static/js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${request.contextPath}/static/js/Validform_v5.3.2.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				alert('ok');
				$(".demoform").Validform();	
			})
		</script>
	</head>
	<body>
		<h1>validform ajax</h1>
		
		<form class="demoform" action="" method="post">
		
			<!--ajax实时验证用户名-->
			<input type="text" value="" name="name" datatype="s4-16" ajaxurl="${request.contextPath}/user/validUsername" 
				sucmsg="用户名验证通过！" nullmsg="请输入用户名！" errormsg="4~20位字符，可由英文、数字"  />
				<input type="submit" value="提交"/>
		</form>
	</body>
</html>
