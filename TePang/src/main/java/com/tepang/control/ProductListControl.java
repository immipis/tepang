package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tepang.common.Control;

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String title = req.getParameter("title");
		String searchText = req.getParameter("searchText");
		
		System.out.println("searchTextsearchText"+searchText);
		
		req.setAttribute("title", title);
		req.setAttribute("searchText", searchText);
		req.getRequestDispatcher("WEB-INF/html/productList.jsp").forward(req, resp);
	}

}
