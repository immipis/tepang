package com.tepang.jdbc;

import java.io.Console;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tepang.common.DAO;
import com.tepang.vo.MainVO;

public class MainDAO extends DAO{
	public List<MainVO> addpList() {
		getConn();
		String sql = "select * from tbl_product";
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
	
	public List<MainVO> pCategoryList(String p) {
		getConn();
		System.out.println("여기실행됨"+p);
		String sql = "select * from tbl_product where category = ?";


		List<MainVO> pList = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, p);
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
			System.out.println("여기실행됨"+pList);
			return pList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}
}
