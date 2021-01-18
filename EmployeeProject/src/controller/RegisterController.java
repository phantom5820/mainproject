package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EmployeeDTO;
import exception.EmployeeException;
import model.ModelAndView;
import service.EmployeeService;

public class RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String eno = request.getParameter("eno");
		String name =request.getParameter("name");
		String department = request.getParameter("department");
		int position = Integer.parseInt(request.getParameter("position"));
		
		EmployeeDTO dto = new EmployeeDTO(eno, name, department, position);
			EmployeeService.getInstance().insertemployeeDTO(dto);
			view = new ModelAndView("login.jsp", true);
			try {
				response.getWriter().write("<script>alert('사원정보 등록실패 입력한 데이터를 확인하세요');history.back();</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return view;
	}

}








