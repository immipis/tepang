package com.tepang.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		
//		req.setCharacterEncoding("UTF-8");
		
		String mi =req.getParameter("mi");
		String rs =req.getParameter("rs");
		String pc =req.getParameter("pc");
		
//		if ( mi == null || mi.trim().isEmpty()
//				|| rs == null || rs.trim().isEmpty()
//				|| pc == null || pc.trim().isEmpty()) {
//		req.setAttribute("error", "등록실패");
//		req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
//		
//		}
		
		BoardVO bv = new BoardVO();
		
		bv.setMemberId(mi);
		bv.setReplyStar(Integer.parseInt(rs));
		bv.setProductCode(pc);
		
		ProductDAO pdao = new ProductDAO();
	//	BoardVO bv = pdao.insertReply(pc);
		boolean Board = pdao.insertReply(bv);
	//	if(Board) {
			req.setAttribute("reply", Board);
	//		req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
			
	//	}else {
	//		req.setAttribute("error","등록실패");
			req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
	//	}
		
		
	}
}
