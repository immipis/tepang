package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tepang.common.Control;
import com.tepang.jdbc.TePangDAO;

public class TepangLoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		
		
		TePangDAO tdao = new TePangDAO();

		if (tdao.login(id, pw) != null) {
			HttpSession session = req.getSession();
			session.setAttribute("member_id", id);
			
			
			resp.sendRedirect("mainList.do");
		} else {
			resp.sendRedirect("tepnagloginForm.do");
		}

	}

}
