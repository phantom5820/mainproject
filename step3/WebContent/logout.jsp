<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	session.invalidate();//세션을 무력화
    	response.sendRedirect("main.jsp");
    	//sendRedirect 세션정보는 그대로 유지, request 정보가 없어짐
    %>