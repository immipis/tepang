package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;

public class searchControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String searchText = req.getParameter("searchText");
		System.out.println(searchText);

//		MainDAO mdao = new MainDAO();
//		List<MainVO> products2 = mdao.pList(title);
//		
//		req.setAttribute("title", title);
////		req.setAttribute("products2", products2);
//		req.getRequestDispatcher("WEB-INF/html/productList.jsp").forward(req, resp);
	}

}
