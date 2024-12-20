package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;
import com.tepang.jdbc.MainDAO;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MainDAO mdao = new MainDAO();
		req.setAttribute("products", mdao.addpList("user01"));
		req.getRequestDispatcher("WEB-INF/html/main.jsp").forward(req, resp);

	}

}
