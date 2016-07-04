<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html >
<head>
	<meta http-equiv="Content-Type" content="text/html; utf-8">
	<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>
			<c:if test='${message != ""}'>
				<c:out value='${message}'/>
			</c:if>	
		</h2>
	</div>
	
	<form method="post" enctype="multipart/form-data" action="<c:url value='/file/upload2.html' />">
		<label for="file">File upload</label>
		<input type="text" name="name" id="name" /> <br/>
	
		<label for="file">File upload</label>
		<input type="file" name="file" id="file" />
		<input type="submit" value="submit"/>
	</form>
</body>
</html>