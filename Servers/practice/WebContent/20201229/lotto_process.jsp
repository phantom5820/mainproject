<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	boolean checkNumber(int arr[],int n){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==n)
				return false;
		}
		return true;
}
	
%>

<% 
		int ea = Integer.parseInt(request.getParameter("ea"));
		Random r = new Random();
		int arr[][] = new int[ea][6];
		
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				int n = r.nextInt(45)+1;
				if(checkNumber(arr[i], n)){
					arr[i][j]=n;
				}else{
					j--;
					
				}
			}
		}
		request.setAttribute("lotto", arr);
		request.getRequestDispatcher("lotto_result.jsp").forward(request, response);
	


%>