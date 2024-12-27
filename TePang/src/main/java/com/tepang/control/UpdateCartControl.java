package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.CartDAO;
import com.tepang.vo.CartVO;

public class UpdateCartControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pnum = req.getParameter("product_num");
		String memid = req.getParameter("member_id");
		String pname = req.getParameter("product_name");
		
		CartVO cvo = new CartVO();
		
		cvo.setProductNum(Integer.parseInt(pnum));
		cvo.setMemberId(memid);
		cvo.setProductName(pname);
		
		CartDAO cdao = new CartDAO();
		
		if (cdao.updateCart(cvo)) {
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}	
	
	
	}

}
