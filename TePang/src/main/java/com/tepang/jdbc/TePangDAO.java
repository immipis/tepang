package com.tepang.jdbc;

import java.sql.SQLException;

import com.tepang.common.DAO;
import com.tepang.vo.SingupVO;

public class TePangDAO extends DAO {
	
	public String login(String id, String pw) {

		getConn();
		String sql = "select * from tbl_member" 
		+ "            where member_id = ?"
		+ "            and   member_pw = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);


			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getString("member_name");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	public boolean insertSignup(SingupVO singup) {
		getConn();
		System.out.println(singup);
		String sql = "insert into tbl_member (member_id,member_pw,member_name,member_phone,member_adr,member_bir,member_gen,member_fv)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, singup.getMemberId());
			psmt.setString(2, singup.getMemberPw());
			psmt.setString(3, singup.getMemberName());
			psmt.setString(4, singup.getMemberPhone());
			psmt.setString(5, singup.getMemberAdr());
			psmt.setString(6, singup.getMemberBir());
			psmt.setString(7, singup.getMemberGen());
			psmt.setString(8, singup.getMemberFv());
			
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}
}
