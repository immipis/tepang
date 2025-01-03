package com.tepang.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tepang.common.DAO;
import com.tepang.vo.CartVO;

public class CartDAO extends DAO{
    public List<CartVO> cartList(String memberId, String cartType) {
    	getConn();
    	String sql = "select c.product_code,p.product_img, m.member_id, c.cart_type, c.cart_num,p.product_name, p.product_price, c.product_num, (p.product_price * c.product_num) "
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
				cvo.setCartNum(rs.getString("cart_num"));
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
    
    // 등록.
    public boolean insertCart(CartVO cvo) {
    	getConn();
    	String sql = "insert into tbl_cart (cart_num, product_code, member_id, product_num, cart_type)\r\n"
    			+ "values('CA'||?, ?, ?, ?, '장바구니')";
    	try {
    		psmt = conn.prepareStatement("select cart.nextval from dual");
    		rs = psmt.executeQuery();
    		String cno = "0";
    		if (rs.next()) {
    			cno = rs.getString(1);
    			cvo.setCartNum(cno);
    		}
    	
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cno);
			psmt.setString(2, cvo.getProductCode());
			psmt.setString(3, cvo.getMemberId());
			psmt.setInt(4, cvo.getProductNum());
			
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
    
    public boolean insertLike(CartVO cvo) {
    	getConn();
    	String sql = "insert into tbl_cart (cart_num, product_code, member_id, cart_type)\r\n"
    			+ "values('CA'||?, ?, ?, '찜')";
    	try {
    		
    		psmt = conn.prepareStatement("select cart.nextval from dual");
    		rs = psmt.executeQuery();
    		String cno = "0";
    		if (rs.next()) {
    			cno = rs.getString(1);
    			cvo.setCartNum(cno);
    		}
    		
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cno);
			psmt.setString(2, cvo.getProductCode());
			psmt.setString(3, cvo.getMemberId());
			
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
    
    // 상품 갯수 수정
    public boolean updateCart(CartVO ucart) {
		getConn();
		System.out.println(ucart);
		String sql = "update tbl_cart "//
				+ "   set    product_num = ?"//
				+ "   where member_id = ?"
				+ "   and product_code = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ucart.getProductNum());
			psmt.setString(2, ucart.getMemberId());
			psmt.setString(3, ucart.getProductCode());
			
			int r = psmt.executeUpdate(); // 쿼리 실행.
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
    
    // 삭제
    public boolean deleteCart(String cartNum) {
		getConn();
		String sql ="delete from tbl_cart where cart_num = ? and cart_type = '장바구니'";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cartNum);
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
    
    public boolean removeLike(String cartNum) {
		getConn();
		String sql ="delete from tbl_cart where cart_num = ? and cart_type = '찜'";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cartNum);
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
    
    // 결제 (결제 버튼 누르면 장바구니 목록 제거 구매목록에 등록)
    public boolean deleteCart2(String memberId) {
    	getConn();
    	String sql = "delete from tbl_cart where member_id = ? and cart_type = '장바구니'";
    	try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberId);
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
    
    public int Count(String memberId) {
    	getConn();
    	int a = 0;
    	String sql = "select COUNT(*) as cnt\r\n"
    			+ "FROM tbl_cart\r\n"
    			+ "where member_id = ?"
    			+ "and cart_type = '장바구니'";
    	try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberId);
			
			rs = psmt.executeQuery();
			
		
			while (rs.next()) {
				a = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
    	return a;
    } 
    
    public int likeCount(String memberId) {
    	getConn();
    	int a = 0;
    	String sql = "select COUNT(*) as cnt\r\n"
    			+ "FROM tbl_cart\r\n"
    			+ "where member_id = ?"
    			+ "and cart_type = '찜'";
    	try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberId);
			
			rs = psmt.executeQuery();
			
		
			while (rs.next()) {
				a = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
    	return a;
    } 
    
    public boolean insertOrder(CartVO cvo) {
    	getConn();
    	String sql = "insert into tbl_order (cart_num, order_adr, order_name, order_phone, order_request, order_sum, member_id, order_no)\r\n"
    			+ "values(?, ?, ?, ?, ?, ?, ?, 'O'||?)";
    	try {
    		psmt = conn.prepareStatement("select onum.nextval from dual");
    		rs = psmt.executeQuery();
    		String ono = "0";
    		if (rs.next()) {
    			ono = rs.getString(1);
    			cvo.setOrderNo(ono);
    		}
    		
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cvo.getCartNum());
			psmt.setString(2, cvo.getOrderAdr());
			psmt.setString(3, cvo.getOrderName());
			psmt.setString(4, cvo.getOrderPhone());
			psmt.setString(5, cvo.getOrderRequest());
			psmt.setInt(6, cvo.getOrderSum());
			psmt.setString(7, cvo.getMemberId());
			psmt.setString(8, ono);
			
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
