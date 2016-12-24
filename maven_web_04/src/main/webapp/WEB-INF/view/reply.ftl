<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="${request.contextPath}/static/css/bootstrap.min.css"/>
		<script type="text/javascript" src="${request.contextPath}/static/js/jquery.min.js" ></script>
		<script type="text/javascript" src="${request.contextPath}/static/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function(){
				
			})
			function addCount(id){
				$.ajax({
					  type: "GET",
					  url: "${request.contextPath}/addCount",
					  dataType: "text",
					  data:{"id":id},
					  success:function(data){
					  		$('#'+id).html('('+data+')')
					  }
					});
			}
		</script>
		<style type="text/css">
			#div-major-content{
				margin: 0 auto;
				width: 900px;
			}
			#div-reply{
				margin: 0 auto;
				width: 900px;
			}
			h1{
				margin: 0 auto;
				width: 900px;
				text-align: center;
			}
			h2{
				margin: 0 auto;
				width: 900px;
				text-align: left;
			}
			#div-form{
				margin: 0 auto;
				width: 900px;
			}
		</style>
	</head>
	<body>
		<h1>帖子详情</h1>
		 		<#list lists as l1>
					<#if l1_index==0>
						<div id="div-major-content" class="panel panel-default">
							<div class="panel-heading">
								<div id="div-major-content-title" style="text-align: center;">
							  		<B style="font-size: 25px;">${l1.majornote_title}</B>
							  	</div>
							  	<div id="div-major-content-time-content" style="text-align: right;">
							  		<h4 class="panel-title" style="display: inline-block;">${l1.majornote_publishtime}  </h4>
							    	<h3 class="panel-title" style="display: inline-block;">&nbsp来自<B>${l1.majornote_author}</B></h3>
							  	</div>
						  	</div>
						  	<div class="panel-body">
								${l1.majornote_content}
							</div>
						</div>
					</#if>
				</#list>
		
		<h1>所有回帖:</h1>
		
		<#if lists?size ==0>
					<h3>还没有人回复，快来<a href="#">回复</a>吧</h3>
				<#else>
					<#list lists as reply>
					<div id="div-reply">
						<div class="panel panel-primary">
							<div>
								<div id="div-floor" style="display: inline-block;width:840px">
									第${reply_index+1}楼
								</div>
								<div id="div-floor" style="display: inline-block;">
									<span id="addCount_${reply._rid}" onclick="addCount('${reply._rid}')" class="glyphicon glyphicon-thumbs-up" style="cursor: pointer;"></span><span id="${reply._rid}">(${reply.replynote_count})</span>
								</div>
							</div>
						    <div class="panel-body">${reply.replynote_content}</div>
						  	<div class="div-footer" style="text-align: right;">
						    	<h3 class="panel-title" style="display: inline-block;">来自${reply.replynote_username}</h3>
						    	<h3 class="panel-title" style="display: inline-block;">${reply.replynote_replytime}</h3>
						    	<h3 class="panel-title" style="display: inline-block;"><a href="#" style="color: yellowgreen;">回复此人</a></h3>
						  	</div>
						</div>
					</div>
					</#list>
				</#if>
		
				<#--富文本编辑器-->
				<div id="div-form">
					<h3 align="center">回复该贴</a></h3>
					<form action="${request.contextPath}/addReply?id=${id}" method="post">
						 <!-- 加载编辑器的容器 -->
					    <script id="container" name="content" type="text/plain" style="width:100%;height:240px;">这里写你回复的内容</script>
						<input class="btn btn-primary btn-lg" type="submit" style="width:100%;height:40px;" value="提交回复">
					</form>
			    </div>
				<#--富文本编辑器结束-->
				
			    <!-- 配置文件 -->
			    <script type="text/javascript" src="${request.contextPath}/UEditor/ueditor.config.js"></script>
			    <!-- 编辑器源码文件 -->
			    <script type="text/javascript" src="${request.contextPath}/UEditor/ueditor.all.js"></script>
			    <!-- 实例化编辑器 -->
			    <script type="text/javascript">
			        var ue = UE.getEditor('container');
			    </script>
	
		
	</body>
</html>
