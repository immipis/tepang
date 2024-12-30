package com.tepang.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tepang.common.DAO;
import com.tepang.vo.OrderVO;
import com.tepang.vo.SingupVO;

public class MyPageDAO extends DAO {
	
	// 기본 페이지 : 회원별 누적 구매 리스트
public List<OrderVO> orderList(String memberId) {
		getConn();
		List<OrderVO> olist = new ArrayList<>();
		String osql = " SELECT * "//
				    + "   FROM tbl_order "//
				    + "  WHERE member_id = ? ";//
		try {
			psmt = conn.prepareStatement(osql);
			psmt.setString(1, memberId);
			
			rs = psmt.executeQuery();

			while (rs.next()) {
				OrderVO ovo = new OrderVO();
				ovo.setCartNum(rs.getString("cart_num"));
				ovo.setMemberId(rs.getString("member_id"));
				ovo.setOrderContent(rs.getString("order_content"));
				ovo.setOrderSum(rs.getInt("order_sum"));
				olist.add(ovo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return olist;
		
	}

// 마이페이지 상세 (개인정보)
public SingupVO selectMember(String memberId) {
	getConn();
	String ssql = " SELECT * "//
			+ "   FROM tbl_member "//
			+ "  WHERE member_id = ? ";//
	try {
		psmt = conn.prepareStatement(ssql);
		psmt.setString(1, memberId);
		rs = psmt.executeQuery();
		
		if (rs.next()) {
			SingupVO svo = new SingupVO();
			svo.setMemberId(rs.getString("member_id"));
			svo.setMemberPw(rs.getString("member_pw"));
			svo.setMemberName(rs.getString("member_name"));
			svo.setMemberPhone(rs.getString("member_phone"));
			svo.setMemberAdr(rs.getString("member_adr"));
			svo.setMemberBir(rs.getString("member_bir"));
			svo.setMemberGen(rs.getString("member_gen"));
			svo.setMemberFv(rs.getString("member_fv"));
			svo.setMemberTier(rs.getString("member_tier"));
			return svo;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		disConnect();
	}
	return null;
}
	// 개인정보 수정
	public boolean updateInfo(SingupVO info) {
		getConn();
		String memql = " UPDATE tbl_member "//
				     + "    SET member_pw = ?, "
				     + "        member_adr = ?, "
				     + "        member_fv = ? "//
				     + "  WHERE member_id = ? ";//
		try {
			psmt = conn.prepareStatement(memql);
			psmt.setString(1, info.getMemberPw());
			psmt.setString(2, info.getMemberAdr());
			psmt.setString(3, info.getMemberFv());
			psmt.setString(4, info.getMemberId());
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
	
	// 서치 테이블의 데이터 삭제
	public boolean deleteSearch(SingupVO info) {
		getConn();
		String dsql = " DELETE FROM tbl_search "
				    + "  WHERE member_id = ? ";
		try {
			psmt = conn.prepareStatement(dsql);
			psmt.setString(1, info.getMemberId());
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
	
	// 리뷰 테이블 데이터 삭제
	public boolean deleteReply(SingupVO info) {
		getConn();
		String dsql = " DELETE FROM tbl_reply "
				    + "  WHERE member_id = ? ";
		try {
			psmt = conn.prepareStatement(dsql);
			psmt.setString(1, info.getMemberId());
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
	
	// 오더 테이블 데이터 삭제
	public boolean deleteOrder(SingupVO info) {
		getConn();
		String dsql = " DELETE FROM tbl_order "
				    + "  WHERE member_id = ? ";
		try {
			psmt = conn.prepareStatement(dsql);
			psmt.setString(1, info.getMemberId());
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
	// 카트 테이블 데이터 삭제
	public boolean deleteCart(SingupVO info) {
		getConn();
		String dsql = " DELETE FROM tbl_cart "
				    + "  WHERE member_id = ? ";
		try {
			psmt = conn.prepareStatement(dsql);
			psmt.setString(1, info.getMemberId());
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
	
	// 회원탈퇴
	public boolean deleteMember(SingupVO info) {
		getConn();
		String dsql = " DELETE FROM tbl_member "
				    + "  WHERE member_id = ? ";
		try {
			psmt = conn.prepareStatement(dsql);
			psmt.setString(1, info.getMemberId());
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
