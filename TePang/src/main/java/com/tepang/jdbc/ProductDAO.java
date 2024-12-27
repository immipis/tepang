package com.tepang.jdbc;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tepang.common.DAO;
import com.tepang.common.SearchDTO;
import com.tepang.vo.BoardVO;
import com.tepang.vo.MainVO;

public class ProductDAO extends DAO {

	// 상품 상세.
	public MainVO selectProduct(String pno) {
		getConn();
		String sql = "select * from tbl_product where product_code = ?";

		MainVO pvo = new MainVO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pno);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				pvo.setCategory(rs.getString("category"));
				pvo.setProductCode(rs.getString("product_Code"));
				pvo.setProductDetail(rs.getString("product_Detail"));
				pvo.setProductName(rs.getString("product_Name"));
				pvo.setProductPrice(rs.getInt("product_Price"));
				pvo.setProductImg(rs.getString("product_Img"));
				pvo.setProductDetImg(rs.getString("product_DetImg"));
				pvo.setProductStock(rs.getInt("product_Stock"));
				pvo.setProductSale(rs.getString("product_Sale"));


			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return pvo;
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
			String sql = "select b.*"
					+ "   from( select rownum rn, a.*"
					+ "         from (select *"
					+ "               from tbl_product";
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
		// 상세조회. 파라미터(int boardNo) selectBoard 반환값: BoardVO.
		public List<BoardVO> selectBoard(String id, String pno ) {

			getConn();

			List<BoardVO> list = new ArrayList<>();
			String sql = "select * from tbl_reply where product_code = ?";

			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(1, pno);
				rs = psmt.executeQuery(); // 조회.

				while (rs.next()) {
					BoardVO brd = new BoardVO();
					brd.setReplyCode(rs.getString("reply_code"));
					brd.setReplyContent(rs.getString("reply_content"));
					brd.setReplyAnswer(rs.getString("reply_answer"));
					brd.setMemberId(rs.getString("member_id"));
					brd.setReplyDate(rs.getDate("reply_date"));
					brd.setProductCode(rs.getString("product_code"));
					brd.setReplyType(rs.getString("reply_type"));
					brd.setReplyStar(rs.getInt("reply_star"));
					brd.setReplyImg(rs.getString("reply_img"));
					
					list.add(brd);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			}
			return list;
		}
		
		//파라미터 등록
		public boolean insertboard(BoardVO board) {
			getConn();
			String sql = "insert into tbl_board"
					+ "   (reply_Code, reply_Content, reply_Answer, member_Id, reply_Date, reply_Type, reply_Star, reply_Img, product_Code)"
					+ "   values(board_seq.nextval,?,?,?,?,?,?,?,? )";

			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, board.getReplyCode());
				psmt.setString(2, board.getReplyContent());
				psmt.setString(3, board.getReplyAnswer());
				psmt.setString(4, board.getMemberId());
//				psmt.setDate(5, board.getReplyDate());
				psmt.setString(6, board.getReplyType());
				psmt.setInt(7, board.getReplyStar());
				psmt.setString(8, board.getReplyImg());
				psmt.setString(9, board.getProductCode());
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

			public List<BoardVO> boardList(SearchDTO search) {
				getConn();
				String sql = "select b.*"
						+ "   from( select rownum rn, a.*"
						+ "         from (select *"
						+ "               from tbl_board";
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
				sql += "              order by product_code desc) a) b" + "   where b.rn > (? -1) * 5" + "   and b.rn <= ? * 5";
				// \r\n은 줄바꿈
				List<BoardVO> result = new ArrayList<>(); // 반환값.
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
						BoardVO brd = new BoardVO();
						brd.setProductCode(rs.getString("product_Code"));
						brd.setReplyCode(rs.getString("reply_Code"));
						brd.setReplyContent(rs.getString("reply_Content"));
						brd.setReplyAnswer(rs.getString("reply_Answer"));
						brd.setMemberId(rs.getString("member_Id"));
						brd.setReplyDate(rs.getDate("reply_Date"));
						brd.setReplyType(rs.getString("reply_Type"));
						brd.setReplyStar(rs.getInt("reply_Star"));
						brd.setReplyImg(rs.getString("reply_Img"));

						result.add(brd); // ArrayList에 추가.
					}

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					disConnect();
				}
				return result;
			}

			//댓글삭제
	public boolean deleteReply(String productCode) {
		getConn();
		String sql = "delete from tbl_reply where reply_code = ?";
		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, productCode);
			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r > 0) {
				System.out.println("삭제성공");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return false;
	}

	//댓글 등록
	public boolean insertReply(BoardVO rvo) {
		getConn();
		String sql = "insert into tbl_reply *reply_code, member_id, reply_content, reply_date, reply_img, reply_star, reply_type, reply_answer, product_code)"
				+ "				values(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement("select reply_seq.nextval from dual");
			rs = psmt.executeQuery();
			String rno = ""; // 쿼리실행.
			if (rs.next()) {
				rno = rs.getString(1);
				rvo.setProductCode(rno);
			}

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, rno);
			psmt.setString(2, rvo.getReplyContent());
			psmt.setString(3, rvo.getMemberId());
			psmt.setString(4, rvo.getReplyCode());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}

	//댓글건수반환.
	public String selectReplyconut(String ReplyCode) {
		getConn();
		String sql = "select count(1) from tbl_reply where reply_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ReplyCode);
			rs = psmt.executeQuery();
			
			//조회결과가 있으면...
			if(rs.next()) {
				return rs.getString(1); //1번째 칼럼.
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return "";//조회건수X, 쿼리X
	}


		}