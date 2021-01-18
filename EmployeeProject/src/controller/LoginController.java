package controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.EmployeeDTO;
import model.ModelAndView;
import service.EmployeeService;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String name = request.getParameter("name");
		String eno = request.getParameter("eno");
		EmployeeDTO dto = EmployeeService.getInstance().login(name, eno);
		HttpSession session = request.getSession();
		ModelAndView view = new ModelAndView();
		if(dto != null) {
			//세션 처리
			session.setAttribute("login", true);
			session.setAttribute("name", dto.getName());
			session.setAttribute("eno", dto.getEno());
			session.setAttribute("position", dto.getPosition());
			view.setPage("employee_manager.jsp");
			view.setSendRedirect(true);
		}else {
			session.setAttribute("login", false);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('입력하신 정보를 확인하세요');history.back();</script>");
			
		}
		return view;
	}

}



