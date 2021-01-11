<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
</head>
<body>
	<h1>페이지 처리중 에러발생!!!</h1>
	Exception class :<%=exception.getClass().getName() %><br>
	Exception Message : <%=exception.getMessage() %>
	<a href="javascript:history.back();">뒤로가기</a>
</body>
</html>