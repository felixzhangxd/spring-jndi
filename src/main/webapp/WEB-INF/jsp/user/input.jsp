<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user input</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/submit" method="post">
		name:<input type="text" name="name" /><br/>
		password:<input type="password" name="password" /><br/>
		<input type="submit" value="save" /><br/>
	</form>
</body>
</html>