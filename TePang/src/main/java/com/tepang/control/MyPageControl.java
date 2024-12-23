package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.MyPageDAO;

public class MyPageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MyPageDAO mpdo = new MyPageDAO(); // myPageDAO 가져옴...
		if(req.getMethod().equals("GET")){ // req의 메소드 중 GET을 찾음
			String mi = req.getParameter("id"); // id를 parameter로 받아온다 
		
			MyPageDAO mdao = new MyPageDAO(); // 
			
			req.setAttribute("member", mdao);
			req.getRequestDispatcher("WEB-INF/html/myPage.jsp").forward(req, resp);
		} 

		

	}

}
