package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.BoardDAO;
import com.tepang.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8"); //문자열
		
		String rc = req.getParameter("rc");
		String page = req.getParameter("page");
		page = page == null ? "1" : page;


		BoardDAO bdao = new BoardDAO();
		List<BoardVO> dlist = bdao.selectBoardDetail(rc);
		
		req.setAttribute("dlist", dlist);
		
		//요청재지정.
		req.getRequestDispatcher("WEB-INF/html/board.jsp").forward(req, resp);
	}

}
