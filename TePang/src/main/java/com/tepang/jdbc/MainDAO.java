package com.tepang.jdbc;

import java.io.Console;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tepang.common.DAO;
import com.tepang.vo.MainVO;

public class MainDAO extends DAO{
	public List<MainVO> addpList(String id) {
		getConn();
		String sql = "select * from tbl_product";
		if (id != null) {
			sql += "123";
		}
		List<MainVO> pList = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				MainVO mvo = new MainVO();
				mvo.setProductCode(rs.getString("product_code"));
				mvo.setProductImg(rs.getString("product_img"));
				mvo.setProductName(rs.getString("product_name"));
				mvo.setProductPrice(rs.getInt("product_price"));
				mvo.setProductDetail(rs.getString("product_detail"));
				pList.add(mvo);
			}
			return pList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}
}
