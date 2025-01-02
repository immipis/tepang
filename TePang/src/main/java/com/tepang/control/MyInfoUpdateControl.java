package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tepang.common.Control;
import com.tepang.jdbc.MyPageDAO;
import com.tepang.vo.SingupVO;



public class MyInfoUpdateControl implements Control {
// 개인정보 수정 ?? 
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		MyPageDAO mpdo = new MyPageDAO();		
		HttpSession session = req.getSession(); // 로그인 된 후 세션 값을 가져온다. 
		String mid = (String) session.getAttribute("member_id");

		
		String pw = req.getParameter("member_pw");
		String adr = req.getParameter("member_adr");
		String fv = req.getParameter("member_fv");
		
		System.out.println(mid);
		
		SingupVO sing = new SingupVO();
		

		sing.setMemberId(mid);
		sing.setMemberPw(pw);
		sing.setMemberAdr(adr);
		sing.setMemberFv(fv);

		System.out.println(pw);
		System.out.println(adr);
		System.out.println(fv);
		
		 // MyPageDAO mpdao = new MyPageDAO();
		
		if(mpdo.updateInfo(sing)) {
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}
	}

}
