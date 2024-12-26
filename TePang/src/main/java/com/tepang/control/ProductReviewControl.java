package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tepang.common.Control;
import com.tepang.jdbc.ProductDAO;
import com.tepang.vo.BoardVO;

public class ProductReviewControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDAO bdao = new ProductDAO();
		
		HttpSession session = req.getSession();
		
		String id = (String) session.getAttribute("member_id");

		System.out.println(bdao);
		System.out.println(session);
		System.out.println(id);
		
		List<BoardVO> boards = bdao.selectBoard(id);
		req.setAttribute("boards", boards);
				
		req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);	

	}

}
