package com.tepang.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tepang.common.DAO;
import com.tepang.vo.MainVO;
import com.tepang.vo.SingupVO;
import com.tepang.vo.TepangSearchVO;

public class TePangDAO extends DAO {

	public String login(String id, String pw) {

		getConn();
		String sql = "select * from tbl_member" + "            where member_id = ?" + "            and   member_pw = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getString("member_name");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	public boolean insertSignup(SingupVO singup) {
		getConn();
		System.out.println(singup);
		String sql = "insert into tbl_member (member_id,member_pw,member_name,member_phone,member_adr,member_bir,member_gen,member_fv)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, singup.getMemberId());
			psmt.setString(2, singup.getMemberPw());
			psmt.setString(3, singup.getMemberName());
			psmt.setString(4, singup.getMemberPhone());
			psmt.setString(5, singup.getMemberAdr());
			psmt.setString(6, singup.getMemberBir());
			psmt.setString(7, singup.getMemberGen());
			psmt.setString(8, singup.getMemberFv());

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

	public List<MainVO> search(String searchText) {
		

		getConn();
		String sql = "select * from tbl_product" 
		+ "            where product_name like '%'||?||'%' "
		+ "               or category like '%'||?||'%' "
		+ "				  or product_detail like '%'||?||'%' ";
		
		List<MainVO> pList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, searchText);
			psmt.setString(2, searchText);
			psmt.setString(3, searchText);
			
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
	
	
	public boolean addSearch(String id, String sText) {
		getConn();
		
		String sql = "insert into tbl_search(member_id, search_name)"
				+ "values (?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, sText);
			
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
	

	public List<String> searchHistory(String id) {
        getConn();
        List<String> searchHistory = new ArrayList<>();
        String sql = "SELECT search_name " +
                     "FROM ( " +
                     "    SELECT search_name " +
                     "    FROM tbl_search " +
                     "    WHERE member_id = ? " +
                     "    ORDER BY search_date DESC " +
                     ") " +
                     "WHERE ROWNUM <= 5";

        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);

            rs = psmt.executeQuery();
            while (rs.next()) {
                searchHistory.add(rs.getString("search_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disConnect();
        }

        return searchHistory;
    }



}

