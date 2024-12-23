package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tepang.common.Control;
import com.tepang.jdbc.BoardDAO;
import com.tepang.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardDAO bdao = new BoardDAO();		
		
		if (req.getMethod().equals("GET")) {
			//파라미터(board_no); + page + searchCondition + keyword
			String bno = req.getParameter("reply_code");
			String page = req.getParameter("page");
			
			BoardVO bvo = bdao.selectBoard(bno); // 단건조회.

			req.setAttribute("board", bvo); // board의 속성에 조회된 결과를 전달.

			
			req.getRequestDispatcher("WEB-INF/html/board.jsp").forward(req, resp);
			
		} else if(req.getMethod().equals("POST")) {
			
			String replyCode = req.getParameter("replyCode");;
			String replyContent = req.getParameter("reply_content");			
			String memberId = req.getParameter("memberId");;
			//Date replyDate = req.getParameter("reply_date");;
			
			//위의 값을 가지고 BoardVO 생성
			BoardVO board = new BoardVO();
			board.setReplyContent(replyCode);
			board.setReplyContent(replyContent);
			board.setMemberId(memberId);
			//board.setReplyDate(replyDate);
			
			if(bdao.insertBoard(board)) {
				//목록이동.
				resp.sendRedirect("boardList.do"); //페이지 재 지정.
			}else {
				//등록화면으로 이동.
				req.getRequestDispatcher("WEB-INF/html/boardForm.jsp").forward(req, resp);				
			}
		}
		
		//요청재지정.
		req.getRequestDispatcher("WEB-INF/html/boardList.jsp").forward(req, resp);
	}

}
