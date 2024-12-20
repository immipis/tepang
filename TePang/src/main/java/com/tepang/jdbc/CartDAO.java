package com.tepang.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tepang.common.DAO;
import com.tepang.vo.CartVO;

public class CartDAO extends DAO{
    public List<CartVO> cartList(String memberId, String cartType) {
    	getConn();
    	String sql = "select * from tbl_cart where member_id = ? and cart_type = ?";
    	List<CartVO> clist = new ArrayList<>();
    	try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberId);
			psmt.setString(2, cartType);
			
			rs = psmt.executeQuery();
			while (rs.next()) {
				CartVO cvo = new CartVO();
				cvo.setCartNum(rs.getString("cart_num"));
				cvo.setProductCode(rs.getString("product_code"));
				cvo.setMemberId(rs.getString("member_id"));
				cvo.setProductNum(rs.getInt("product_num"));
				cvo.setCartType(rs.getString("cart_type"));
				
				clist.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
    	return clist;
    }
}
