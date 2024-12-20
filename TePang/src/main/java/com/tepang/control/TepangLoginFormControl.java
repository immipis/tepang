package com.tepang.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tepang.common.Control;

public class TepangLoginFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/html/tepanglogin.jsp").forward(req, resp);

	}

}
