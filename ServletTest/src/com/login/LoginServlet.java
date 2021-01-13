package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")//URL Mapping(맵핑이란 연결해주는것이다)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //method의 속성값이 get일때 처리하는 메서드이다!
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");//화면에 출력할때 문자코드 및 내용형식(콘텐트)을 설정해주는 부분
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append(request.getParameter("id"));
		//세션처리
		HttpSession session = request.getSession();//request에서 세션 정보를 읽어옴
		session.setAttribute("text", "세션메세지");
		//페이지 이동
//		response.sendRedirect("login_result.jsp");//사용자의 요청사항이 전부 소실((예)로그아웃 할때 사용)
		System.out.println(request.getRequestURI());
		request.setAttribute("id", request.getParameter("id"));
		request.getRequestDispatcher("result/login_result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//method의 속성값이 post일때 처리하는 메서드이다!
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//한글 깨짐 방지(데이터를 받았을때 문자코드 변경해주는 부분)
		doGet(request, response);
	}

}
