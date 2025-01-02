package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.ProductDAO;
import com.tepang.vo.BoardVO;
import com.tepang.vo.MainVO;

public class ProductDetailControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ?pcode=C2
		String pno = req.getParameter("pcode");
		String name =req.getParameter("name");
		String rating =req.getParameter("rating");
		String review =req.getParameter("review");
		
		System.out.println(req.getParameter("name"));
		
		ProductDAO pdao = new ProductDAO();
		
		MainVO bvo = pdao.selectProduct(pno);
		BoardVO bv = new BoardVO();
		
		bv.setMemberId(name);
		bv.setReplyStar(Integer.parseInt(rating));
		bv.setReplyContent(review);
		
	//	ProductDAO pdao = new ProductDAO();
		boolean Board = pdao.insertReply(bv);
		req.setAttribute("product", bvo);
		req.setAttribute("reply", Board);
		
		if(Board) {
			req.getRequestDispatcher("WEB-INF/html/tepangLogin.jsp").forward(req, resp);
			
		}else {
			req.setAttribute("error","등록실패");
			req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
		}


	}

}
