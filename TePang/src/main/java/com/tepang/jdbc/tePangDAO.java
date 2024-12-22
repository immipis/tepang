package com.tepang.jdbc;

import java.sql.SQLException;

import com.tepang.common.DAO;
import com.tepang.vo.SingupVO;

import lombok.Data;

@Data
public class tePangDAO extends DAO {
	
	public String login(String id, String pw) {
		getConn();
		String sql = "select * from tbl_member" + "            where member_id = ?" + "            and   password = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getString("member_id");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	public boolean insertBoard(SingupVO sing) {
		getConn();
		System.out.println(sing.getMemberId() + sing.getMemberPw() + sing.getMemberName() + sing.getMemberPhone() + sing.getMemberAdr() + sing.getMemberGen() + sing.getMemberFv());
		String sql = "insert into tbl_member" + "(member_id, member_pw, member_name, member_phone, member_adr, member_gen, member_fv)"
				+ "values(tepang_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";

	    int insertCount=0;
	    
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sing.getMemberId());
			psmt.setString(2, sing.getMemberPw());
			psmt.setString(3, sing.getMemberName());
			psmt.setString(4, sing.getMemberPhone());
			psmt.setString(5, sing.getMemberAdr());
			psmt.setString(5, sing.getMemberBir());
			psmt.setString(6, sing.getMemberGen());
			psmt.setString(7, sing.getMemberFv());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

}