package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.MyPageDAO;
import com.tepang.vo.OrderVO;

public class MyPageListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("member_id");
		id = id == null ? "1" : id;
		
		MyPageDAO mpdo = new MyPageDAO();
		List<OrderVO> olist = mpdo.orderList(id);
		
		req.setAttribute("list", olist);
		req.getRequestDispatcher("WEB-INF/html/myPage.jsp");
		System.out.println("list");

	}

}
