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
			<#list pd.list as l>
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
						<a href="${request.contextPath}/user/deleteUser?id=${l.id}&cpage=${pd.pageindex}">删除</a>
						<a href="javascript:void(0)" onclick="del('${l.id}')">修改</a>
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
						<a href="${request.contextPath}/user/deleteUser?id=${l.id}&cpage=${pd.pageindex}">删除</a>
						<a href="javascript:void(0)" onclick="del('${l.id}')">修改</a>
					</td>
				</tr>
			</#if>
			
			
			</#list>
		</table></br>
		<button onclick="add()">添加雇员</button></br>
		高级查询：
		<form action="${request.contextPath}/user/advancedSearch" method="post">
			姓名：<input type="text" name="name">邮箱：<input type="text" name="email"></br>
			电话：<input type="text" name="tel">部门：<input type="text" name="deptname">
			<input type="submit" value="确定"/>
		</form>
	</body>
	
		<#if cpage??>
			
		</#if>
	<@qingchengpage.page url="${request.contextPath}/user/advancedSearch" totalPage="${pd.pagecount}" rows="${pd.totalrecords}" nowPage="${pd.pageindex}" pageSize="${pd.pagesize}" />
	<#include "inc/footer.ftl">
</html>
