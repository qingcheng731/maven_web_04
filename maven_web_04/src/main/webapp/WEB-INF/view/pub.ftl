<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${request.contextPath}/static/css/bootstrap.min.css"/>
		<script type="text/javascript" src="${request.contextPath}/static/js/jquery.min.js" ></script>
		<script type="text/javascript" src="${request.contextPath}/static/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h1>发帖</h1>
		<h1 align="center">发布新帖</h1>
		<form action="${request.contextPath}/addNote" method="post" class="form-horizontal" role="form">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-3 control-label">标题</label>
				<div class="col-sm-6">
					<input type="text" name="title" class="form-control" id="inputEmail3" placeholder="请输入标题">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-3 control-label">内容</label>
				<div class="col-sm-6">
					<textarea class="form-control" name="content" rows="5" placeholder="请输入内容"></textarea>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-6">
					<button type="submit" class="btn btn-default">发布</button>
				</div>
			</div>
		</form>
	
	</body>
</html>
