package service;


import java.util.ArrayList;

import dao.EmployeeDAO;
import dto.EmployeeDTO;
import exception.EmployeeException;

public class EmployeeService {
	private static EmployeeService instance = new EmployeeService();
	private EmployeeDAO dao;
	private EmployeeService() {
		dao = EmployeeDAO.getInstance();
	}
	
	public static EmployeeService getInstance() {
		if(instance==null)
			instance= new EmployeeService();
		return instance;
	}
	
	
	public EmployeeDTO login(String name, String eno) {
		
		return dao.login(name,eno);
	}

	public void insertemployeeDTO(EmployeeDTO dto) {
		
	}

	public void updateManageEmployeeDTO(EmployeeDTO dto) {
		dao.updateEmployee(dto);
		
	}

	public Object selectEmployeeDTO(String name) {
		
		return null;
	}

	public ArrayList<EmployeeDTO> plusSalaryList() {
		
		return null;
	}


	}
	
	
	











