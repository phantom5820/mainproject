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
@WebServlet("/LoginServlet")//URL Mapping(맵핑이란 연결하는것!!)
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
    //method의 속성값이 get일때 처리하는 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");//★화면에 출력할때 문자코드 및 콘텐트(내용형식)을 설정해주는 부분!!(한글깨짐방지!)
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append(request.getParameter("id"));
		//세션
		HttpSession session = request.getSession();//request 에서 세션정보를 읽어옴
		session.setAttribute("text", "session message");
		//페이지 이동
	//	response.sendRedirect("login_result.jsp"); //사용자의 요청사항이 전부 소실되는부분(더이상 응답을 받을필요가 없을떄 쓰인다 예)로그아웃)
		System.out.println(request.getRequestURI());
		request.setAttribute("id", request.getParameter("id"));
		request.getRequestDispatcher("/result/login_result.jsp").forward(request, response);
		System.out.println(request.getRequestURI());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//method의 속성값이 post일때 처리하는 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//한글 꺠짐 방지!!(데이터를 받았을때 문자코드 변경)
		doGet(request, response);
	}

}
