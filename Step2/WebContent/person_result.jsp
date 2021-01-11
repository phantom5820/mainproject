<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="obj.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Person p = (Person)request.getAttribute("obj");//process에서 setAttribute로 저장했던 obj 키값에 해당하는 값을 읽어온다.
	%>
	
	Person 처리결과<br>
	이름 : <%=p.getName() %><br>
	나이 : <%=p.getAge() %>
	
</body>
</html>