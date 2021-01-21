package main;

import java.util.List;
import java.util.Scanner;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class MyBatisMain {
	
	public static void main(String[] args) {
		EmployeeDAO dao = EmployeeDAO.getInstance();
//		List<EmployeeDTO> list = dao.selectAllEmployee();
//		int count = dao.selectEmployeeAllCount();
//		System.out.println("현재 사원 인원수 : "+ count);
//		System.out.println("______________________________________");
//		for (int i = 0; i < list.size(); i++) 
//			System.out.println(list.get(i).toString());
//		System.out.println("______________________________________");
//			list = dao.selectPositionEmployee(4);
//			for (int i = 0; i < list.size(); i++) 
//				System.out.println(list.get(i).toString());
//		System.out.println("______________________________________");
//		list = dao.selectPositionAreaEmployee(2,5);
//		for (int i = 0; i < list.size(); i++) 
//			System.out.println(list.get(i).toString());
//		list = dao.insertEmployee("TX35","박길동","영업",3);
//		for (int i = 0; i < list.size(); i++) 
//			System.out.println(list.get(i).toString());
//		Scanner sc = new Scanner(System.in);
//		EmployeeDTO dto = null;
//		
//		String eno = sc.nextLine();
//		String name = sc.nextLine();
//		String department = sc.nextLine();
//		int position = sc.nextInt();
//		int count = dao.insertEmployee(new EmployeeDTO(eno, name, department, position));
//		System.out.println(count);
//		System.out.println("______________________________________");
//		List<EmployeeDTO> list = dao.selectAllEmployee();
//		for (int i = 0; i < list.size(); i++) 
//			System.out.println(list.get(i).toString());
//		
	Scanner sc = new Scanner(System.in);
	
	
//	String eno = sc.nextLine();
//	String name = sc.nextLine();
//	String department = sc.nextLine();
//	int position = sc.nextInt();
//	int count = dao.updateEmployee(new EmployeeDTO(eno, name, department, position));
//	System.out.println(count);
//	System.out.println("______________________________________");
//	list = dao.selectAllEmployee();
//	for (int i = 0; i < list.size(); i++) 
//		System.out.println(list.get(i).toString());
//	System.out.println("______________________________________");
//	System.out.println("검색할 이름 일부를 입력하세요");
//	String search = sc.nextLine();
//	List<EmployeeDTO> list = dao.selectNameEmployee(search);
//	for (int i = 0; i < list.size(); i++) {
//		System.out.println(list.get(i).toString());
	System.out.println("삭제할 직급 번호 입력 1~7 : ");
	int position = sc.nextInt();
	System.out.println(dao.deleteEmployee(position));
	List<EmployeeDTO> list = dao.selectAllEmployee();
	for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i).toString());
		
	}
		
	}
	}

