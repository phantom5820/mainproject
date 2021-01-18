package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.EmployeeDTO;
import exception.EmployeeException;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	
	private EmployeeDAO() {

	}

	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		return instance;
	}

	public EmployeeDTO login(String name, String eno) {
		EmployeeDTO dto = null;
		String sql = "select e.eno, e.name, e.department, e.position, p.name from employee e, position_list p where e.position = p.pno and e.name like ? and e.eno like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DBManager.getInstance().getSource().getConnection().prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, eno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(pstmt, rs);
		}
		
		return dto;
	}

	public void updateEmployee(EmployeeDTO dto) {
		String sql = "update employee set name = ? and department = ? and position = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DBManager.getInstance().getSource().getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public ArrayList<EmployeeDTO> salaryplus() {
//		EmployeeDTO dto = null;
//		String sql = "select e.eno, e.name, e.department, s.salary from employee e, employee_salary s where "
//		return null;
//	}
	
//	public EmployeeDAO selectMemberVO(String id) {
//		MemberVO vo = null;
//		String sql = "select * from member where id like ?";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				vo = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBManager.getInstance().close(pstmt, rs);
//		}
//		
//		return vo;
//	}
//	
//	public void insertemployeeVO(EmployeeVO vo) throws EmployeeException {
//		PreparedStatement pstmt = null;
//		String sql = "insert into employee(eno,name,department,position) values(?,?,?,?)";
//		try {
//			pstmt = DBManager.getInstance().getSource().getConnection().prepareStatement(sql);
//			pstmt.setString(1, vo.getEno());
//			pstmt.setString(2, vo.getName());
//			pstmt.setString(3, vo.getDepartment());
//			pstmt.setInt(4, vo.getPosition());
//			int count = pstmt.executeUpdate();
//			if(count == 0)
//				throw new EmployeeException("사원등록에 실패했습니다.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void updatePass(String eno, String name) throws EmployeeException {
//		PreparedStatement pstmt = null;
//		String sql = "update  member set pass = ? where id = ?";
//		try {
//			pstmt = DBManager.getInstance().getSource().getConnection().prepareStatement(sql);
//			pstmt.setString(1, eno);
//			pstmt.setString(2,name);
//			int count = pstmt.executeUpdate();
//			if(count == 0)
//				throw new EmployeeException("정보수정에 실패했습니다.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//
//	public void updateMember(EmployeeVO vo) throws EmployeeException {
//		String sql = "update employee set name=?,position=?,department=? where eno=?";
//		PreparedStatement pstmt = null;
//		try {
//			pstmt = DBManager.getInstance().getSource().getConnection().prepareStatement(sql);
//			pstmt.setString(1, vo.getPass());
//			pstmt.setString(2, vo.getName());
//			pstmt.setInt(3, vo.getAge());
//			pstmt.setString(4, vo.getId());
//			
//			int count = pstmt.executeUpdate();
//			if(count == 0)
//				throw new EmployeeException("수정할 사원정보가 없습니다.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public ArrayList<EmployeeVO> selectAllEmployeeVO() {
//		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
//		String sql = "select id, name, pass, age, grade_name "
//				+ "from member, grade_list where grade_no = grade order by grade desc";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		 
//		try {
//			pstmt = DBManager.getInstance().getSource().getConnection().prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				list.add(new EmployeeVO(rs.getString(1), null, rs.getString(2), 
//						rs.getInt(4), rs.getString(5)));
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBManager.getInstance().close(pstmt, rs);
//		}
//		
//		return list;
//	}
//
//	public ArrayList<MemberVO> searchMember(String kind, String search) {
//		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
//		String sql = "select id, name, pass, age, grade_name "
//				+ "from member, grade_list where grade_no = grade and " + kind + " like ? order by grade desc";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
//			pstmt.setString(1, "%" + search + "%");
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				list.add(new MemberVO(rs.getString(1), null, rs.getString(2), 
//						rs.getInt(4), rs.getString(5)));
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBManager.getInstance().close(pstmt, rs);
//		}
//		
//		return list;
//	}
//
//	public boolean updateManageMember(MemberVO vo) {
//		String sql = "update member set name=?,age=?,grade="
//				+ "(select grade_no from grade_list where grade_name = ?) where id=?";
//		
//		PreparedStatement pstmt = null;
//		try {
//			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
//			pstmt.setString(1, vo.getName());
//			pstmt.setInt(2, vo.getAge());
//			pstmt.setString(3, vo.getGrade());
//			pstmt.setString(4, vo.getId());
//			
//			int count = pstmt.executeUpdate();
//			if(count == 0)
//				return false;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return true;
//	}
//	
//	
//	public boolean deleteMember(String id) {
//		String sql = "delete from member where id=?";
//		
//		PreparedStatement pstmt = null;
//		try {
//			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
//			pstmt.setString(1, id);
//
//			int count = pstmt.executeUpdate();
//			if(count == 0)
//				return false;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return true;
//	}
//	
	
	
	
}



















