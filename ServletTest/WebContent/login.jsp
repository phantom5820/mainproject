<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		아이디 : <input type="text" name="id"><br><!-- 폼 메서드가 포스트방식일때 한글넣어보기! -->
		암호 : <input type="password" name="pass"><button>로그인</button>
	</form>
</body>
</html>