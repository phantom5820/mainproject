<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		int arr[][] = new int[num][3];	
	
		for(int i = 1;i<num;i++){
			for(int j=0;j<arr[i].length;j++){
				
			}
		}
	request.setAttribute("", arr);
	request.getRequestDispatcher("form_result.jsp");
	%>
</body>
</html>