package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EmployeeDTO;
import exception.EmployeeException;
import exception.MemberException;
import model.ModelAndView;
import service.EmployeeService;
import service.MemberService;
import vo.MemberVO;

public class UpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		int position = Integer.parseInt(request.getParameter("positon"));
		ModelAndView view = null;;
			try {
				if(name == null || department == null || position == 0) {
					response.getWriter().append("<script>alert('데이터를 전부 입력해 주세요'); history.back();</script>");
				}
				EmployeeDTO dto = new EmployeeDTO(null, name, department, position);
				EmployeeService.getInstance().updateManageEmployeeDTO(dto);
				request.getSession().setAttribute("name", dto.getName());
				view = new ModelAndView("login.jsp",true);
			} catch (IOException e) {
				e.printStackTrace();
			
		return view;
	}

}



