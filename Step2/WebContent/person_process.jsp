<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="obj.Person" %>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	
	Person p = new Person(name,age);
	System.out.println(p.toString());
	
	request.setAttribute("obj", p);//키값을 obj로 p객체에 저장
	//페이지 이동 1과 동일한 jsp처리방식 : 이동할 페이지 경로, 응답 후 더이상 사용자의 요청을 받을 필요가 없을때
	//response.sendRedirect("person_result.jsp");
	//페이지 이동 2번째(이 방법을 많이씀) : 계속해서 사용자의 응답을 받아야 될때
	RequestDispatcher dispatcher = request.getRequestDispatcher("person_result.jsp");
	dispatcher.forward(request, response);//페이지 이동 수행
	
%>
<!-- 페이지 이동 1번쨰 방법 : 사용자의 요청이 전부 초기화 된다! 메인페이지 하나 보낼때 쓰는처리 
<script>
	location.href="person_result.jsp";
</script>-->
