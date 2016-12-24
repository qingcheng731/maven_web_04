


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

		
		<#include  "/inc/header.ftl"  />
		
		<#list  images  as img>
			<p><img  src="${request.contextPath}/${img}"/></p>

		</#list>



		<#include  "/inc/footer.ftl"  />

</body>
</html>



