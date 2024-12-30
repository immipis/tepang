package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.ProductDAO;
import com.tepang.vo.BoardVO;

public class AddReviewControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// parameter(bno, replyer, reply)
		req.setCharacterEncoding("UTF-8");
		
		String mi =req.getParameter("mi");
		String ri =req.getParameter("ri");
		//Integer rs =req.getParameter("rs");
		String pc =req.getParameter("pc");
		System.out.println(req.getParameter("rs"));
		
		if ( mi == null || mi.trim().isEmpty()
				|| ri == null || ri.trim().isEmpty()
			//	|| rs == null || rs.trim().isEmpty()
				|| pc == null || pc.trim().isEmpty()) {
		req.setAttribute("error", "등록실패");
		req.getRequestDispatcher("WEB-INF/html/addReview.do").forward(req, resp);
		
		}
		
		BoardVO bv = new BoardVO();
		
		bv.setMemberId(mi);
		bv.setReplyImg(ri);
		//bv.setReplyStar(rs);
		bv.setProductCode(pc);
		
		ProductDAO pdao = new ProductDAO();
		boolean Board = pdao.insertReply(bv);
		if(Board) {
			req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
		}else {
			req.setAttribute("error","등록실패");
			req.getRequestDispatcher("WEB-INF/html/addReview.do").forward(req, resp);
		}
	}
}
