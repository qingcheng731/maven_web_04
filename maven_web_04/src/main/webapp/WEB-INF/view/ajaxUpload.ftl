<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax上传图片</title>
<#include "inc/default_css.ftl">
<script type="text/javascript">
	$(document).ready(function(){
		$("#mybtn").click(function(){
			//传入一个非query对象,把jquery对象转化为js对象
			var data = new FormData($("#uploadForm")[0]); 
		    $.ajax({
		        type:'POST',
		        url:"/springmvc_demo01/user/ajaxUpload",
		        cache: false,
		        data: data,
		        contentType: false,  
		        processData: false,
		        async: true,
		        success: function(data){
		            alert(data);
		        },
		        error: function(){
		            alert("error");
		        }
		    });
		});
	});
</script>
</head>
<body>
<div>
	<h1>Ajax文件上传，提交表单</h1>
<p>
	ajax上传，用户体验比较好，前端通常使用ajax上传组件，服务端使用java上传组件  </p>
	<p>1）本案例中使用 jquery 异步提交表单 ，没有使用前端插件</p>
	<p>2）需要借助 FormData 对象  才能实现上传，平时编写的ajax代码不支持二进制文件上传</p>
	<p>3)FormData 是前端新规范中，添加的对象，主流浏览器大部分支持 。部分浏览器可能存在兼容性问题</p>
	<p>4)ajax代码，必须有特殊的要求  contentType 和 processData 要设置为false</p>
	
	<h3>Ajax文件上传，提交表单</h3>




	<form action="/user/uplodFile"  method="post"  id="uploadForm"  >
		<input type="file"  name="uplodFile"  id="uploadFile"  >
		<input type="button" value="ajax上传"  id="mybtn">
	</form>
</div>
</body>
</html>