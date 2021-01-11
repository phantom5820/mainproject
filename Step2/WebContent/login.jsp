<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container{
		height: 600px;
		/* background-color: lime; */
	}
</style>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
		
		<div class="container">
			<form method="post" action="login_action.jsp">
			<label for="id">아이디 :</label><input type="text" name="id" id="id"><br>
			<label for="pass">암호 :</label><input type="password" name="pass" id="pass"><br>
			<p>
			<button type="submit">로그인</button>
			<button id="register" type="button">회원가입</button>
			</p>
			</form>
		</div>
		
	<jsp:include page="template/footer.jsp"></jsp:include>
		
		
</body>
</html>