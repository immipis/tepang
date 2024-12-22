package com.tepang.jdbc;

import java.sql.SQLException;

import com.tepang.common.DAO;
import com.tepang.vo.OrderVO;


public class MyPageDAO extends DAO {
	// 기본 페이지 : 회원별 구매 페이지 
	public OrderVO selectOrder(String memberId) {
		getConn();
		String osql = " SELECT * "
				        + "   FROM tbl_order "
				        + "  WHERE member_id = ? "
				        + "  ORDER BY order_num DESC ";
		try {
			psmt = conn.prepareStatement(osql);
			psmt.setString(1, memberId);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				OrderVO ovo = new OrderVO();
				ovo.setOrderNum(rs.getString("order_no"));
				ovo.setMemberId(rs.getString("member_id"));
				ovo.setProductCode(rs.getString("product_code"));
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
}
