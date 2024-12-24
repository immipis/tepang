package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tepang.common.Control;
import com.tepang.jdbc.CartDAO;
import com.tepang.vo.CartVO;

public class CartListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		CartDAO cdao = new CartDAO();
		
		HttpSession session = req.getSession();
		
		String id = (String) session.getAttribute("member_id");

		System.out.println(id);
		
		List<CartVO> carts = cdao.cartList(id, "장바구니");
		req.setAttribute("carts", carts);
				
		req.getRequestDispatcher("WEB-INF/html/cart.jsp").forward(req, resp);	
	}
}
