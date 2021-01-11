<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int age = Integer.parseInt(request.getParameter("age"));
	String path = "";
	
	if(age <= 19){
		path = "age_result1.jsp";	
	}else if(age <= 50){
		path = "age_result2.jsp";
	}else{
		path = "age_result3.jsp";
	}
	
	request.getRequestDispatcher(path).forward(request, response);
%>