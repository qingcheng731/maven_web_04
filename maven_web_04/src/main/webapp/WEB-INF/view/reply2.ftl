<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<#--<#include "inc/default_css.ftl">-->
		<link rel="stylesheet" type="text/css" href="${request.contextPath}/static/css/bootstrap.min.css"/>
		<script type="text/javascript" src="${request.contextPath}/static/js/jquery.min.js" ></script>
		<script type="text/javascript" src="${request.contextPath}/static/js/bootstrap.min.js"></script>
	<style>
			td{
			   white-space:nowrap;overflow:hidden;text-overflow: ellipsis;
			    text-align: center;
			}
			#div-list{
				margin: 0 auto;
				width: 1100px;
			}
			#div-form{
				margin: 0 auto;
				width: 1000px;
			}
		</style>
		<script type="text/javascript">
			
		</script>
	</head>
	<body>
	<div id="div-body">
		<#--帖子列表-->
		<div id="div-list">
			<h3 align="center">主贴</h3>
			<table class="table table-striped table-bordered table-hover" style="table-layout: fixed;">
				<tr>
					<td width="80px">发帖人</td><td width="150px">发帖时间</td><td>发帖内容</td>
				</tr>
				<#list lists as l1>
					<#if l1_index==0>
						<tr>
							<td >${l1.majornote_author}</td><td>${l1.majornote_publishtime}</td><td>${l1.majornote_content}</td>
						</tr>
					</#if>
				</#list>
			</table>
		</div>
		<#--帖子列表结束-->
		
		<#--帖子回复-->
		<div id="div-list">
			<table class="table table-striped table-bordered table-hover" style="table-layout: fixed;">
				
				<#if lists?size ==0>
					<h3>还没有人回复，快来<a href="#">回复</a>吧</h3>
				<#else>
					<h1 align="center">所有回复</h1>
					<tr>
						<td>楼层</td><td>回复人</td><td>回复内容</td><td>回复时间</td><td>操作</td>
					</tr>
					<#list lists as reply>
						<tr>
							<td >${reply_index+1}</td><td >${reply.replynote_username}</td><td>${reply.replynote_content}</td><td>${reply.replynote_replytime}</td><td><a class="btn btn-default" href="#" role="button">查看详情</a><a class="btn btn-default" href="#" role="button">回复此人</a></td>
						</tr>
					</#list>
				</#if>
			</table>
		</div>
		<#--帖子回复结束-->
		
		
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
	   </div>
	</body>
</html>
