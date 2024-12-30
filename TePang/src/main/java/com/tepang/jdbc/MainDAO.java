package com.tepang.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tepang.common.DAO;
import com.tepang.vo.MainVO;

public class MainDAO extends DAO{
	public List<MainVO> addpList(int page) {
	    int limit = 4;
	    int end = (page - 1) * limit;

	    String sql = "SELECT * FROM tbl_product ORDER BY product_name LIMIT ? OFFSET ?";
	    List<MainVO> pList = new ArrayList<>();
	    
	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setInt(1, limit);
	        psmt.setInt(2, end);
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disConnect();
	    }
	    return pList;
	}
	
	public List<MainVO> pCategoryList(String p) {
		getConn();

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
			return pList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}
	public List<MainVO> addPvList(String logId, int page) {
	    int limit = 4;
	    int end = (page - 1) * limit;

	    String sql = "SELECT a.* FROM ("
	            + "SELECT p.*, "
	            + "CASE "
	            + "WHEN p.category = m.member_fv THEN 1 "
	            + "ELSE 2 "
	            + "END AS order_by "
	            + "FROM tbl_product p "
	            + "LEFT JOIN (SELECT member_fv FROM tbl_member WHERE member_id = ?) m "
	            + "ON p.category = m.member_fv) a "
	            + "ORDER BY a.order_by, product_name "
	            + "LIMIT ? OFFSET ?";

	    List<MainVO> pList = new ArrayList<>();

	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setString(1, logId);  
	        psmt.setInt(2, limit);    
	        psmt.setInt(3, end);  
	        rs = psmt.executeQuery();

	        while (rs.next()) {
	            MainVO mvo = new MainVO();
	            mvo.setProductCode(rs.getString("product_code"));
	            mvo.setProductImg(rs.getString("product_img"));
	            mvo.setProductName(rs.getString("product_name"));
	            mvo.setProductPrice(rs.getInt("product_price"));
	            mvo.setProductDetail(rs.getString("product_detail"));
	            mvo.setCategory(rs.getString("category"));
	            pList.add(mvo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disConnect();
	    }
	    return pList;
	}
	
	public String ads(String id) {
		getConn();
		String sql = "select member_fv from tbl_member where member_id = ? ";
		String a = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				a = rs.getString("member_fv");
			}
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return a;
	}
}
