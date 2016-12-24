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
				width: 1200px;
			}
		</style>
		<script type="text/javascript">
			$(function(){
				<#-- 删除按钮点击事件-->
				$("#delButton").click(function(){
					var ids = new Array();
					$("input[type='checkbox']:gt(0):checked").each(function(){ 
						ids.push($(this).val())
					})
					if(ids.length==0){
						alert('你还没选中任何东西！')
					}else{
						$.ajax({
							url:"${request.contextPath}/deleteNotes",
							type:"post",
							datatype:"json",
							data:{"ids":ids.join()},
							success:function(data){
								$("input[type='checkbox']:gt(0):checked").parents('tr').remove();
								$("input[type='checkbox']").prop("checked",false);
								alert(data)
							}
						})
					}
					
				})
				<#-- 复选框点击事件-->
				$("input[type='checkbox']:first").click(function(){ 
					if($(this).prop("checked")){
				
				        $("input[type='checkbox']").prop("checked",true);
				    }else{
				
				        $("input[type='checkbox']").prop("checked",false);
				    }
				})
				
			})
			
		</script>
	</head>
	<body>
		<div id="div-body">
			<h1 align="center">青城专用论坛</h1>
			<button id="delButton" type="button" class="btn btn-info">删除</button>
			<a href="${request.contextPath}/view/pub.ftl" class="btn btn-primary btn-sm active" role="button">发帖</a>
			
			<#--form表单-->
			<div id="div-form">
				<form class="form-inline" role="form" action="${request.contextPath}/findAllNote" method="post">
				
				  <button type="button"  class="btn btn-primary disabled">找贴</button>
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">标题</div>
				      <input class="form-control" type="text" name="title" placeholder="输入标题">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">发帖人</div>
				      <input class="form-control" type="text" name="author" placeholder="输入发帖人">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">发帖时间</div>
				      <input class="form-control" type="datetime-local" name="time_start" placeholder="输入开始时间">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">到</div>
				      <input class="form-control" type="datetime-local" name="time_end" placeholder="输入结束时间">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">内容</div>
				      <input class="form-control" type="text" name="content" placeholder="输入相应内容">
				    </div>
				  </div>
				  
				  <button type="submit" class="btn btn-default">搜索</button>
				</form>
			</div>
			<#--form表单结束-->
			
			<#--帖子列表-->
			<div id="div-list">
				<table class="table table-striped table-bordered table-hover" style="table-layout: fixed;">
					<tr>
						<td width="60px"><input type="checkbox"/></td><td width="80px">帖子编号</td><td>帖子标题</td><td width="200px">发帖人</td><td>发帖时间</td><td>发帖内容</td><td>操作</td>
					</tr>
					<#list majorlists as majornote>
							<tr>
								<td><input type="checkbox" value="${majornote.id}"/><td>${majornote_index+1}</td><td>${majornote.title}</td><td>${majornote.author}</td><td>${majornote.publishtime?string('yyyy-MM-dd HH:mm:ss')}</td><td>${majornote.content}</td><td><a class="btn btn-default" href="${request.contextPath}/findNoteAndReplyById?id=${majornote.id}" role="button">查看详情</a><a class="btn btn-default" href="${request.contextPath}/findNoteAndReplyById?id=${majornote.id}" role="button">回复该贴</a></td>
							</tr>
					</#list>
				</table>
			</div>
			<#--帖子列表结束-->
			
		</div>
	</body>
</html>
