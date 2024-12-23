package com.tepang.jdbc;

import java.sql.SQLException;

import com.tepang.common.DAO;
import com.tepang.vo.MainVO;

public class ProductDAO extends DAO {

	// 상품 상세.
	public MainVO selectProduct(String productCode) {
		getConn();
		String sql = "select * from tbl_product where product_code = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, productCode);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MainVO pvo = new MainVO();
				pvo.setCategory(rs.getString("category"));
				pvo.setProductCode(rs.getString("product_Code"));
				pvo.setProductDetail(rs.getString("product_Detail"));
				pvo.setProductName(rs.getString("product_Name"));
				pvo.setProductPrice(rs.getInt("product_Price"));
				pvo.setProductImg(rs.getString("product_Img"));
				pvo.setProductDetImg(rs.getString("product_DetImg"));
				pvo.setProductStock(rs.getInt("product_Stock"));
				pvo.setProductSale(rs.getString("product_Sale"));

				return pvo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

//파라미터 등록
	public boolean insertProduct(MainVO product) {
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
