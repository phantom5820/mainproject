package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.EmployeeDTO;

public class MemberDAO2 {
	private static MemberDAO2 instance = new MemberDAO2();
	private SqlSessionFactory factory;
	private SqlSession session;
	private MemberDAO2() {
		String resource = "config/Mybatis_cofig.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession(true); //★openSession안에 true를 넣으면 오토커밋을 해준다는 뜻이다!!!!★ false 이면 not auto commit이다
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static  MemberDAO2 getInstance() {
		if(instance == null)
			instance = new  MemberDAO2();
		return instance;
	}

	public int selectEmployeeAllCount() {
		int count = 0;
		count = session.selectOne("db.sqlmapper.selectAllCountEmployee");
		return count;
	}
	public List<MemberDTO> selectAllEmployee() {
		List<MemberDTO> list = session.selectList("db.sqlmapper.selectAllEmployee");
		return list;
	}
	public List<EmployeeDTO> selectPositionEmployee(int pos) {
		return session.selectList("db.sqlmapper.selectPositionEmployee", pos);
	}
	/* 직급이 start부터 end까지 */
	public List<EmployeeDTO> selectPositionAreaEmployee(int start,int end) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("n1", start);
		map.put("n2", end);
		
		return session.selectList("db.sqlmapper.selectPositionAreaEmployee", map);
	}
	
		public int insertEmployee(EmployeeDTO dto) {
			return session.insert("db.sqlmapper.insertEmployee", dto);
}
		public int updateEmployee(EmployeeDTO dto) {
			return session.update("db.sqlmapper.updateEmployee", dto);
		}
		public List<EmployeeDTO> selectNameEmployee(String search) {
			return session.selectList("db.sqlmapper.selectNameEmployee", search);
		}
		public int deleteEmployee(int position) {
			return session.delete("db.sqlmapper.deleteEmployee", position);
		}
}
