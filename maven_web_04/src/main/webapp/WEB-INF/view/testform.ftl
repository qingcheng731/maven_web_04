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
				$('button').click(function(){
					$.ajax({
						type:'POST',
						url:'${request.contextPath}/user/testAjax',
						dataType:'json',
						success:function(data){
							alert(data)
						},
						error:function(){
							alert("出错了")
						}
					})
				})
			})
		</script>
	</head>
	<body>
		<h1>validform ajax</h1>
		
		<form action="${request.contextPath}/user/testAjax" method="post">
			<input type="text" name="name"/>
			<input type="submit" name="提交"/>
			
		</form>
		<button>快点我</buttom>
	</body>
</html>
