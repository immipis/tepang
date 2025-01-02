package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tepang.common.Control;
import com.tepang.jdbc.MyPageDAO;
import com.tepang.vo.SingupVO;

public class MyInfoUpdatePageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MyPageDAO mpdo = new MyPageDAO();
		HttpSession session = req.getSession();
		String info = (String) session.getAttribute("member_id");
		SingupVO svo = mpdo.selectMember(info);
		req.setAttribute("mem", svo);
		req.getRequestDispatcher("WEB-INF/html/myinfoUpdate.jsp").forward(req, resp);
	}

}
