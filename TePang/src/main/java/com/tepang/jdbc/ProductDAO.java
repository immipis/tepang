package com.tepang.jdbc;

import java.sql.SQLException;

import com.tepang.common.DAO;
import com.tepang.vo.ProductVO;

public class ProductDAO extends DAO {

	// 상품 상세.
	public ProductVO selectProduct(String productCode) {
		getConn();
		String sql = "select * from tbl_product where product_code = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, productCode);
			rs = psmt.executeQuery();
			if (rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setCategory(rs.getString("category"));
				pvo.setProductCode(rs.getString("product_code"));
				pvo.setProductDetail(rs.getString("product_detail"));
				pvo.setProductName(rs.getString("product_Name"));
				pvo.setProductPrice(rs.getInt("product_Price"));
				pvo.setProductImg(rs.getString("product_Img"));
				pvo.setProductDetImg(rs.getString("product_DetImg"));
				pvo.setProductStock(rs.getInt("product_Stock"));
				
				return pvo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return null;
	}

//파라미터 등록
	public boolean insertBoard(ProductVO product) {
		getConn();
		String sql = "insert into tbl_product"
				+ "   (product_code, product_detail, product_name, product_price, product_Img, product_detimg, product_stock, category)"
				+ "   values(product_seq.nextval,?,?,?,?,?,?,? )";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, product.getCategory());
			psmt.setString(2, product.getProductDetail());
			psmt.setString(3, product.getProductName());
			psmt.setInt(4, product.getProductPrice());
			psmt.setString(5, product.getProductImg());
			psmt.setString(6, product.getProductDetImg());
			psmt.setInt(7, product.getProductStock());
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return false;
	}
	
	
}