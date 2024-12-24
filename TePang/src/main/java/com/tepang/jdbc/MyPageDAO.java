package com.tepang.jdbc;

import java.sql.SQLException;

import com.tepang.common.DAO;
import com.tepang.vo.OrderVO;
import com.tepang.vo.SingupVO;

public class MyPageDAO extends DAO {
	// 기본 페이지 : 회원별 누적 구매
	public OrderVO selectOrder(String memberId) {
		getConn();
		String osql = " SELECT * "//
				    + "   FROM tbl_order "//
				    + "  WHERE member_id = ? ";//
		try {
			psmt = conn.prepareStatement(osql);
			psmt.setString(1, memberId);
			rs = psmt.executeQuery();

			while (rs.next()) {
				OrderVO ovo = new OrderVO();
				ovo.setCartNum(rs.getString("cart_num"));
				ovo.setMemberId(rs.getString("member_id"));
				ovo.setOrderContent(rs.getString("order_content"));
				ovo.setOrderSum(rs.getInt("order_sum"));
				return ovo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}
	// 개인정보 수정
	public boolean UpdateInfo(SingupVO info) {
		getConn();
		String memInfo = " UPDATE tbl_member "//
				+ "    SET member_pw = ? "//
				+ "  WHERE member_id = ? ";//
		try {
			psmt = conn.prepareStatement(memInfo);
			psmt.setString(1, info.getMemberPw());
			psmt.setString(2, info.getMemberId());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}
}
