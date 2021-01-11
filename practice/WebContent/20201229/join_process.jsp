<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="obj.Join"%>

<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	Join j = new Join(id,pw);
	
	request.setAttribute("obj", j);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("join_result.jsp");
	dispatcher.forward(request, response);


%>