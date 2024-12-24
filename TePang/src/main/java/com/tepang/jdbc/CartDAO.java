package com.tepang.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tepang.common.DAO;
import com.tepang.vo.CartVO;

public class CartDAO extends DAO{
    public List<CartVO> cartList(String memberId, String cartType) {
    	getConn();
    	String sql = "select c.product_code,p.product_img, m.member_id, c.cart_type,p.product_name, p.product_price, c.product_num, (p.product_price * c.product_num) "
    			+ "from tbl_cart c, tbl_product p, tbl_member m "
    			+ "where c.cart_type = ? "
    			+ "and c.member_id = m.member_id "
    			+ "and c.product_code = p.product_code "
    			+ "and c.member_id = ? ";
    	List<CartVO> clist = new ArrayList<>();
    	try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cartType);
			psmt.setString(2, memberId);
			
			rs = psmt.executeQuery();
			while (rs.next()) {
				CartVO cvo = new CartVO();
				cvo.setProductCode(rs.getString("product_code"));
				cvo.setProductName(rs.getString("product_name"));
				cvo.setProductImg(rs.getString("product_img"));
				cvo.setMemberId(rs.getString("member_id"));
				cvo.setCartType(rs.getString("cart_type"));
				cvo.setProductNum(rs.getInt("product_num"));
				cvo.setProductPrice(rs.getInt("product_price"));
				
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
