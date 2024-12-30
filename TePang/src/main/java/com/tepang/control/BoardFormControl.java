package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.BoardFormDAO;
import com.tepang.vo.BoardVO;

public class BoardFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("utf-8"); //문자열
		BoardFormDAO formdao = new BoardFormDAO();		
	
			
			//로그인 되면
			if(req.getMethod().equals("POST")) {
				
				String id = req.getParameter("member_id");//
				String content = req.getParameter("reply_content");
				String rt = req.getParameter("reply_type");
				
				BoardVO board = new BoardVO();
				board.setMemberId(id);
				board.setReplyContent(content);
				board.setReplyType(rt);
				
				resp.setContentType("text/html;charset=utf-8"); 
				
				if(formdao.insertBoard(board)) {
					//목록이동.
					resp.sendRedirect("boardList.do"); //페이지 재 지정.
					
				}else {
					
					req.getRequestDispatcher("WEB-INF/html/boardList.jsp").forward(req, resp);
				}	
						
		}	
	

	}

}
