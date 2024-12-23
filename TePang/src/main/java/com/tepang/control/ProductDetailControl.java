package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.vo.BoardVO;

public class ProductDetailControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardDAO bdao = new BoardDAO();
		
		if (req.getMethod().equals("GET")) {
			String bno = req. getParameter("board_no");
			String page = req.getParameter("page");
			String sc = req.getParameter("searchCondition");
			String kw = req.getParameter("keyword");
			
			BoardVO bvo = bdao.selectBoard(Integer.parseInt)
		}

	}

}
