package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import exception.MemberException;
import vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private SqlSession session;
	private MemberDAO() {
		session = DBManager.getInstance().getSession();
	}

	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}

	public MemberVO selectMemberVO(String id) {
		return session.selectOne("member.selectMemberVO", id);
	}
	
	public void insertMemberVO(MemberVO vo) {
		session.insert("member.insertMemberVO", vo);
	}

	public void updatePass(String id, String pass) throws MemberException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pass", pass);
		
		session.update("member.updatePass", map);
	}

	public MemberVO login(String id, String pass) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pass", pass);
		return session.selectOne("member.login", map);
	}

	public void updateMember(MemberVO vo) throws MemberException {
		session.update("member.update", vo);
		//session.commit(); <-----만약 디비메니저에서 오토커밋 트루를 안해놓았다면 반드시 해주어야한다!!
	}

	public List<MemberVO> selectAllMemberVO() {
		//반드시 ArrayList를 사용할 필요가없음 이유는 : ArrayList를 사용하면 is써서 검사하고 해야하기때문에 대부분 List를 사용한다
		List<MemberVO> list = session.selectList("member.selectAllMemberVO");
		return list;
	}

	public List<MemberVO> searchMember(String kind, String search) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		return session.selectList("member.searchMember", map);
	}

	public int updateManageMember(MemberVO vo) {
		int count = session.update("member.updateManageMember", vo);
		session.commit();
		return count;
	}
	
	
	public int deleteMember(String id) {
		int count = session.delete("member.deleteMember", id);
		session.commit();
		return count;
	}
	
	
	
	
}




