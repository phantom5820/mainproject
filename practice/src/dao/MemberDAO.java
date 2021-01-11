package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBManager;
import vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();

	
	
	private MemberDAO() {

	}



	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}
	
	public MemberVO selectMemberVO(String id) {
		MemberVO vo = null;
		String sql = "select * from member where id like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
}
