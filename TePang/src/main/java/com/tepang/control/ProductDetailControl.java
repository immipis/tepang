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
		req.setCharacterEncoding("UTF-8");
		// ?pcode=C2
		String pno = req.getParameter("pcode");
		
		ProductDAO bdao = new ProductDAO();
		MainVO bvo = bdao.selectProduct(pno);
		
		req.setAttribute("product", bvo);
		
		
		// ?pcode=C2종료


		
		String rg =req.getParameter("rating");
		String ne =req.getParameter("name");
		String rew =req.getParameter("review");
		
	if(ne!=null){		
		System.out.println(ne);
		
		ProductDAO pdao = new ProductDAO();
		
		BoardVO bv = new BoardVO();
		
		bv.setReplyStar(Integer.parseInt(rg));
		bv.setMemberId(ne);
		bv.setReplyContent(rew);
		bv.setProductCode(pno);
		
		boolean isSuccessed = pdao.insertReply(bv);
		
		req.setAttribute("result", isSuccessed);
	}
		
		req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
//		if(Board) {
//			req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
//			
//		}else {
//			req.setAttribute("error","등록실패");
//			req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
//		}


	}

}
