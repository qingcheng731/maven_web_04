<h1>page.ftl</h1>

<#include "/inc/default_css.ftl"/>
<#macro page url totalPage rows=0 nowPage=1 pageSize=5 >
	<p>
		
		
		<#if nowPage ==1>
			首页 | 上一页
		<#else>
			| <a href="${url}?cpage=1">首页</a>
			| <a href="${url}?cpage=${nowPage?number-1}">上一页</a>		
		</#if>
		
		<#if nowPage==totalPage>
			| 下一页 | 最后一页
		<#else>
			| <a href="${url}?cpage=${nowPage?number+1}">下一页</a>
			| <a href="${url}?cpage=${totalPage}">最后一页</a> 
		</#if>
		| 当前第${nowPage}页 
		| 共${totalPage}页 | 共${rows}条 | 每页${pageSize}条
	</p>
</#macro>

