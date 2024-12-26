package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tepang.common.Control;
import com.tepang.jdbc.MyPageDAO;
import com.tepang.vo.SingupVO;

public class MyInfoControl implements Control {

	
		@Override
		public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			MyPageDAO mpdo = new MyPageDAO();		
			HttpSession session = req.getSession(); // 로그인 된 후 세션 값을 가져온다. 
			String info = (String) session.getAttribute("member_id");
			SingupVO svo = mpdo.selectMember(info);
			req.setAttribute("mem", svo);
			req.getRequestDispatcher("WEB-INF/html/myinfo.jsp").forward(req, resp);	
	}

}
