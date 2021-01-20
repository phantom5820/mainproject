package main;

import java.util.List;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class MyBatisMain {
	
	public static void main(String[] args) {
		EmployeeDAO dao = EmployeeDAO.getInstance();
		int count = dao.selectEmployeeAllCount();
		System.out.println("현재 사원 인원수 : "+ count);
		System.out.println("______________________________________");
		List<EmployeeDTO> list = dao.selectAllEmployee();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		System.out.println("______________________________________");
			list = dao.selectPositionEmployee(4);
			for (int j = 0; j < list.size(); j++) {
				System.out.println(list.get(j).toString());
		System.out.println("______________________________________");
		list = dao.selectPositionAreaEmployee(2, 5);
		for (int j2 = 0; j2 < list.size(); j2++) {
			System.out.println(list.get(j2).toString());
		}
			
			}
			
		}
	}
}
