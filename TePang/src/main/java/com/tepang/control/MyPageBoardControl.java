package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.MyPageDAO;
import com.tepang.vo.SingupVO;



public class MyPageBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MyPageDAO mpdo = new MyPageDAO();
		if(req.getMethod().equals("GET")) {
			
			String mi = req.getParameter("member_id");
			SingupVO svo = mpdo.selectmember(mi);
			

			req.setAttribute("member_id", svo);
			req.getRequestDispatcher("WEB-INF/html/myPage.jsp").forward(req, resp);
		} else if (req.getMethod().equals("POST")) {
	
		}

	}

}
