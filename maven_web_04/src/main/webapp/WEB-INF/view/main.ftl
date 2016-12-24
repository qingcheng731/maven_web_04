<!DOCTYPE html>
<html>
	<head>
		
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript">
			function add(){
				window.location.href="${request.contextPath}/view/add"
			}
			
			function del(id){
				alert(id)
			}
		</script>
		<#import "/inc/page.ftl" as qingchengpage>
	</head>
	
	
	<#include "inc/header.ftl"/>
	
	
	<body>
		<h1>hello springmvc</h1>
		<table border="1" cellspacing="0">
			<tr><td>id</td><td>编号</td><td>头像</td><td>姓名</td><td>邮箱</td><td>电话</td><td>时间</td><td>部门名称</td><td>操作</td></tr>
			<#list lists as l>
			<#if (l_index)%2==1>
				<tr style="background-color:darkgrey">
					<td>${l_index }</td>
					<td>${l.id }</td>
					<td><img width="50px" src="${request.contextPath}/upload/${l.imgurl}"/> </td>
					<td>${l.name }</td>
					<td>${l.email }</td>
					<td>${l.telphone }</td>
					<td>${l.regdate }</td>
					<td>${l.deptname }</td>
					<td>
						<a href="javascript:void(0)" onclick="del('${l.id}')">删除</a>|
						<a href="${request.contextPath}/user/updateUser?id=${l.id}">修改</a>
					</td>
				</tr>
			
			<#else>
				<tr>
					<td>${l_index }</td>
					<td>${l.id }</td>
					<td><img src="${l.imgurl}"/> </td>
					<td>${l.name }</td>
					<td>${l.email }</td>
					<td>${l.telphone }</td>
					<td>${l.regdate }</td>
					<td>${l.deptname }</td>
					<td>
						<a href="javascript:void(0)" onclick="del('${l.id}')">删除</a>|
						<a href="${request.contextPath}/user/updateUser?id=${l.id}">修改</a>
					</td>
				</tr>
			</#if>
			
			
			</#list>
		</table></br>
		<button onclick="add()">添加雇员</button>
	</body>
	
		<#if cpage??>
			
		</#if>
	<@qingchengpage.page url="${request.contextPath}/user/page" totalPage="20" rows="100" nowPage="${cpage!1}" pageSize="5" />
	<#include "inc/footer.ftl">
</html>
