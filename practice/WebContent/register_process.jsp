<%@page import="service.MemberService"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));

	MemberVO vo = new MemberVO(id,pass,name,age);
	System.out.println(vo.toString());
	MemberService.getInstance().insertMemberVO(vo);
	
	request.getRequestDispatcher("login.jsp").forward(request, response);
%>