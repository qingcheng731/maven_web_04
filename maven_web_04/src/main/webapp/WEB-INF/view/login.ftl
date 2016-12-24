<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<h1>login</h1>
		<form action="${request.contextPath}/user/login" method="post">
			用户名：<input type="text" name="name"/></br>
			密    码：<input type="text" name="password"/></br>
			<input type="submit" value="login"/> 
		</form>
	
	</body>
</html>
