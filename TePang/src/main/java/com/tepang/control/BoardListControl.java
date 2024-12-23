package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;


public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = req.getParameter("page");
		page = page == null ? "1" : page;

		
		resp.sendRedirect("boardList.do");
		
		//요청재지정.
		req.getRequestDispatcher("WEB-INF/html/boardList.jsp").forward(req, resp);
	}

}
