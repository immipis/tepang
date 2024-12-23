package com.tepang.jdbc;

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
	public List<MainVO> addPvList(String logId) {
		getConn();
		String sql = "select a.* from (\r\n"
				+ "select  p.* ,   case \r\n"
				+ "          when p.category = m.member_fv then 1   \r\n"
				+ "          else 2\r\n"
				+ "          end order_by  \r\n"
				+ "from tbl_product p    \r\n"
				+ " left outer join(select member_fv       \r\n"
				+ "          from tbl_member       \r\n"
				+ "          where member_id = ? ) m \r\n"
				+ "on p.category = m.member_fv )a\r\n"
				+ "order by  a.order_by";
		List<MainVO> pList = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, logId);
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
			return pList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}
}
