package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tepang.common.Control;
import com.tepang.jdbc.MyPageDAO;
import com.tepang.vo.SingupVO;

public class MyInfoDropControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		MyPageDAO mpdo = new MyPageDAO();
		HttpSession session = req.getSession();
		
		SingupVO sing = new SingupVO();
		String mid = (String) session.getAttribute("member_id");
		
		sing.setMemberId(mid);
		
		System.out.println(mid);
		
		if(mpdo.deleteSearch(sing)&&mpdo.deleteReply(sing)&&mpdo.deleteOrder(sing)&&mpdo.deleteCart(sing)&&mpdo.deleteMember(sing)) {
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
			session.invalidate(); // 세션 초기화 (로그아웃)
		} else {
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}
	}

}
