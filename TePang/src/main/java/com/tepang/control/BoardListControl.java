package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.BoardDAO;
import com.tepang.vo.BoardVO;



public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html;charset=utf-8"); //문자열
		
		String type = req.getParameter("type");
		String page = req.getParameter("page");
		page = page == null ? "1" : page;


		BoardDAO bdao = new BoardDAO();
		List<BoardVO> list = bdao.selectBoard(type);
		
		req.setAttribute("list", list);
		

		req.getRequestDispatcher("WEB-INF/html/boardList.jsp").forward(req, resp);
	}

}
