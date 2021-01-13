<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<!-- 로그인 폼 -->
	<form action="LoginServlet" method="post">
		아이디 : <input type="text" name="id"><br><!-- 한글입력해보기 -->
		비밀번호 : <input type="password" name="pass"><br>
		<button>로그인</button>
	</form>
</body>
</html>