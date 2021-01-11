<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 		<%=pageContext.getAttribute("num") %>
 		<%=pageContext.getAttribute("test") %>
 		<a href="page_1.jsp">첫번째 페이지로 이동</a>
</body>
</html>