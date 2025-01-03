package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tepang.common.Control;
import com.tepang.jdbc.MyPageDAO;
import com.tepang.vo.BoardVO;
import com.tepang.vo.ReplyVO;
import com.tepang.vo.SingupVO;

public class MyReplyDeleteControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyPageDAO mpdo = new MyPageDAO();
		HttpSession session = req.getSession();
		String mid = (String) session.getAttribute("member_id");
		SingupVO svo = mpdo.selectMember(mid); 
		req.setAttribute("memId", svo);
		
		BoardVO bvo = new BoardVO();
		String type = req.getParameter("type");
		bvo.setMemberId(mid);
		bvo.setReplyType(type);
		
		type = type == null ? "notice" : type;
		
		if(mpdo.deleteMyReply(mid, type)) {
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}	
		
		
	}

}
