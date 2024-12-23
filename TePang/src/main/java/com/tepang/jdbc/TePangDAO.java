package com.tepang.jdbc;

import java.sql.SQLException;

import com.tepang.common.DAO;


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
	
}
