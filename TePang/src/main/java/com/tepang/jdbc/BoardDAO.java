package com.tepang.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tepang.common.DAO;
import com.tepang.vo.BoardVO;

public class BoardDAO extends DAO {

//	// 수정(내용,제목)
//		public boolean updateBoard(BoardVO board) {
//			getConn();
//			String sql = "UPDATE tbl_reply " //
//					+ "   SET    reply_content = ? " //
//					+ "          , reply_answer = ? " + "   WHERE  reply_code = ? "; //
//
//			try {
//				psmt = conn.prepareStatement(sql);
//				psmt.setString(1, board.getReplyContent());
//				psmt.setString(2, board.getReplyContent());
//				psmt.setString(3, board.getReplyCode());
//				int r = psmt.executeUpdate(); // 쿼리실행.
//				if (r > 0) {
//					return true;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				disConnect();
//			}
//			return false;
//		}
//
	// 상세조회. 파라미터(int boardNo) selectBoard 반환값: BoardVO.
	public List<BoardVO> selectBoard(String replyType) {

		getConn();

		List<BoardVO> list = new ArrayList<>();
		String sql = "select * from tbl_reply where reply_type = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, replyType);
			rs = psmt.executeQuery(); // 조회.

			while (rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setReplyCode(rs.getString("reply_code"));
				brd.setReplyContent(rs.getString("reply_content"));
				brd.setReplyAnswer(rs.getString("reply_answer"));
				brd.setMemberId(rs.getString("member_id"));
				brd.setReplyDate(rs.getDate("reply_date"));
				
				list.add(brd);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

//		// BoardVO 파라미터 => 등록.
//		public boolean insertBoard(BoardVO board) {
//			getConn();
//			String sql = "insert into tbl_reply " //
//					+ "(reply_code, reply_content, member_id, reply_date, reply_answer ) " //
//					+ "values(reply_seq.nextval, ?, ?, ? ) ";
//
//			try {
//				psmt = conn.prepareStatement(sql);
//				psmt.setString(1, board.getReplyCode());
//				psmt.setString(2, board.getReplyContent());
//				psmt.setString(3, board.getMemberId());
//				psmt.setString(4, board.getReplyAnswer());
//				int r = psmt.executeUpdate(); // 쿼리실행.
//				if (r > 0) {
//					return true;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				disConnect();
//			}
//			return false;
//		}

//		// 목록.
//		public List<BoardVO> boardList(BoardVO board) {
//			getConn();
//			String sql = "SELECT * FROM tbl_reply WHERE reply_code = ? ";
//
//			
//			List<BoardVO> result = new ArrayList<>(); // 반환값.
//
//			try {
//				psmt = conn.prepareStatement(sql);
//				psmt.setString(1, board.getReplyCode());
//				psmt.setString(2, board.getReplyContent());
//				psmt.setString(3, board.getMemberId());
//				rs = psmt.executeQuery();
//				
//				System.out.println(sql);
//
//				rs = psmt.executeQuery(); // 조회.
//
//				while (rs.next()) {
//					BoardVO brd = new BoardVO();
//					brd.setReplyCode(rs.getString("reply_code"));
//					brd.setReplyContent(rs.getString("reply_content"));
//					brd.setMemberId(rs.getString("member_id"));					
//					brd.setReplyDate(rs.getDate("reply_date"));
//
//					result.add(brd); // ArrayList에 추가.
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				disConnect();
//			}
//			return result;
//		}

}
