<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<h1>upload</h1>
		
		<form action="${request.contextPath}/user/addupload" method="post" enctype="multipart/form-data">
			<input type="text" name="name"/></br>
			头像1：<input type="file" name="uplodFile"/></br>
			头像2：<input type="file" name="uplodFile"/></br>
			<input type="submit" value="上传" />
		</form>
	
	</body>
</html>
