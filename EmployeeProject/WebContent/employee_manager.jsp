<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<header>
			<h3>인사관리 시스템에 로그인 하셨습니다</h3>
			로그인 정보 : <span>${sessionScope.name },${sessionScope.position }<a href="logout.do">로그아웃</a></span>							
		</header>
		<hr>
		<div id="container">
		<form action="search.do">
		<select>
			<option>이름</option>
			<option>사번</option>
			<option>부서</option>
		</select>
		<input type="text"><button type="submit">검색</button>
		</form>
		<br>
		<table>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>부서</th>
				<th>직급</th>
				<th>연봉</th>
				<th>비고</th>
			</tr>
			<tr>
				<td><input type="text" placeholder="사번을 검색하세요"></td>
				<td><input type="text" placeholder="이름을 검색하세요"></td>
				<td><input type="text" placeholder="부서를 검색하세요"></td>
				<td>
				<select>
					<option>사장</option>
					<option>부장</option>
					<option>차장</option>
					<option>과장</option>
					<option>대리</option>
					<option>주임</option>
					<option>사원</option>
				</select>
				<td><input type="text" placeholder="연봉을 입력하세요"></td>
				</td>
				<td><button>사원등록</button></td>
			</tr>			
		<c:forEach var="dto" items="${sessionScope.list }" varStatus="status">
			<tr>
				<td>${dto.eno }</td>
				<td>${dto.name }</td>
				<td>${dto.department }</td>
				<td>${dto.position }</td>
				<td>${dto.salary }</td>
				<td><a href="update.do">수정</a>/</td>
				<td><a href="delete.do">삭제</a></td>
			</tr>			
		</c:forEach>
		</table>
	</div>
</body>
</html>