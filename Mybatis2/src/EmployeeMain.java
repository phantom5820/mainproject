import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class EmployeeMain {
public static void main(String[] args) {
	List<EmployeeDTO> list = EmployeeDAO.getInstance().selectAllEmployee();
	for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i).toString());
	}
//	System.out.println("___________selectEmployeeCount_____________");
//	System.out.println(EmployeeDAO.getInstance().selectEmployeeCount());
//	System.out.println("_____________selectPositionEmployee___________");
//	list = EmployeeDAO.getInstance().selectPositionEmployee(3);
//	for (int i = 0; i < list.size(); i++) {
//		System.out.println(list.get(i).toString());
//	}
//	System.out.println("___________selectPositionAreaEmployee______________");
//	list = EmployeeDAO.getInstance().selectPositionAreaEmployee(2, 6);
//	for (int i = 0; i < list.size(); i++) {
//		System.out.println(list.get(i).toString());
//	}
//	System.out.println("___________insertEmployee______________");
	Scanner sc = new Scanner(System.in);
//	System.out.println("사번입력 : ");
//	String eno = sc.nextLine();
//	System.out.println("이름입력 : ");
//	String name = sc.nextLine();
//	System.out.println("부서입력 : ");
//	String department = sc.nextLine();
//	System.out.println("직급입력 : ");
//	int position = sc.nextInt();
//	System.out.println(EmployeeDAO.getInstance().insertEmployee(new EmployeeDTO(eno, name, department, position)));
	
//	String eno = sc.nextLine();
//	String name = sc.nextLine();
//	String department = sc.nextLine();
//	int position = sc.nextInt();
//	HashMap<String, Object> map = new HashMap<String, Object>();
//	map.put("eno", eno);
//	map.put("name", name);
//	map.put("department", department);
//	map.put("position", position);
//	System.out.println(EmployeeDAO.getInstance().updateEmployee(map));
	
	System.out.println("이름 검색");
	String name = sc.nextLine();
	list = EmployeeDAO.getInstance().selectNameEmployee(name);
	for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i).toString());
		
	}

}

	
	
	
}

