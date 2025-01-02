package com.tepang.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tepang.common.DAO;
import com.tepang.vo.BoardVO;
import com.tepang.vo.CartVO;
import com.tepang.vo.OrderVO;
import com.tepang.vo.SingupVO;

public class MyPageDAO extends DAO {
	
	// 기본 페이지 : 회원별 누적 구매 리스트

	public List<OrderVO> selectMyPriceList(String memberId){
		getConn();
		List<OrderVO> olist = new ArrayList<>();
		String sql = "SELECT * "
				   + "  FROM tbl_order "
				   + " WHERE member_id = ? ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberId);
			rs = psmt.executeQuery();
			while(rs.next()) {
				OrderVO ovo = new OrderVO();
				
				ovo.setOrderNo(rs.getString("order_no"));
				ovo.setOrderName(rs.getString("order_name"));
				ovo.setOrderSum(rs.getInt("order_sum"));
				ovo.setOrderDay(rs.getString("order_day"));
				
				olist.add(ovo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		} return olist;
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
	// 내가 쓴 문의 리스트 
	public List<BoardVO> selectMyReply(String replyType, String memberId){
		getConn();
		List<BoardVO> mlist = new ArrayList<>();
		String rql = "SELECT * "
				   + "  FROM tbl_reply "
				   + " WHERE reply_type = ? "
				   + "   AND member_id = ? ";

		try {
			psmt = conn.prepareStatement(rql);
			psmt.setString(1, replyType);
			psmt.setString(2, memberId);

			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setReplyCode(rs.getString("reply_code"));
				brd.setReplyContent(rs.getString("reply_content"));
				brd.setReplyAnswer(rs.getString("reply_answer"));
				brd.setMemberId(rs.getString("member_id"));
				brd.setReplyDate(rs.getDate("reply_date"));
				
				mlist.add(brd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		} return mlist; 
	} 
	// 내가 쓴 리뷰 리스트 
	public List<BoardVO> selectMyReview(String replyType, String memberId){
		getConn();
		List<BoardVO> rlist = new ArrayList<>();
		String vql = " SELECT p.product_name, "
				   + "        r.reply_code, "
				   + "        r.reply_content, "
				   + "        r.reply_date "
				   + "   FROM tbl_reply r, tbl_product p "
				   + "  WHERE r.product_code = p.product_code "
				   + "    AND reply_type = ? "
				   + "    AND member_id = ? ";
		
		try {
			psmt = conn.prepareStatement(vql);
			psmt.setString(1, replyType);
			psmt.setString(2, memberId);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setProductName(rs.getString("product_name"));
				brd.setReplyCode(rs.getString("reply_code"));
				brd.setReplyContent(rs.getString("reply_content"));
				brd.setReplyDate(rs.getDate("reply_date"));
				rlist.add(brd);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return rlist;
	}
	// 내가 한 찜 목록 불러오기
	public List<CartVO> selectMyHeart(String type, String mid){
		getConn();
		List<CartVO> clist = new ArrayList<>();
		
		String hql = "SELECT p.product_name, " //
				   + "       p.product_price, " // 
				   + "       p.product_img,  "// 
				   + "       p.category "// 
				   + "  FROM tbl_cart c, tbl_product p " // 
				   + " WHERE c.product_code = p.product_code "//
				   + "   AND cart_type = ? " // 
				   + "   AND member_id = ? "; // 
		try {
			psmt = conn.prepareStatement(hql);
			psmt.setString(1, type);
			psmt.setString(2, mid);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CartVO crt = new CartVO();
				crt.setProductName(rs.getString("product_name"));
				crt.setProductPrice(rs.getInt("product_price"));
				crt.setProductImg(rs.getString("product_img"));
				crt.setCategory(rs.getString("category"));
				
				clist.add(crt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		} return clist;
	}
	
	
	
	// 찜 추가 
	public boolean addHeart(CartVO cart) {
		getConn();
		String sql = " INSERT INTO tbl_cart(cart_num, product_code, member_id, cart_type) "// 
				   + " VALUES (?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cart.getCartNum());
			psmt.setString(2, cart.getProductCode());
			psmt.setString(3, cart.getMemberId());
			psmt.setString(4, cart.getCartType());
			int r = psmt.executeUpdate();
			if(r > 0) {
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
