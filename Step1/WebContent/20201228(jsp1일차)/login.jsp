<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	사용자가 입력한 아이디는 <%=request.getParameter("id") %>
	사용자가 입력한 암호는 <%=request.getParameter("pw") %>
</body>
</html>