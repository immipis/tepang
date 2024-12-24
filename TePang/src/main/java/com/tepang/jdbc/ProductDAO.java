package com.tepang.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tepang.common.DAO;
import com.tepang.common.SearchDTO;
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
			if (rs.next()) {
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

//상품목록

	public List<MainVO> productList(SearchDTO search) {
		getConn();
		String sql = "select b.* " + "   from( select rownum rn, a.*" + "        from (select *"
				+ "              from tbl_product";
		// Title 검색조건 => title 컬럼에서 값을 조회.
		if (search.getSearchCondition() != null && search.getKeyword() != null) {
			if (search.getSearchCondition().equals("T")) {
				sql += "             where title like '%'||?||'%' ";
			} else if (search.getSearchCondition().equals("W")) {
				sql += "             where writer like '%'||?||'%' ";
			} else if (search.getSearchCondition().equals("TW")) {
				sql += "             where title like '%'||?||'%' or writer like '%'||?||'%'";
			}
		}
		sql += "              order by board_no desc) a) b" + "   where b.rn > (? -1) * 5" + "   and b.rn <= ? * 5";
		// \r\n은 줄바꿈
		List<MainVO> result = new ArrayList<>(); // 반환값.
		int cnt = 1;
		try {
			psmt = conn.prepareStatement(sql);
			if (search.getSearchCondition() != null && search.getKeyword() != null) {
				if (search.getSearchCondition().equals("T")) {
					psmt.setString(cnt++, search.getKeyword());// 첫번째 파라미터
				} else if (search.getSearchCondition().equals("W")) {
					psmt.setString(cnt++, search.getKeyword()); // 첫번째 파라미터
				} else if (search.getSearchCondition().equals("TW")) {// 첫번째 파라미터, 두번째 파라미터
					psmt.setString(cnt++, search.getKeyword());
					psmt.setString(cnt++, search.getKeyword());
				}
			}
			psmt.setInt(cnt++, search.getPage());
			psmt.setInt(cnt++, search.getPage());
			System.out.println(sql);

			rs = psmt.executeQuery(); // 조회.

			while (rs.next()) {
				MainVO brd = new MainVO();

				brd.setProductCode(rs.getString("product_Code"));
				brd.setCategory(rs.getString("category"));
				brd.setProductDetail(rs.getString("product_Detail"));
				brd.setProductName(rs.getString("product_Name"));
				brd.setProductImg(rs.getString("product_Img"));
				brd.setProductDetImg(rs.getString("product_DetImg"));
				brd.setProductSale(rs.getString("product_Sale"));
				brd.setProductStock(rs.getInt("product_Stock"));
				brd.setProductPrice(rs.getInt("product_Price"));

				result.add(brd); // ArrayList에 추가.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}
}
