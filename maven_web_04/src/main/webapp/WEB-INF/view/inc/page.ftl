<h1>page.ftl</h1>

<#include "/inc/default_css.ftl"/>
<#macro page url totalPage rows=0 nowPage=1 pageSize=5 >
	<p>
		
		
		<#if nowPage ==1>
			首页 | 上一页
		<#else>
			 <a href="${url}?cpage=1">首页</a>
			| <a href="${url}?cpage=${nowPage?number-1}">上一页</a>		
		</#if>
		
		<#assign currentPage=nowPage?number>
		<#assign pageindex_start=currentPage?number-2>
		<#assign pageindex_end=currentPage?number+2>
		<#--${pageindex_start}~${currentPage}~${pageindex_end}@-->
		<#if pageindex_start?number lte 0 >
			<#assign pageindex_start=1?number>
			<#assign pageindex_end=pageindex_start?number+4>
		</#if>
		<#--${pageindex_start}~${currentPage}~${pageindex_end}@-->
		<#if pageindex_end?number gte totalPage >
			<#assign pageindex_end=totalPage?number>
			<#assign pageindex_start=totalPage?number-4>
		</#if>
		<#--和-->
		<#--${pageindex_start}~${currentPage}~${pageindex_end}@-->
		<#if pageindex_start gt 0 && pageindex_end lte totalPage>
			<#list ["${pageindex_start}"?number,"${pageindex_start}"?number+1,"${pageindex_start}"?number+2,"${pageindex_start}"?number+3,"${pageindex_start}"?number+4] as pi>
				<#if (nowPage == pi)>
					${pi}
				<#else>
					<a href="${url}?cpage=${pi}">[${pi}]</a>
				</#if>
			</#list>
		<#else>
			<#if (totalPage==0)>
			<#elseif (totalPage==1)>
				<a href="${url}?cpage=1">1</a>
			<#elseif (totalPage==2)>
				<#list ["1"?number,"2"?number] as pi>
					<#if (nowPage == pi)>
						${pi}
					<#else>
						<a href="${url}?cpage=${pi}">[${pi}]</a>
					</#if>
				</#list>
			<#elseif (totalPage==3)>
				<#list ["1"?number,"2"?number,"3"?number] as pi>
					<#if (nowPage == pi)>
						${pi}
					<#else>
						<a href="${url}?cpage=${pi}">[${pi}]</a>
					</#if>
				</#list>
			<#elseif (totalPage==4)>
				<#list ["1"?number,"2"?number,"3"?number,"4"?number] as pi>
					<#if (nowPage == pi)>
						${pi}
					<#else>
						<a href="${url}?cpage=${pi}">[${pi}]</a>
					</#if>
				</#list>
			</#if>
		</#if>
		
		
		<#if nowPage==totalPage>
			| 下一页 | 最后一页
		<#else>
			| <a href="${url}?cpage=${nowPage?number+1}">下一页</a>
			| <a href="${url}?cpage=${totalPage}">最后一页</a> 
		</#if>
		| 当前第${nowPage}页 
		| 共${totalPage}页 | 每页${pageSize}条记录 | 共${rows}条 
	</p>
</#macro>

