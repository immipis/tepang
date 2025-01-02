package com.tepang.jdbc;

import java.sql.SQLException;

import com.tepang.common.DAO;
import com.tepang.vo.BoardVO;

public class BoardFormDAO extends DAO{
	
	// BoardVO 파라미터 => 등록.
			public boolean insertBoard(BoardVO board) {
				getConn();
				String sql = "insert into tbl_reply " //
						+ " (reply_code, member_id, reply_content, reply_type ) " //
						+ " values('N0'||R00.nextval, ?, ?, ? ) ";

				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, board.getMemberId());
					psmt.setString(2, board.getReplyContent());					
					psmt.setString(3, board.getReplyType());
					
					int r = psmt.executeUpdate(); // 쿼리실행.
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
