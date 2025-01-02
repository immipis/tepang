package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.BoardDAO;
import com.tepang.vo.BoardVO;

public class ModifyFormControl implements Control {
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		String rc = req.getParameter("replyCode");	

		
		System.out.println("수정할 게시판 번호"+rc);
		BoardDAO bdao = new BoardDAO();
		
		BoardVO board = new BoardVO();
		List<BoardVO> dlist = bdao.selectBoardDetail(rc);
		
		req.setAttribute("dlist", dlist);
		req.setAttribute("reply_code", rc);
		
		req.getRequestDispatcher("WEB-INF/html/modifyForm.jsp").forward(req, resp);

	}

}
