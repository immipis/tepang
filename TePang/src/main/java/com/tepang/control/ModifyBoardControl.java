package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.BoardDAO;
import com.tepang.vo.BoardVO;


public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8"); //문자열
		
		BoardDAO bdao = new BoardDAO();
		
		String rc = req.getParameter("reply_code");
		String content = req.getParameter("reply_content");
		
		System.out.println(rc);
		System.out.println(content);
	
		BoardVO board = new BoardVO();
		board.setReplyCode(rc);
		board.setReplyContent(content);
		
		

		if(bdao.updateBoard(board)) {
			resp.sendRedirect("board.do?reply_code=" + rc);
		}else {
			req.getRequestDispatcher("WEB-INF/html/modifyForm.jsp").forward(req, resp);
		}

	}

}
