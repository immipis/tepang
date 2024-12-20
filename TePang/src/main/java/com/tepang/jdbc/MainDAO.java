package com.tepang.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tepang.common.DAO;
import com.tepang.vo.MainVO;

public class MainDAO extends DAO{
	public List<MainVO> addpList(String id) {
		getConn();
		String sql = "select * from tbl_product p,tbl_member m where m.member_id = ? and m.member_fv = p.category";
		List<MainVO> pList = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				MainVO mvo = new MainVO();
				mvo.setProductImg(rs.getString("product_img"));
				mvo.setProductName(rs.getString("product_name"));
				mvo.setProductPrice(rs.getInt("product_price"));
				pList.add(mvo);
				return pList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}
}
