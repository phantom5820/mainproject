<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="obj.Join" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답 페이지</title>
</head>
<body>
		<%
			Join j = (Join)request.getAttribute("obj");
		%>
		
		회원정보 :<br>
		아이디 :<%=j.getId() %><br>
		비밀번호 :<%=j.getPw() %>
</body>
</html>