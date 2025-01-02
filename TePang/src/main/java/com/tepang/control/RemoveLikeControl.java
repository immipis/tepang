package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.CartDAO;

public class RemoveLikeControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cnum = req.getParameter("cnum");
		System.out.println(cnum);
		CartDAO cdao = new CartDAO();
		
		if (cdao.removeLike(cnum)) {
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}
	}

}
